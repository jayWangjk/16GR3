/**
 * 
 */
package com.grs.wjk;

import org.junit.Test;

import com.qhit.lh.grs.wjk.t5.bean.Dept;
import com.qhit.lh.grs.wjk.t5.bean.Emp;
import com.qhit.lh.grs.wjk.t5.servcie.BaseService;
import com.qhit.lh.grs.wjk.t5.servcie.impl.BaseServiceImpl;

/**
 * @author 王金康
 * TODO
 * 2017年12月19日下午7:33:11
 */
public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();
	
	/**
	 * 添加
	 */
	@Test
	public void add() {
		//实例化部门
		Dept dept = new Dept();
		dept.setTname("规划部");
		dept.setAddress("故宫");
		//没有员工
		
		//添加员工
		Emp emp1 = new Emp();
		emp1.setEname("任子屹");
		emp1.setSex("M");
		emp1.setBirthday("1997-02-06");
		
		Emp emp2 = new Emp();
		emp2.setEname("裴志博");
		emp2.setSex("M");
		emp2.setBirthday("1997-08-12");
		
		Emp emp3 = new Emp();
		emp3.setEname("孙义明");
		emp3.setSex("M");
		emp3.setBirthday("1997-09-23");
		
		dept.getEmps().add(emp1);
		dept.getEmps().add(emp2);
		dept.getEmps().add(emp3);
		
		//执行添加操作
		baseService.add(dept);
	}
	
	/**
	 * 删除
	 */
	@Test
	public void delect(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 9);
		
		baseService.delete(dept);
	}
	
	/**
	 * 更新
	 */
	@Test
	public void update(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 3);
		
		dept.setTname("规划部");
		dept.setAddress("故宫");
		
		baseService.update(dept);
	}
	
	/**
	 * 查询
	 */
	@Test
	public void query(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 1);
		
		for(Emp emp : dept.getEmps()){
			System.out.println(dept.getTname()+":"+emp.getEname());
		}
	}
}
