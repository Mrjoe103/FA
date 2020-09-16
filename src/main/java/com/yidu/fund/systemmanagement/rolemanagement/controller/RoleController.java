package com.yidu.fund.systemmanagement.rolemanagement.controller;

import com.yidu.fund.systemmanagement.rolemanagement.service.RoleService;
import com.yidu.fund.systemmanagement.rolemanagement.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的描述：
 *
 * @author 李检保
 * @version 1.0
 * @since 2020/09/04
 */
@Controller
@RequestMapping("Role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色并分页
     * @param page 页数
     * @param limit
     * @return
     */
    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> doQueryAllRoleWithPage(int page,int limit){
        Map<String,Integer> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        List<Role> roles = roleService.findAllRoleWithPaging(map);
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("code", 0);
        jsonMap.put("msg", "成功");
        jsonMap.put("data", roles);
        jsonMap.put("count", 10);
        return jsonMap;
    }

    /**
     * 条件查询
     * @param page 页数
     * @param limit 每页显示数
     * @param roleName 角色名
     * @param usable 是否可用
     * @return 符合laiui格式的角色集合
     */
    @RequestMapping(value = "findRoleByCdWithPaging",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findRoleByCdWithPaging(int page,int limit,String roleName,String usable){
        System.out.println("roleName:" + roleName + ",usable:" + usable);
        Map<String,Object> map = new HashMap<>();
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        map.put("roleName",roleName);
        map.put("usable",usable);
        List<Role> roles = roleService.findRoleByCdWithPaging(map);
        Map<String,Object> jsonMap = new HashMap<>();
        jsonMap.put("code",0);
        jsonMap.put("msg","成功");
        jsonMap.put("data",roles);
        jsonMap.put("count",10);
        return jsonMap;
    }

    @RequestMapping(value = "addRole",method = RequestMethod.POST)
    @ResponseBody
    public String doAddUser(Role role){
        return roleService.addRole(role)?"YES":"NO";
    }

    @RequestMapping(value = "updateRole",method = RequestMethod.POST)
    @ResponseBody
    public String doUpdateUser(Role role){
        return roleService.updateRole(role)?"YES":"NO";
    }



}
