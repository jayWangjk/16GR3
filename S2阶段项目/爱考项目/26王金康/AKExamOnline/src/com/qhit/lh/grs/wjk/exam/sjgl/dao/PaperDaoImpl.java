/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.qhit.lh.grs.wjk.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.grs.wjk.exam.common.bean.PageBean;
import com.qhit.lh.grs.wjk.exam.common.dao.BaseDao;
import com.qhit.lh.grs.wjk.exam.sjgl.bean.Paper;
import com.qhit.lh.grs.wjk.exam.sjgl.bean.PaperClass;

/**
 * @author 王金康
 * TODO
 * 2018年1月14日下午8:09:38
 */
public class PaperDaoImpl extends BaseDao implements PaperDao {

	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
		//开启事务
		getSession().clear();
		//HQL语句
		StringBuffer hql = new StringBuffer();
		hql.append("select paper from Paper paper where 1 = 1 ");
		//拼接HQL
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			hql.append(" and paper.csId = :csId");
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			hql.append(" and paper.ptype = :pType");
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			hql.append(" and paper.pstate = :pState");
		}
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置参数
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			query.setInteger("csId", (Integer)parameter.get("csId"));
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			query.setString("pType", (String)parameter.get("pType"));
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			query.setString("pState",(String)parameter.get("pState"));
		}
		//总记录数
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		//当前页数据
		List<Paper> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//设置pageBean的数据集合
		pageBean.setItems(items);
		//执行查询
		return pageBean;
	}

	@Override
	public void startExam(List<PaperClass> paperClasses) {
		// TODO Auto-generated method stub
		Transaction ts = getSession().beginTransaction();
		for(PaperClass paperClass : paperClasses){
			//设置n-1的关系
			Paper paper = (Paper) getSession().get(Paper.class, paperClass.getPid());
			ClassInfo classInfo = (ClassInfo) getSession().get(ClassInfo.class, paperClass.getCcode());
			paperClass.setPaper(paper);
			paperClass.setClassInfo(classInfo);
			//保存数据
			getSession().save(paperClass);
		}
		ts.commit();
	}

	@Override
	public void updateExam(Paper paper, String state) {
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//HQL语句
		String hql = "update Paper paper set paper.pstate = ? where paper.pid = ? ";
		Query queryUpdate = getSession().createQuery(hql);
		queryUpdate.setString(0, state);
		queryUpdate.setInteger(1, paper.getPid());
		//执行HQL语句的添加、修改、删除、调用的是executeUpdate方法
		queryUpdate.executeUpdate();
		ts.commit();
	}

	@Override
	public void createPaperRandom(Paper paper) {
		//开启事务
		Transaction ts = getSession().beginTransaction();
		getSession().save(paper);
		ts.commit();
	}

}
