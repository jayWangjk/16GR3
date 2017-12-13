/**
 * 
 */
package com.qhit.lh.grs.wjk.t3.bean;

/**
 * @author 王金康
 * TODO
 * 2017年12月13日上午10:22:42
 */
public class Dept {
	private int deptid;
	private String tname;
	private String address;
	
	private Emp emp;

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(int deptid, String tname, String address, Emp emp) {
		super();
		this.deptid = deptid;
		this.tname = tname;
		this.address = address;
		this.emp = emp;
	}

	public Dept(int deptid, String tname, String address) {
		super();
		this.deptid = deptid;
		this.tname = tname;
		this.address = address;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}
