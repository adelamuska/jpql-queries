package com.detyrajpa;

import com.detyrajpa.repository.DepartmentRepository;
import com.detyrajpa.repository.EmployeeRepository;
import com.detyrajpa.repository.SalaryRepository;
import com.detyrajpa.repository.TitleRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DetyraJpaApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(DetyraJpaApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(DetyraJpaApplication.class, args);

	}

	@Autowired
	EmployeeRepository employee;

	@Autowired
	SalaryRepository salary;

	@Autowired
	DepartmentRepository department;

	@Autowired
	TitleRepository title;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		logger.info("All employees {}", employee.getAllEmployees(0,10,"firstName",true));
		logger.info("All salaries {}", salary.getAllSalaries(0,10,"salary",true));
		logger.info("All departments {}", department.getAllDepartments(0,10,"deptName",true));
		logger.info("All titles {}", title.getAllTitles(0,10,"toDate",true));

		logger.info("2 {}", employee.getEmployeesAfterDate(LocalDate.of(2011,12,21), 0, 10, "lastName", true));
		logger.info("3 {}", employee.getEmployeesWithSalaryGreaterThan(72000,0,10,"salary",false));
		logger.info("4 {}", employee.getEmployeesByTitle("Senior Engineer",0,10,"firstName",true));
		logger.info("5 {}", salary.getLastSalaryForEachEmployee(0,10,"salary",true));
		logger.info("6 {}", salary.getAverageSalaryForEachDepartment(0,10,"deptName",true));
		logger.info("7 {}", employee.getNumberOfEmployeesForEachDepartment(0,10,"deptName",true));


	}
}
