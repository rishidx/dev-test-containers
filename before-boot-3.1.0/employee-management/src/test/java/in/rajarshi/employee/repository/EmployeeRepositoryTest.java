package in.rajarshi.employee.repository;

import in.rajarshi.employee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:9.1.0");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setDepartment("HR");
        employee.setSalary(50000);

        Employee savedEmployee = employeeRepository.save(employee);
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isNotNull();
    }

    @Test
    public void testFindAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setName("John Doe");
        employee1.setDepartment("HR");
        employee1.setSalary(50000);

        Employee employee2 = new Employee();
        employee2.setName("Jane Doe");
        employee2.setDepartment("Finance");
        employee2.setSalary(60000);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees).hasSize(2);
    }
}
