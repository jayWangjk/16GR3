/**
 * 
 */
package com.qhit.lh.grs.wjk.t1.service;

import java.util.List;

/**
 * @author 王金康
 * TODO
 * 2017年12月11日上午9:40:29
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
}
