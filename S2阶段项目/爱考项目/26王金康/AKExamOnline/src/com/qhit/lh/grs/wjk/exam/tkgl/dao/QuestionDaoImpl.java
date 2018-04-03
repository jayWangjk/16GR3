/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.lh.grs.wjk.exam.common.bean.PageBean;
import com.qhit.lh.grs.wjk.exam.common.dao.BaseDao;
import com.qhit.lh.grs.wjk.exam.kmgl.bean.Course;
import com.qhit.lh.grs.wjk.exam.tkgl.bean.WrittenQuestion;

/**
 * @author 王金康
 * TODO
 * 2018年1月2日下午7:53:34
 */
public class QuestionDaoImpl extends BaseDao implements QuestionDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.exam.tkgl.dao.QuestionDao#getCourseInfo(java.util.Map)
	 * 题库列表
	 */
	public List<Course> getCourseInfo(Map parameter) {
		System.out.println("进入Dao");
		StringBuffer hql = new StringBuffer();
		hql.append("select course from Course course where 1 = 1");
		//拼接HQL
		if(parameter.get("major") != null && !"".equals((String)parameter.get("major"))){
			hql.append(" and course.major = :major");
		}
		if(parameter.get("stage") != null && !"".equals((String)parameter.get("stage"))){
			hql.append(" and course.stage = :stage");
		}
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置参数
		if(parameter.get("major") != null && !"".equals((String)parameter.get("major"))){
			query.setString("major", (String) parameter.get("major"));
		}
		if(parameter.get("stage") != null && !"".equals((String)parameter.get("stage"))){
			query.setString("stage", (String) parameter.get("stage"));
		}
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.exam.tkgl.dao.QuestionDao#getWrittenList()
	 * 试题分页数据
	 */
	@Override
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean,
			Course course,
			int pageIndex) {
		//hql语句
		StringBuffer hql = new StringBuffer();
		hql.append("select w from WrittenQuestion w where w.csId = :csId ");
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置分页查询数据
		query.setInteger("csId", course.getCsId());
		//总记录数
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		//当前页数据
		List<WrittenQuestion> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//设置pageBase数据集合
		pageBean.setItems(items);
		
		return pageBean;
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.exam.tkgl.dao.QuestionDao#addWrittenQuestion(com.qhit.lh.grs.wjk.exam.tkgl.bean.WrittenQuestion)
	 * 添加试题
	 */
	@Override
	public void addWrittenQuestion(WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//执行添加，返回新纪录的主键
		long id = (Integer) getSession().save(writtenQuestion);
		//提交事务
		ts.commit();
	}
	
	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.exam.tkgl.dao.QuestionDao#getWrittenQuestionById(com.qhit.lh.grs.wjk.exam.tkgl.bean.WrittenQuestion)
	 * 根据ID查询试题
	 */
	@Override
	public WrittenQuestion getWrittenQuestionById(WrittenQuestion writtenQuestion) {
		return (WrittenQuestion) getSession().get(WrittenQuestion.class,writtenQuestion.getQid());
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.exam.tkgl.dao.QuestionDao#updateWrittenQuestion(com.qhit.lh.grs.wjk.exam.tkgl.bean.WrittenQuestion)
	 * 更新数据
	 */
	@Override
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion) {
		//清除session中缓存对象
		getSession().clear();
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//执行更新操作
		getSession().update(writtenQuestion);
		//提交事务
		ts.commit();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.exam.tkgl.dao.QuestionDao#inprotWrittenQuestion(java.util.List)
	 * 批量导入试题
	 */
	@Override
	public void inprotWrittenQuestion(List<WrittenQuestion> listwritten) {
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//循环添加
		for (WrittenQuestion writtenQuestion : listwritten) {
			//执行添加，返回新纪录的主键
			getSession().save(writtenQuestion);
		}
		//提交事务
		ts.commit();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.exam.tkgl.dao.QuestionDao#getQuestionsMax(int, java.lang.String, java.lang.String)
	 * 获取试题数量
	 */
	@Override
	public int getQuestionsMax(int csId, String type, String degree) {
		Criteria criteria = getSession().createCriteria(WrittenQuestion.class)
				.add(Restrictions.eq("csId", csId))
				.add(Restrictions.eq("qtype", type))
				.add(Restrictions.eq("degree", degree));
		
		ProjectionList projectionList = Projections.projectionList()
				.add(Projections.count("qid"));
		
		criteria.setProjection(projectionList);
		long num = (long) criteria.list().get(0);
		return (int) num;
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.grs.wjk.exam.tkgl.dao.QuestionDao#getQuestionsByType(int, java.lang.String, java.lang.String)
	 */
	@Override
	public List<WrittenQuestion> getQuestionsByType(int csId, String qtype, String degree) {
		Criteria critera = getSession().createCriteria(WrittenQuestion.class)
				.add(Restrictions.eq("csId", csId))
				.add(Restrictions.eq("qtype", qtype))
				.add(Restrictions.eq("degree", degree));
		
		return critera.list();
	}
}
