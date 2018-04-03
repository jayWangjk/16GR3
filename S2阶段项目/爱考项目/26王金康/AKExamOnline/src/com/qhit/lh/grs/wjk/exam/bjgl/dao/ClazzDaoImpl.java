/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.bjgl.dao;

import java.util.List;

import com.qhit.lh.grs.wjk.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.grs.wjk.exam.common.dao.BaseDao;

/**
 * @author 王金康
 * TODO
 * 2018年3月7日下午5:53:33
 */
public class ClazzDaoImpl extends BaseDao implements ClazzDao {

	@Override
	public List<ClassInfo> getClazzList() {
		return getSession().createQuery("from ClassInfo").list();
	}

}
