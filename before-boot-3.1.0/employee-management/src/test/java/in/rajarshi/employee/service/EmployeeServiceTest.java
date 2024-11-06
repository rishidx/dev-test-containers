package in.rajarshi.employee.service;

import in.rajarshi.employee.model.Employee;
import in.rajarshi.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setDepartment("HR");
        employee1.setSalary(50000);

        Employee employee2 = new Employee();
        employee2.setName("Jane Doe");
        employee2.setDepartment("Finance");
        employee2.setSalary(60000);

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        List<Employee> employees = employeeService.getAllEmployees();
        assertThat(employees).hasSize(2);
        assertThat(employees.get(0).getName()).isEqualTo("John Doe");
        assertThat(employees.get(1).getName()).isEqualTo("Jane Doe");
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setDepartment("HR");
        employee.setSalary(50000);

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee createdEmployee = employeeService.createEmployee(employee);
        assertThat(createdEmployee).isNotNull();
        assertThat(createdEmployee.getName()).isEqualTo("John Doe");
    }
}
