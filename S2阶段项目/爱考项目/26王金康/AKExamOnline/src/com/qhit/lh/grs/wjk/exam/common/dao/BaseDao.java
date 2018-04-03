/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.grs.wjk.exam.common.utils.HibernateSessionFactory;

/**
 * @author 王金康
 * TODO
 * 2017年12月28日下午5:27:26
 */
public class BaseDao {
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
