package com.yidu.fund.systemmanagement.rolemanagement.service.Impl;

import com.yidu.fund.systemmanagement.rolemanagement.service.RoleService;
import com.yidu.fund.systemmanagement.rolemanagement.mapper.RoleDao;
import com.yidu.fund.systemmanagement.rolemanagement.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 类的描述：
 *
 * @author 李检保
 * @version 1.0
 * @since 2020/09/04
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAllRoleWithPaging(Map<String, Integer> paramMap) {
        return roleDao.findAllRoleWithPaging(paramMap);
    }
    /**
     * 根据角色名查询角色并分页
     * @param paramMap 分页参数
     * @return 指定页面的角色集合
     */
    @Override
    public List<Role> findRoleByCdWithPaging(Map<String, Object> paramMap) {
        return roleDao.findRoleByCdWithPaging(paramMap);
    }

    @Override
    public boolean addRole(Role role) {
        handleRole(role);
        return roleDao.addRole(role);
    }


    @Override
    public boolean updateRole(Role role) {
        handleRole(role);
        return roleDao.updateRole(role);
    }

    @Override
    public int deleteRole(String roleId) {
        return 0;
    }

    /**
     * 为用户对象密码加密和用户描述去空
     * @param role 角色对象
     */
    private void handleRole(Role role) {
        if (role.getDescription()!= null) {
            //去除文本域中的空格
            String trim = role.getDescription().trim();
            role.setDescription(trim);
        }
    }
}

