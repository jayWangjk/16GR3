/**
 * 
 */
package com.grs.wjk;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.grs.wjk.t5.bean.Dept;
import com.qhit.lh.grs.wjk.t5.bean.Emp;
import com.qhit.lh.grs.wjk.t5.bean.User;
import com.qhit.lh.grs.wjk.t5.servcie.BaseService;
import com.qhit.lh.grs.wjk.t5.servcie.impl.BaseServiceImpl;

/**
 * @author 王金康
 * TODO
 * 2017年12月19日下午7:33:02
 */
public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();
	
	@Test
	public void add() {
		//实例化Emp表
		Emp emp = new Emp();
		emp.setEname("jack");
		emp.setSex("M");
		emp.setBirthday("2017-09-08");
		emp.setDeptid(1);
		//实例化User表
		User user = new User();
		user.setUname("jack");
		user.setPassword("123456");
		//实例化Dept表
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 2);
		//1-1
		emp.setUser(user);
		user.setEmp(emp);
		//n-1
		emp.setDept(dept);
		baseService.add(emp);
	}

}
