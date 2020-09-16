package com.yidu.fund.systemmanagement.rolemanagement.mapper;

import com.yidu.fund.systemmanagement.rolemanagement.domain.Role;

import java.util.List;
import java.util.Map;

/**
 * 类的描述：
 *
 * @author 李检保
 * @version 1.0
 * @since 2020/09/04
 */
public interface RoleDao {

    /**
     * 查询所有角色并进行分页
     * @param paramMap  分页参数 包含页码pageIndex、分页大小pageSize两个参数
     * @return 指定页面的用户集合
     */
    List<Role> findAllRoleWithPaging(Map<String,Integer> paramMap);

    /**
     * 添加用户
     * @param role 要添加的用户
     * @return 添加成功返回true，否则返回false
     */
    boolean addRole(Role role);

    /**
     * 根据角色名查询角色并分页
     * @param paramMap 分页参数
     * @return 指定页面的角色集合
     */
    List<Role> findRoleByCdWithPaging(Map<String,Object> paramMap);
    /**
     * 修改用户
     * @param role 要修改的用户
     * @return 修改成功返回1，否则返回0
     */

    boolean updateRole(Role role);

    /**
     * 根据用户ID删除用户 物理删除 一般不用
     * @param roleId 用户ID
     * @return 删除成功返回1，否则返回0
     */
    int deleteRole(String roleId);
}
