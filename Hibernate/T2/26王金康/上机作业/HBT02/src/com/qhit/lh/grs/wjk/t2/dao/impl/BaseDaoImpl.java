/**
 * 
 */
package com.qhit.lh.grs.wjk.t2.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.grs.wjk.t2.dao.BaseDao;
import com.qhit.lh.grs.wjk.t2.utils.HibernateSessionFactory;

/**
 * @author 王金康
 * TODO
 * 2017年12月13日上午9:25:49
 */
public class BaseDaoImpl implements BaseDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t2.dao.BaseDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object obj) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2.开启事物
		Transaction tx = session.beginTransaction();
		//3.执行
		session.save(obj);
		//4，提交事务
		tx.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t2.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object obj) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2.开启事物
		Transaction tx = session.beginTransaction();
		//3.执行
		session.save(obj);
		//4，提交事务
		tx.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t2.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object obj) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2.开启事物
		Transaction tx = session.beginTransaction();
		//3.执行
		session.save(obj);
		//4，提交事务
		tx.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t2.dao.BaseDao#getAll(java.lang.String)
	 */
	@Override
	public List<Object> getAll(String fromObject) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2.开启事物
		Transaction tx = session.beginTransaction();
		//3.获取查询器对象
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		//4，提交事务
		tx.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t2.dao.BaseDao#getObjectById(java.lang.Object, int)
	 */
	@Override
	public Object getObjectById(Object obj, int id) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2.开启事物
		Transaction tx = session.beginTransaction();
		//3.获取查询器对象
		obj = session.get(obj.getClass(), id);
		//4，提交事务
		tx.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return obj;
	}
}
