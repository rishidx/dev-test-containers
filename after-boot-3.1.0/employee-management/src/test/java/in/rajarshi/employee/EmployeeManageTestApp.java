package in.rajarshi.employee;

import in.rajarshi.employee.testconfig.TestContainerConfig;
import org.springframework.boot.SpringApplication;

public class EmployeeManageTestApp {

    public static void main(String[] args) {
        SpringApplication.from(EmployeeManagementApplication::main).with(TestContainerConfig.class).run(args);
    }
}
