package com.qhit.lh.grs.wjk.t8.bean;

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
	private Set<Role> roles = new HashSet(0);
	
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
	 * @param uid
	 * @param uname
	 * @param password
	 * @param emp
	 */
	public User(Integer uid, String uname, String password, Emp emp) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.emp = emp;
	}
	/**
	 * @param uname
	 * @param password
	 */
	public User(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
}