package com.lyjsh.web.config.shiro;

import com.lyjsh.system.dao.PermDao;
import com.lyjsh.system.dao.RoleDao;
import com.lyjsh.system.dao.UserDao;
import com.lyjsh.entity.system.Permission;
import com.lyjsh.entity.system.Role;
import com.lyjsh.entity.system.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    //一般这里都写的是servic，我省略了service的接口和实现方法直接调用的dao
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermDao permDao;

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查出是否有此用户
        User userIndb = userDao.getByUserName(token.getUsername());
//        String md5Pwd = new Md5Hash("123", "lucare",2).toString();
        if (userIndb != null) {
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            List<Role> rlist = roleDao.listByUserId(userIndb.getId());//获取用户角色
            List<Permission> plist = permDao.listByUserId(userIndb.getId());//获取用户权限
            List<String> roleStrlist = new ArrayList<String>();////用户的角色集合
            List<String> perminsStrlist = new ArrayList<String>();//用户的权限集合
            for (Role role : rlist) {
                roleStrlist.add(role.getName());
            }
            for (Permission uPermission : plist) {
                perminsStrlist.add(uPermission.getName());
            }
            userIndb.setRoleStrlist(roleStrlist);
            userIndb.setPerminsStrlist(perminsStrlist);
//            Session session = SecurityUtils.getSubject().getSession();
//            session.setAttribute("user", userIndb);//成功则放入session
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            return new SimpleAuthenticationInfo(userIndb, userIndb.getPwd(), getName());
        }
        return null;
    }

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
//        String loginName = (String) super.getAvailablePrincipal(principalCollection);
        User user = (User) principalCollection.getPrimaryPrincipal();
//        //到数据库查是否有此对象
//        User user = null;// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        user = userMapper.findByName(loginName);
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getRoleStrlist());
            //用户的权限集合
            info.addStringPermissions(user.getPerminsStrlist());

            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }
}