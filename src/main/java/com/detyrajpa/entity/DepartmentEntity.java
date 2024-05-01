package com.detyrajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="departments")
public class DepartmentEntity {

    @Id
    @Column(name = "dept_no")
    private Integer deptNo;
    @Column(name = "dept_name")
    private String deptName;

    @ManyToMany(mappedBy = "departmentEmp")
    private List<EmployeeEntity> employees = new ArrayList<>();

    @ManyToMany(mappedBy = "departmentManager")
    private List<EmployeeEntity> employeesManager = new ArrayList<>();


    @Override
    public String toString() {
        return "Department{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
