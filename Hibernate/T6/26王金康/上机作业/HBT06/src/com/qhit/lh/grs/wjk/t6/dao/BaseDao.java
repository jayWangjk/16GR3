/**
 * 
 */
package com.qhit.lh.grs.wjk.t6.dao;

import java.util.List;

/**
 * @author 王金康
 * TODO
 * 2017年12月20日上午10:31:37
 */
public interface BaseDao {
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
	 * 查
	 */
	public List<Object> getAll(String fromObject);
	
	/**
	 * @param obj
	 * @param id
	 * @return
	 * 根据id去查
	 */
	public Object getObjectById(Class clazz, int id);
}
