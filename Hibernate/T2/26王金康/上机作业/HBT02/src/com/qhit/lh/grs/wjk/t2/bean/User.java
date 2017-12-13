/**
 * 
 */
package com.qhit.lh.grs.wjk.t2.bean;

/**
 * @author 王金康
 * TODO
 * 2017年12月13日上午9:22:45
 */
public class User {
	
	private int uid;
	private String uname;
	private String password;
	
	private Emp emp;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uid, String uname, String password) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
	}

	public User(int uid, String uname, String password, Emp emp) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.emp = emp;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}	
