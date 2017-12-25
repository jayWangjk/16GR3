package com.qhit.lh.grs.wjk.t7.bean;

import java.util.HashSet;
import java.util.Set;

import com.qhit.lh.grs.wjk.t7.bean.Emp;
import com.qhit.lh.grs.wjk.t7.bean.Role;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String password;
	
	// 1-1
	private Emp emp;
	// m-n
	private Set<Role> roles = new HashSet(0);
	
	// Constructors
	
	
	/** default constructor */
	public User() {
	}

	/**
	 * @param uid
	 * @param uname
	 * @param password
	 * @param roles
	 */
	public User(Integer uid, String uname, String password, Set<com.qhit.lh.grs.wjk.t7.bean.Role> roles) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.roles = roles;
	}

	/**
	 * @param uid
	 * @param uname
	 * @param password
	 * @param emp
	 */
	public User(Integer uid, String uname, String password, com.qhit.lh.grs.wjk.t7.bean.Emp emp) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.emp = emp;
	}

	/**
	 * @return the emp
	 */
	public Emp getEmp() {
		return emp;
	}

	/**
	 * @param emp the emp to set
	 */
	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/** full constructor */
	public User(String uname, String password) {
		this.uname = uname;
		this.password = password;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}