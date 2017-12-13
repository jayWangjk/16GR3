/**
 * 
 */
package com.grs.wjk;

import static org.junit.Assert.*;

import com.qhit.lh.grs.wjk.t2.bean.Emp;
import com.qhit.lh.grs.wjk.t2.bean.User;
import com.qhit.lh.grs.wjk.t2.service.BaseService;
import com.qhit.lh.grs.wjk.t2.service.impl.BaseServiceImpl;

/**
 * @author 王金康
 * TODO
 * 2017年12月13日上午9:45:04
 */
public class Test {
	private BaseService baseService = new BaseServiceImpl();
	
	@org.junit.Test
	public void add() {
		//声明员工对象
		Emp emp = new Emp();
		emp.setEname("小明");
		emp.setSex("M");
		emp.setBirthday("2017-01-01");
		emp.setDeptid(1);
		
		//分配一个账户
		User user = new User();
		user.setUname("xiaoming");
		user.setPassword("123456");
		//建立一对一对立关系
		user.setEmp(emp);
		emp.setUser(user);
		
		//级联操作
		baseService.add(emp);
	}

}
