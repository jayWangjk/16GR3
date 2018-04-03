/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.grs.wjk.exam.kmgl.bean.Course;

/**
 * @author 王金康
 * TODO
 * 2018年3月7日下午5:12:58
 */
public interface CourseDao {
	
	/**
	 * @param parameter
	 * @return
	 */
	public List<Course> getCoursesList(Map<String, Object> parameter);
}
