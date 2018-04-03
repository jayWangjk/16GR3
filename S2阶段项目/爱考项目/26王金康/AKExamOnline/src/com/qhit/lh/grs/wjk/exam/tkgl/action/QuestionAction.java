/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.tkgl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.grs.wjk.exam.common.bean.PageBean;
import com.qhit.lh.grs.wjk.exam.kmgl.bean.Course;
import com.qhit.lh.grs.wjk.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.grs.wjk.exam.tkgl.service.QuestionService;
import com.qhit.lh.grs.wjk.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.grs.wjk.exam.tkgl.utils.PoiReaderExcel;

/**
 * @author 王金康
 * TODO
 * 2018年1月2日下午8:32:54
 */
public class QuestionAction extends ActionSupport {
	
	private QuestionService questionService = new QuestionServiceImpl();
	
	private Course course; //课程
	private String major; //专业方向
	private String stage; //阶段
	private WrittenQuestion writtenQuestion;//笔试题对象
	private List<Course> listCourses = new ArrayList<Course>(); //试题列表
	private PageBean<WrittenQuestion> pageBean = new PageBean<WrittenQuestion>();//试题列表分页数据
	private int pageIndex = 1;//指定页，初始化1
	private List<WrittenQuestion> listWQuestions = new ArrayList<WrittenQuestion>();//导入试题集合
	
	private File qusetionfile;//导入文件对象
	
	private int radioEasyMax,radioNormalMax,radioDiffMax,cbEasyMax,cbNormalMax,cbDiffMax;
	
	/**
	 * 题库列表
	 * @return
	 */
	public String getCourseInfo(){
		//设置参数
		Map<String,String> parameter = new HashMap<String,String>();
		if(major != null && !"".equals(major)){
			System.out.println(major);
			parameter.put("major", major);
		}
		if(stage != null && !"".equals(stage)){
			parameter.put("stage", stage);
			System.out.println(stage);
		}
		//查询题库列表数据
		listCourses = questionService.getCourseInfo(parameter);
		return "listCourse";
	}
	
	/**
	 * @return
	 * 获取试题数量
	 */
	public String getQuestionMax(){
		radioEasyMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "单选", "简单");
		radioNormalMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "单选", "一般");
		radioDiffMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "单选", "困难");
		cbEasyMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "多选", "简单");
		cbNormalMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "多选", "一般");
		cbDiffMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "多选", "困难");
		
		return "getQuestionMax";
	}
	
	/**
	 * @return
	 * 获取试题列表
	 */
	public String getWrittenList(){
		questionService.getWrittenList(pageBean, course, pageIndex);
		System.out.println("数据大小"+pageBean.getItems().size());
		return "listWritten";
	}
	
	/**
	 * @return
	 * 添加试题
	 */
	public String addWrittenQuestion(){
		//设置课程关联
		writtenQuestion.setCourse(course);
		
		questionService.addWrittenQuestion(writtenQuestion);
		return "addWrittenQuestion";
	}
	
	/**
	 * @return
	 * 根据试题编号查询试题对象
	 */
	public String getWrittenQuestionById(){
		writtenQuestion = questionService.getWrittenQuestionById(writtenQuestion);
		
		return "getWrittenQuestionById";
	}
	
	/**
	 * @return
	 * 更新试题
	 */
	public String updateWrittenQuestion(){
		//设置关联
		writtenQuestion.setCourse(course);
		
		questionService.updateWrittenQuestion(writtenQuestion);
		return "updateWrittenQuestion";
	}
	
	/**
	 * @return
	 * @throws FileNotFoundException
	 * 试题上传
	 */
	public String inportWrittenQuestions() throws FileNotFoundException{
		
		if(qusetionfile != null){
			//1,上传到服务器（struts2）(1,jsp表单提交控件2，action)
			FileInputStream fis = new FileInputStream(qusetionfile);
			//2，读取excel文件中的数据，获取试题对象集合（1，POI:导包、2,读取数据流获取数据集合)
			listWQuestions = PoiReaderExcel.readerExcel(fis, course);
			//3，批量添加到试题列表
			questionService.inprotWrittenQuestion(listWQuestions);
		}else{
			//上传失败，暂不做
		}
		return "inportWrittenQuestions";
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
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the stage
	 */
	public String getStage() {
		return stage;
	}
	/**
	 * @param stage the stage to set
	 */
	public void setStage(String stage) {
		this.stage = stage;
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
	 * @return the pageBean
	 */
	public PageBean<WrittenQuestion> getPageBean() {
		return pageBean;
	}

	/**
	 * @param pageBean the pageBean to set
	 */
	public void setPageBean(PageBean<WrittenQuestion> pageBean) {
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
	 * @return the listWQuestions
	 */
	public List<WrittenQuestion> getListWQuestions() {
		return listWQuestions;
	}

	/**
	 * @param listWQuestions the listWQuestions to set
	 */
	public void setListWQuestions(List<WrittenQuestion> listWQuestions) {
		this.listWQuestions = listWQuestions;
	}

	/**
	 * @return the qusetionfile
	 */
	public File getQusetionfile() {
		return qusetionfile;
	}

	/**
	 * @param qusetionfile the qusetionfile to set
	 */
	public void setQusetionfile(File qusetionfile) {
		this.qusetionfile = qusetionfile;
	}

	/**
	 * @return the writtenQuestion
	 */
	public WrittenQuestion getWrittenQuestion() {
		return writtenQuestion;
	}

	/**
	 * @param writtenQuestion the writtenQuestion to set
	 */
	public void setWrittenQuestion(WrittenQuestion writtenQuestion) {
		this.writtenQuestion = writtenQuestion;
	}

	/**
	 * @return the radioEasyMax
	 */
	public int getRadioEasyMax() {
		return radioEasyMax;
	}

	/**
	 * @param radioEasyMax the radioEasyMax to set
	 */
	public void setRadioEasyMax(int radioEasyMax) {
		this.radioEasyMax = radioEasyMax;
	}

	/**
	 * @return the radioNormalMax
	 */
	public int getRadioNormalMax() {
		return radioNormalMax;
	}

	/**
	 * @param radioNormalMax the radioNormalMax to set
	 */
	public void setRadioNormalMax(int radioNormalMax) {
		this.radioNormalMax = radioNormalMax;
	}

	/**
	 * @return the radioDiffMax
	 */
	public int getRadioDiffMax() {
		return radioDiffMax;
	}

	/**
	 * @param radioDiffMax the radioDiffMax to set
	 */
	public void setRadioDiffMax(int radioDiffMax) {
		this.radioDiffMax = radioDiffMax;
	}

	/**
	 * @return the cbEasyMax
	 */
	public int getCbEasyMax() {
		return cbEasyMax;
	}

	/**
	 * @param cbEasyMax the cbEasyMax to set
	 */
	public void setCbEasyMax(int cbEasyMax) {
		this.cbEasyMax = cbEasyMax;
	}

	/**
	 * @return the cbNormalMax
	 */
	public int getCbNormalMax() {
		return cbNormalMax;
	}

	/**
	 * @param cbNormalMax the cbNormalMax to set
	 */
	public void setCbNormalMax(int cbNormalMax) {
		this.cbNormalMax = cbNormalMax;
	}

	/**
	 * @return the cbDiffMax
	 */
	public int getCbDiffMax() {
		return cbDiffMax;
	}

	/**
	 * @param cbDiffMax the cbDiffMax to set
	 */
	public void setCbDiffMax(int cbDiffMax) {
		this.cbDiffMax = cbDiffMax;
	}
}
