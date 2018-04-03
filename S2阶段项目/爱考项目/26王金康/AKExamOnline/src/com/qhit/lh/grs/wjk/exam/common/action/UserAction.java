/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.grs.wjk.exam.common.bean.User;
import com.qhit.lh.grs.wjk.exam.common.service.UserService;
import com.qhit.lh.grs.wjk.exam.common.service.UserServiceImpl;


/**
 * @author 王金康
 * TODO
 * 2017年12月28日下午5:27:18
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	
	private User user;
	
	/**
	 * @return
	 * 登录
	 */
	public String login(){
		
		user = userService.login(user);
		
		if(user != null){
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			super.addActionError("登录失败！请重新登录!");
			return "loginFail";
		}
	}
	
	/**
	 * @return
	 * 退出
	 */
	public String logout(){
		//获取seession对象并销毁
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
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
}
