package com.qhit.lh.grs.wjk.t6.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String password;

	// Constructors

	// 1-1
	private Emp emp;
	// m-n
	private Set<Role> roles = new HashSet<Role>(0);

	/**
	 * @param uid
	 * @param uname
	 * @param password
	 * @param emp
	 * @param roles
	 */
	public User(Integer uid, String uname, String password, Emp emp, Set<Role> roles) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.emp = emp;
		this.roles = roles;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	/** default constructor */
	public User() {
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