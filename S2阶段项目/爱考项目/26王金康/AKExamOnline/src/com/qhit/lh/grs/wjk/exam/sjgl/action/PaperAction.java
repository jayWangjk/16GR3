/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.grs.wjk.exam.common.bean.PageBean;
import com.qhit.lh.grs.wjk.exam.kmgl.bean.Course;
import com.qhit.lh.grs.wjk.exam.sjgl.bean.Paper;
import com.qhit.lh.grs.wjk.exam.sjgl.bean.PaperClass;
import com.qhit.lh.grs.wjk.exam.sjgl.service.PaperService;
import com.qhit.lh.grs.wjk.exam.sjgl.service.PaperServiceImpl;
import com.qhit.lh.grs.wjk.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.grs.wjk.exam.tkgl.service.QuestionService;
import com.qhit.lh.grs.wjk.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.grs.wjk.exam.tkgl.utils.RandomQuestionsUtils;

/**
 * @author 王金康
 * TODO
 * 2018年1月14日下午8:10:37
 */
public class PaperAction{
	private PaperService paperService = new PaperServiceImpl();
	private QuestionService questionService = new QuestionServiceImpl();
	private List<Course> liatCourses = new ArrayList();
	private List<Paper> liatPpaper = new ArrayList();
	//试题列表分页数据
	private PageBean<Paper> pageBean = new PageBean<>();
	private int pageIndex = 1; //指定页，初始化为1
	//条件参数
	private Course course;
	private Paper paper;
	private int radioEasy,radioNormal,radioDiff,cbEasy,cbNormal,cbDiff;
	private List<WrittenQuestion> listRE,listRN,listRD,listCE,listCN,listCD;
	//开始考试，班级集合
	private List<PaperClass> pcs = new ArrayList<>();
	
	/**
	 * 获取试卷列表
	 * @return
	 */
	public String getPaperList(){
		//设置参数
		Map<String,Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("csId", course.getCsId());
		}
		if(paper != null){
			parameter.put("pType", paper.getPtype());
			parameter.put("pState", paper.getPstate());
		}
		//查询题库数据类表
		pageBean = paperService.getPaperList(pageBean, parameter, pageIndex);
		Paper p=pageBean.getItems().get(2);
		System.out.println("输出1：");
		for(PaperClass pc:p.getPaperClasses()){
			System.out.println("输出："+pc.toString());
		}
		System.out.println(pageBean.getItems().size());
		return "listPaper";
	}
	
	/**
	 * 随机组卷
	 * @return
	 */
	public String createByRandom(){
		System.out.println("进入（createByRandom）DAO");
		System.out.println("1,查询所有的类型的试题");
		//1，查询所有的类型的试题
		listRE = questionService.getQuestionsByType(course.getCsId(), "单选", "简单");
		listRN = questionService.getQuestionsByType(course.getCsId(), "单选", "一般");
		listRD = questionService.getQuestionsByType(course.getCsId(), "单选", "困难");
		listCE = questionService.getQuestionsByType(course.getCsId(), "多选", "简单");
		listCN = questionService.getQuestionsByType(course.getCsId(), "多选", "一般");
		listCD = questionService.getQuestionsByType(course.getCsId(), "多选", "困难");
		//2，随机获取试题集合
		System.out.println("2,随机获取试题集合");
		Set<WrittenQuestion> lisQuestions = RandomQuestionsUtils.randomAllQuestions(
				listRE, listRN, listRD, listCE, listCN, listCD, 
				radioEasy, radioNormal, radioDiff, cbEasy, cbNormal, cbDiff);
		System.out.println("试题数量：" + lisQuestions.size());
		//3,设置试题和试卷的关系
		System.out.println("3,设置试题和试卷的关系");
		paper.setWrittenQuestions(lisQuestions);
		//4，设置课程，添加关系
		paper.setCsId(course.getCsId());
		paper.setCourse(course);
		//5，添加试卷
		System.out.println("添加试卷");
		paperService.createPaperRandom(paper);
		
		return "createRandom";
	}
	/**
	 * 结束考试
	 */
	public String endExam(){
		paperService.endExam(paper);
		return "endExam";
	}
	
	/**
	 * @return the liatCourses
	 */
	public List<Course> getLiatCourses() {
		return liatCourses;
	}
	/**
	 * @param liatCourses the liatCourses to set
	 */
	public void setLiatCourses(List<Course> liatCourses) {
		this.liatCourses = liatCourses;
	}
	/**
	 * @return the liatPpaper
	 */
	public List<Paper> getLiatPpaper() {
		return liatPpaper;
	}
	/**
	 * @param liatPpaper the liatPpaper to set
	 */
	public void setLiatPpaper(List<Paper> liatPpaper) {
		this.liatPpaper = liatPpaper;
	}
	/**
	 * @return the pageBean
	 */
	public PageBean<Paper> getPageBean() {
		return pageBean;
	}
	/**
	 * @param pageBean the pageBean to set
	 */
	public void setPageBean(PageBean<Paper> pageBean) {
		this.pageBean = pageBean;
	}
	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
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
	/**
	 * @return the paper
	 */
	public Paper getPaper() {
		return paper;
	}
	/**
	 * @param paper the paper to set
	 */
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	/**
	 * @return the radioEasy
	 */
	public int getRadioEasy() {
		return radioEasy;
	}
	/**
	 * @param radioEasy the radioEasy to set
	 */
	public void setRadioEasy(int radioEasy) {
		this.radioEasy = radioEasy;
	}
	/**
	 * @return the radioNormal
	 */
	public int getRadioNormal() {
		return radioNormal;
	}
	/**
	 * @param radioNormal the radioNormal to set
	 */
	public void setRadioNormal(int radioNormal) {
		this.radioNormal = radioNormal;
	}
	/**
	 * @return the radioDiff
	 */
	public int getRadioDiff() {
		return radioDiff;
	}
	/**
	 * @param radioDiff the radioDiff to set
	 */
	public void setRadioDiff(int radioDiff) {
		this.radioDiff = radioDiff;
	}
	/**
	 * @return the cbEasy
	 */
	public int getCbEasy() {
		return cbEasy;
	}
	/**
	 * @param cbEasy the cbEasy to set
	 */
	public void setCbEasy(int cbEasy) {
		this.cbEasy = cbEasy;
	}
	/**
	 * @return the cbNormal
	 */
	public int getCbNormal() {
		return cbNormal;
	}
	/**
	 * @param cbNormal the cbNormal to set
	 */
	public void setCbNormal(int cbNormal) {
		this.cbNormal = cbNormal;
	}
	/**
	 * @return the cbDiff
	 */
	public int getCbDiff() {
		return cbDiff;
	}
	/**
	 * @param cbDiff the cbDiff to set
	 */
	public void setCbDiff(int cbDiff) {
		this.cbDiff = cbDiff;
	}
	/**
	 * @return the listRE
	 */
	public List<WrittenQuestion> getListRE() {
		return listRE;
	}
	/**
	 * @param listRE the listRE to set
	 */
	public void setListRE(List<WrittenQuestion> listRE) {
		this.listRE = listRE;
	}
	/**
	 * @return the listRN
	 */
	public List<WrittenQuestion> getListRN() {
		return listRN;
	}
	/**
	 * @param listRN the listRN to set
	 */
	public void setListRN(List<WrittenQuestion> listRN) {
		this.listRN = listRN;
	}
	/**
	 * @return the listRD
	 */
	public List<WrittenQuestion> getListRD() {
		return listRD;
	}
	/**
	 * @param listRD the listRD to set
	 */
	public void setListRD(List<WrittenQuestion> listRD) {
		this.listRD = listRD;
	}
	/**
	 * @return the listCE
	 */
	public List<WrittenQuestion> getListCE() {
		return listCE;
	}
	/**
	 * @param listCE the listCE to set
	 */
	public void setListCE(List<WrittenQuestion> listCE) {
		this.listCE = listCE;
	}
	/**
	 * @return the listCN
	 */
	public List<WrittenQuestion> getListCN() {
		return listCN;
	}
	/**
	 * @param listCN the listCN to set
	 */
	public void setListCN(List<WrittenQuestion> listCN) {
		this.listCN = listCN;
	}
	/**
	 * @return the listCD
	 */
	public List<WrittenQuestion> getListCD() {
		return listCD;
	}
	/**
	 * @param listCD the listCD to set
	 */
	public void setListCD(List<WrittenQuestion> listCD) {
		this.listCD = listCD;
	}

	/**
	 * @return the pcs
	 */
	public List<PaperClass> getPcs() {
		return pcs;
	}

	/**
	 * @param pcs the pcs to set
	 */
	public void setPcs(List<PaperClass> pcs) {
		this.pcs = pcs;
	}
	
}
