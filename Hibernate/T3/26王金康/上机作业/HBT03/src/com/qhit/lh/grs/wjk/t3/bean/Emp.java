/**
 * 
 */
package com.qhit.lh.grs.wjk.t3.bean;

/**
 * @author 王金康
 * TODO
 * 2017年12月13日上午9:21:05
 */
public class Emp {
	
	private int eid;
	private String ename;
	private String sex;
	private String birthday;
	private int deptid;
	
	private User user;
	private Dept dept;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Emp(int eid, String ename, String sex, String birthday, int deptid, User user, Dept dept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.deptid = deptid;
		this.user = user;
		this.dept = dept;
	}

	public Emp(int eid, String ename, String sex, String birthday, int deptid) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.deptid = deptid;
	}
	
	public Emp(int eid, String ename, String sex, String birthday, int deptid, User user) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.deptid = deptid;
		this.user = user;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
