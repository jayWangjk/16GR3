/**
 * 
 */
package com.qhit.lh.grs.wjk.exam.bjgl.action;

import java.util.List;

import com.qhit.lh.grs.wjk.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.grs.wjk.exam.bjgl.service.ClazzService;
import com.qhit.lh.grs.wjk.exam.bjgl.service.ClazzServiceImpl;

/**
 * @author 王金康
 * TODO
 * 2018年3月7日下午5:56:59
 */
public class ClazzAction {
	private ClazzService clazzService = new ClazzServiceImpl();
	private List<ClassInfo> listClazz;
	
	public String getClazzList(){
		listClazz = clazzService.getClazzList();
		return "getClazzList";
	}
	
	/**
	 * @return the listClszz
	 */
	public List<ClassInfo> getListClazz() {
		return listClazz;
	}
	/**
	 * @param listClszz the listClszz to set
	 */
	public void setListClszz(List<ClassInfo> listClazz) {
		this.listClazz = listClazz;
	}
}
