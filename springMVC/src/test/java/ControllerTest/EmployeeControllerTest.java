package ControllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import java.util.Arrays;
import java.util.List;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.fastenal.entity.Employee;

import com.fastenal.controller.EmployeeController;
import com.fastenal.dao.EmployeeMapper;

//@WebMvcTest(EmployeeController.class)
@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private EmployeeMapper employeeMapper;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Test
	public void showListOfEmployeesTest() {
		
		List<Employee> employee = Arrays.asList(
				new Employee(1, "Kumar Sonu", "ksonu@gmail.com", "Male", "Running", "India", "Ranchi"),
				new Employee(2, "Ishan", "ishan@gmail.com", "Male", "Cycling", "Australia", "Sydney"));
		when(employeeMapper.getAllEmployees()).thenReturn(employee);
		//mockMvc.perform(get("/listOfEmployee")).andExpect(status().isOk());
		Model model = null;
		String result = employeeController.showListOfEmployees(model);
		assertEquals("ListEmployees", result);
		
	}
	
}
