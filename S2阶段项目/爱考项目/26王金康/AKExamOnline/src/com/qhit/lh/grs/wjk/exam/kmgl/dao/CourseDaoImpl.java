/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.qhit.lh.grs.wjk.exam.common.dao.BaseDao;
import com.qhit.lh.grs.wjk.exam.kmgl.bean.Course;

/**
 * @author 王金康
 * TODO
 * 2018年3月7日下午5:15:21
 */
public class CourseDaoImpl extends BaseDao implements CourseDao {

	@Override
	public List<Course> getCoursesList(Map<String, Object> parameter) {
		StringBuffer hql = new StringBuffer("select course from Course course where 1 = 1");
		//拼接HQL
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			hql.append(" and course.major = :major");
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			hql.append(" and course.stage = :stage");
		}
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置参数
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			query.setString("major", (String) parameter.get("major"));
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			query.setString("stage", (String) parameter.get("stage"));
		}
		//执行查询
		return query.list();
	}
}
