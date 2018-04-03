/**
 * 
 */
package com.grs.wjk;

import org.junit.Test;

import com.qhit.lh.grs.wjk.exam.common.action.UserAction;
import com.qhit.lh.grs.wjk.exam.common.bean.User;
import com.qhit.lh.grs.wjk.exam.tkgl.action.QuestionAction;

/**
 * @author 王金康
 * TODO
 * 2018年1月2日下午5:57:51
 */
public class UserTest {
	
	@Test
	public void login(){
		UserAction userAction = new UserAction();
		User user = new User();
		user.setName("admin");
		user.setPwd("123456");
		user.setRole(4);
		
		userAction.setUser(user);
		
		System.out.println(userAction.login());
	}
}
