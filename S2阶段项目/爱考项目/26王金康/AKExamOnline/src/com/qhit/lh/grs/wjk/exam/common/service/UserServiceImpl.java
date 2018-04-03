/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.common.service;

import com.qhit.lh.grs.wjk.exam.common.bean.User;
import com.qhit.lh.grs.wjk.exam.common.dao.UserDao;
import com.qhit.lh.grs.wjk.exam.common.dao.UserDaoImpl;

/**
 * @author 王金康
 * TODO
 * 2017年12月28日下午5:28:41
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
