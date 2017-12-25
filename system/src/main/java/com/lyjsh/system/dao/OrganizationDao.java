package com.lyjsh.system.dao;

import com.lyjsh.entity.system.Organization;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface OrganizationDao extends BaseMapper<Organization>{

    Organization getByName(String orgName);

    //查找id不等于自身的其它数据是否有相同名称
    Organization getByNameIdNot(@Param("orgName") String orgName,@Param("orgId") Integer orgId);

    List<Organization> listOrg(Organization organization);

    int getUserTotal(Integer orgId);

    Organization getById(Integer id);

    List<Organization> listAllOrg(Organization organization);

    List<Integer> listAllOrgIds(int rootId);
}
