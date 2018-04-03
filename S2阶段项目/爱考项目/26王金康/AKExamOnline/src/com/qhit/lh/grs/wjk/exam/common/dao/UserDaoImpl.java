/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.common.dao;

import java.util.List;

import org.hibernate.Query;

import com.qhit.lh.grs.wjk.exam.common.bean.User;


/**
 * @author 王金康
 * TODO
 * 2017年12月28日下午5:27:58
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.common.dao.UserDao#login(com.qhit.lh.grs.wjk.common.bean.User)
	 * 登录
	 */
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql = "select user from User user where user.name = ? and user.pwd = ? and user.role = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getName());
		query.setString(1, user.getPwd());
		query.setInteger(2, user.getRole());
		
		List<User> list = (List<User>)query.list();
		
		if(list != null && list.size() == 1){
			//登录成功
			return list.get(0);
		}
		return null;
	}

}
