/**
 * 
 */
package com.qhit.lh.grs.wjk.t3.service;

import java.util.List;

/**
 * @author 王金康
 * TODO
 * 2017年12月13日上午10:33:26
 */
public interface BaseService {
	/**
	 * @param obj
	 * 增
	 */
	public void add(Object obj);
	
	/**
	 * @param obj
	 * 删
	 */
	public void delete(Object obj);
	
	/**
	 * @param obj
	 * 改
	 */
	public void update(Object obj);
	
	/**
	 * @param obj
	 * @return
	 * 查
	 */
	public List<Object> getAll(String fromObject);
	
	/**
	 * @param obj
	 * @param id
	 * @return
	 * 根据ID查询
	 */
	public Object getObjectById(Object obj,int id);
}
