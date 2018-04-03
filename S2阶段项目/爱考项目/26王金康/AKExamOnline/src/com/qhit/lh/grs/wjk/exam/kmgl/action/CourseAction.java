/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.kmgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qhit.lh.grs.wjk.exam.kmgl.bean.Course;
import com.qhit.lh.grs.wjk.exam.kmgl.service.CourseService;
import com.qhit.lh.grs.wjk.exam.kmgl.service.CourseServiceImpl;

/**
 * @author 王金康
 * TODO
 * 2018年3月7日下午5:36:46
 */
public class CourseAction {
	private static final long serialVersionUID = 5352074026213567264L;
	private CourseService courseService = new CourseServiceImpl();
	private List<Course> listCourses = new ArrayList<>();
	private Course course;
	
	public String getCourses2Json(){
		//设置参数
		Map<String, Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("major", course.getMajor());
			parameter.put("stage", course.getStage());
		}
		//查询数据库科目列表
		listCourses = courseService.getCourseList(parameter);
		System.out.println("异步请求:" + listCourses.size());
		
		return "listCourseJson";
	}
	
	/**
	 * @return the listCourses
	 */
	public List<Course> getListCourses() {
		return listCourses;
	}
	/**
	 * @param listCourses the listCourses to set
	 */
	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
