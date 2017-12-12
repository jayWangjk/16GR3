/**
 * 
 */
package com.grs.wjk;

import org.junit.Test;

import com.qhit.lh.grs.wjk.t1.bean.User;
import com.qhit.lh.grs.wjk.t1.service.BaseService;
import com.qhit.lh.grs.wjk.t1.service.impl.BaseServiceImpl;

/**
 * @author 王金康
 * TODO
 * 2017年12月11日上午10:40:10
 */
public class UserTest {
	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void addTest() {
		//实例化对象
		User user = new User();
		user.setUname("admin");
		user.setPassword("123456");
		user.setSex("F");
		user.setEducation("本科");
		//数据操作
		baseService.add(user);
	}

}
