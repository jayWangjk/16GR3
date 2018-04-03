/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.common.dao;

import com.qhit.lh.grs.wjk.exam.common.bean.User;

/**
 * @author 王金康
 * TODO
 * 2017年12月28日下午5:27:46
 */
public interface UserDao {
	
	/**
	 * @param user
	 * @return
	 * 登录
	 */
	public User login(User user);
}
