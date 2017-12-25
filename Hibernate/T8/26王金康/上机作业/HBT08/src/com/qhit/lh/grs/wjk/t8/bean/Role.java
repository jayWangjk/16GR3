package com.qhit.lh.grs.wjk.t8.bean;

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

	/**
	 * @param rname
	 * @param mome
	 */
	public Role(String rname, String mome) {
		super();
		this.rname = rname;
		this.mome = mome;
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
	 * 
	 */
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the roleid
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the rname
	 */
	public String getRname() {
		return rname;
	}

	/**
	 * @param rname the rname to set
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

	/**
	 * @return the mome
	 */
	public String getMome() {
		return mome;
	}

	/**
	 * @param mome the mome to set
	 */
	public void setMome(String mome) {
		this.mome = mome;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

}