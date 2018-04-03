/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.kmgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.grs.wjk.exam.kmgl.bean.Course;

/**
 * @author 王金康
 * TODO
 * 2018年3月7日下午5:33:53
 */
public interface CourseService {
	
	/**
	 * @param parameter
	 * @return
	 */
	public List<Course> getCourseList(Map<String, Object> parameter);
}
