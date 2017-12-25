package com.qhit.lh.grs.wjk.t8.bean;

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

	// Constructors

	// 1-n
	private Set<Emp> emps = new HashSet<>();
	
	/**
	 * @param tname
	 * @param address
	 * @param emps
	 */
	public Dept(String tname, String address, Set<Emp> emps) {
		super();
		this.tname = tname;
		this.address = address;
		this.emps = emps;
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
	 * 
	 */
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the deptid
	 */
	public Integer getDeptid() {
		return deptid;
	}

	/**
	 * @param deptid the deptid to set
	 */
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}

	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	
	
}