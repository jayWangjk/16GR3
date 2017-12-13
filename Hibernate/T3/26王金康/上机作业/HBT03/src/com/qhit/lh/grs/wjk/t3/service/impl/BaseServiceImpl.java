/**
 * 
 */
package com.qhit.lh.grs.wjk.t3.service.impl;

import java.util.List;

import com.qhit.lh.grs.wjk.t3.dao.BaseDao;
import com.qhit.lh.grs.wjk.t3.dao.impl.BaseDaoImpl;
import com.qhit.lh.grs.wjk.t3.service.BaseService;

/**
 * @author 王金康
 * TODO
 * 2017年12月13日上午10:33:42
 */
public class BaseServiceImpl implements BaseService {
	private BaseDao baseDao = new BaseDaoImpl();
	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t3.service.BaseService#add(java.lang.Object)
	 */
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		baseDao.add(obj);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t3.service.BaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		baseDao.delete(obj);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t3.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		baseDao.update(obj);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t3.service.BaseService#getAll(java.lang.String)
	 */
	@Override
	public List<Object> getAll(String fromObject) {
		// TODO Auto-generated method stub
		return baseDao.getAll(fromObject);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.t3.service.BaseService#getObjectById(java.lang.Object, int)
	 */
	@Override
	public Object getObjectById(Object obj, int id) {
		// TODO Auto-generated method stub
		return baseDao.getObjectById(obj, id);
	}

}
