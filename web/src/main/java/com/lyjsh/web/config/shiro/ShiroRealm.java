package com.lyjsh.web.config.shiro;

import com.lyjsh.entity.system.Permission;
import com.lyjsh.entity.system.Role;
import com.lyjsh.entity.system.User;
import com.lyjsh.system.dao.PermDao;
import com.lyjsh.system.dao.RoleDao;
import com.lyjsh.system.dao.UserDao;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo  = (User)principals.getPrimaryPrincipal();
        for (Permission permission :userInfo.getPermissionList()) {
            authorizationInfo.addStringPermission(permission.getPermValue());
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User userInfo = userDao.getByUserName(username);
        if(userInfo == null){
            return null;
        }
        //获取用户拥有角色、权限信息
        List<Role> roleList = roleDao.listByUserId(userInfo.getId());
        List<Permission> permissionList = permDao.listByUserId(userInfo.getId());
        userInfo.setRoleList(roleList);
        userInfo.setPermissionList(permissionList);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPwd(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username
                getName()  //realm name
        );
        return authenticationInfo;
    }
}