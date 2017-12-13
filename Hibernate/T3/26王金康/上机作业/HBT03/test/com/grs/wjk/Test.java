/**
 * 
 */
package com.grs.wjk;

import static org.junit.Assert.*;

import com.qhit.lh.grs.wjk.t3.bean.Dept;
import com.qhit.lh.grs.wjk.t3.bean.Emp;
import com.qhit.lh.grs.wjk.t3.bean.User;
import com.qhit.lh.grs.wjk.t3.service.BaseService;
import com.qhit.lh.grs.wjk.t3.service.impl.BaseServiceImpl;

/**
 * @author 王金康
 * TODO
 * 2017年12月13日上午10:42:55
 */
public class Test {
	private BaseService baseService = new BaseServiceImpl();
	@org.junit.Test
	public void add() {
		//声明员工对象
		Emp emp = new Emp();
		emp.setEname("大康");
		emp.setSex("M");
		emp.setBirthday("2017-01-01");
		
		//分配一个账户
		User user = new User();
		user.setUname("dakang");
		user.setPassword("123456");
		//建立一对一对立关系
		user.setEmp(emp);
		emp.setUser(user);
		//分配所属部门
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept, 1);
		//建立多对一关联
		emp.setDept(dept);
		
		//级联操作
		baseService.add(emp);
	}

}
