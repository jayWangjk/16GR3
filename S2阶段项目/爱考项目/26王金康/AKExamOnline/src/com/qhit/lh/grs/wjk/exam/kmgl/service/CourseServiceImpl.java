/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.kmgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.grs.wjk.exam.kmgl.bean.Course;
import com.qhit.lh.grs.wjk.exam.kmgl.dao.CourseDao;
import com.qhit.lh.grs.wjk.exam.kmgl.dao.CourseDaoImpl;

/**
 * @author 王金康
 * TODO
 * 2018年3月7日下午5:34:04
 */
public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao = new CourseDaoImpl();
	
	@Override
	public List<Course> getCourseList(Map<String, Object> parameter) {
		return courseDao.getCoursesList(parameter);
	}

}
