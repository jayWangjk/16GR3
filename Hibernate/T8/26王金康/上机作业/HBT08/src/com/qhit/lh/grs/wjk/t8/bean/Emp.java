package com.qhit.lh.grs.wjk.t8.bean;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String ename;
	private String sex;
	private String birthday;
	private Integer deptid;

	// Constructors

	// 1-1
	private User user;

	// n-1
	private Dept dept;


	/**
	 * @param ename
	 * @param sex
	 * @param birthday
	 * @param deptid
	 */
	public Emp(String ename, String sex, String birthday, Integer deptid) {
		super();
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.deptid = deptid;
	}


	/**
	 * @param eid
	 * @param ename
	 * @param sex
	 * @param birthday
	 * @param deptid
	 * @param user
	 * @param dept
	 */
	public Emp(Integer eid, String ename, String sex, String birthday, Integer deptid, User user, Dept dept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.deptid = deptid;
		this.user = user;
		this.dept = dept;
	}
	
	/**
	 * 
	 */
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the eid
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * @param eid the eid to set
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the dept
	 */
	public Dept getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(Dept dept) {
		this.dept = dept;
	}

}