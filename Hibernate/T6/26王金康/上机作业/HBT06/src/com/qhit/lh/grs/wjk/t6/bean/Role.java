package com.qhit.lh.grs.wjk.t6.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String rname;
	private String mome;

	private Set<User> users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/**
	 * @param roleid
	 * @param rname
	 * @param mome
	 * @param users
	 */
	public Role(Integer roleid, String rname, String mome, Set<User> users) {
		super();
		this.roleid = roleid;
		this.rname = rname;
		this.mome = mome;
		this.users = users;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/** full constructor */
	public Role(String rname, String mome) {
		this.rname = rname;
		this.mome = mome;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getMome() {
		return this.mome;
	}

	public void setMome(String mome) {
		this.mome = mome;
	}

}