/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.bjgl.service;

import java.util.List;

import com.qhit.lh.grs.wjk.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.grs.wjk.exam.bjgl.dao.ClazzDao;
import com.qhit.lh.grs.wjk.exam.bjgl.dao.ClazzDaoImpl;

/**
 * @author 王金康
 * TODO
 * 2018年3月7日下午5:55:56
 */
public class ClazzServiceImpl implements ClazzService {
	private ClazzDao clazzDao = new ClazzDaoImpl();
	
	@Override
	public List<ClassInfo> getClazzList() {
		return clazzDao.getClazzList();
	}

}
