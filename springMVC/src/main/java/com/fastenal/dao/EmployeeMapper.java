package com.fastenal.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.fastenal.entity.Employee;
import com.fastenal.util.MyBatisUtil;


@Repository
public class EmployeeMapper {
	
	public static final Logger logger = LogManager.getLogger(EmployeeMapper.class);
	
	public void saveEmployee(Employee employee){
		logger.info("saveEmployee: entered the method");
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertEmployee", employee);
		session.commit();
		session.close();
		logger.info("saveEmployee: exiting the method");
		
	}
	
	public void updateEmployee(Employee employee){
		logger.info("updateEmployee: entered the method");
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("updateEmployee", employee);
		session.commit();
		session.close();
		logger.info("updateEmployee: exiting the method");

	}
	
	public void deleteEmployee(int employeeId){
		logger.info("deleteEmployee: entered the method");
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteEmployee", employeeId);
		session.commit();
		session.close();
		logger.info("deleteEmployee: exiting the method");

	}
	
	public List<Employee> getAllEmployees(){
		logger.info("getAllEmployee: entered the method");
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<Employee> employeeList = session.selectList("getAllEmployees");
		session.commit();
		session.close();
		logger.info("getAllEmployee: exiting the method");
		return employeeList;
	}
	
	public Employee findById(int employeeId){
		logger.info("findById: entered the method");
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Employee employee = (Employee) session.selectOne("findById", employeeId);
		session.commit();
		session.close();
		logger.info("findById: exiting the method");
		return employee;
	}
}