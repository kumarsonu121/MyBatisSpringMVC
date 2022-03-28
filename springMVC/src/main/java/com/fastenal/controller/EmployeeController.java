package com.fastenal.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastenal.dao.EmployeeMapper;
import com.fastenal.entity.Employee;

@Controller 
@RequestMapping("/employee")
public class EmployeeController {

	public static final Logger logger = LogManager.getLogger(EmployeeController.class);
	private static final String EMPLOYEE = "Employee";
	private static final String EMPLOYEELIST = "ListEmployees";
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@GetMapping("/listOfEmployee")
	public String showListOfEmployees(Model model){
		logger.info("showListOfEmployees: entered the method");
		model.addAttribute("employeeList", employeeMapper.getAllEmployees());
		logger.info("showListOfEmployees: exiting the method");
		return EMPLOYEELIST;
	}
	
	@RequestMapping("/showFormForAdd")
	public String addEmployee(Model model){
		logger.info("addEmployee: entered the method");
		model.addAttribute("employee", new Employee());
		logger.info("addEmployee: exiting the method");
		return EMPLOYEE;
	}
	
	@RequestMapping("/saveProcess")
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		logger.info("saveEmployee: entered the method");
		if(employee.getAddress()!=null && employee.getCountry()!=null
		&& employee.getFullname()!=null && employee.getGender()!=null &&
	    employee.getEmail()!=null) {
		if(employee.getId() == null) {
			employeeMapper.saveEmployee(employee);
			}
		else {
			employeeMapper.updateEmployee(employee);
			}
		}
		else {
            logger.error("No field can be kept null");
		}
		logger.info("saveEmployee: exiting the method");
		return "redirect:/employee/listOfEmployee";
	}
	
	@RequestMapping("/displayUpdateForm")
	public String showUpdateForm(@RequestParam("employeeId") int employeeId, Model model){
		logger.info("showUpdateForm: entered the method");
		model.addAttribute("employee", employeeMapper.findById(employeeId));
		logger.info("showUpdateForm: exiting the method");
		return EMPLOYEE;
	}
	
	@RequestMapping("/displayDeleteForm")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId){
		logger.info("deleteEmployee: entered the method");
		employeeMapper.deleteEmployee(employeeId);
		logger.info("deleteEmployee: exiting the method");
		return "redirect:/employee/listOfEmployee";
	}
}
