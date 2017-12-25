package com.qhit.lh.grs.wjk.t7.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Integer deptid;
	private String tname;
	private String address;
	
	//1-n
	private Set<Emp> emps = new HashSet(0);
	// Constructors

	
	/** default constructor */
	public Dept() {
	}

	/**
	 * @param deptid
	 * @param tname
	 * @param address
	 * @param emps
	 */
	public Dept(Integer deptid, String tname, String address, Set<Emp> emps) {
		super();
		this.deptid = deptid;
		this.tname = tname;
		this.address = address;
		this.emps = emps;
	}

	/**
	 * @return the emps
	 */
	public Set<Emp> getEmps() {
		return emps;
	}

	/**
	 * @param emps the emps to set
	 */
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	/** full constructor */
	public Dept(String tname, String address) {
		this.tname = tname;
		this.address = address;
	}

	// Property accessors

	public Integer getDeptid() {
		return this.deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}