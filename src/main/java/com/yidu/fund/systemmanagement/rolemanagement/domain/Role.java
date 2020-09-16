package com.yidu.fund.systemmanagement.rolemanagement.domain;


import java.io.Serializable;

/**
 * POJO_Description: Role
 * @author liJianBao
 * @since 2020-09-04
 */
public class Role implements Serializable{

	private static final long serialVersionUID =  7922290771677236275L;
	private String roleId;

	private String roleName;

	private String usable;

	private String roleAbbr;

	private String description;


	public Role() {

	}


	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUsable() {
		return usable;
	}

	public void setUsable(String usable) {
		this.usable = usable;
	}

	public String getRoleAbbr() {
		return roleAbbr;
	}

	public void setRoleAbbr(String roleAbbr) {
		this.roleAbbr = roleAbbr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role{" +
				"roleId='" + roleId + '\'' +
				", roleName='" + roleName + '\'' +
				", usable='" + usable + '\'' +
				", roleAbbr='" + roleAbbr + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
