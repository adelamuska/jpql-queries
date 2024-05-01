package com.detyrajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class EmployeeEntity {

    @Id
    @Column(name="emp_no")
    private Integer empNo;
    @Column(name="birth_date")
    private LocalDate birthDate;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String gender;
    @Column(name="hire_date")
    private LocalDate hireDate;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalaryEntity> salary = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="dept_emp",
            joinColumns = @JoinColumn(name = "emp_no"),
            inverseJoinColumns = @JoinColumn(name = "dept_no"))
    private List<DepartmentEntity> departmentEmp = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="dept_manager",
            joinColumns = @JoinColumn(name = "emp_no"),
            inverseJoinColumns = @JoinColumn(name = "dept_no"))
    private List<DepartmentEntity> departmentManager = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    List<TitleEntity> titles = new ArrayList<>();

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
