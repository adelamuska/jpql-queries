package com.detyrajpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="dept_manager")
public class DeptManagerEntity {

    @EmbeddedId
    private DeptManagerIdEntity id;

    @Column(name="from_date")
    private LocalDate fromDate;
    @Column(name="to_date")
    private LocalDate toDate;

    @ManyToOne
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no")
    @MapsId("deptNo")
    private DepartmentEntity department;

    @ManyToOne
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no")
    @MapsId("empNo")
    private EmployeeEntity employee;

    @Override
    public String toString() {
        return "DeptManager{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", department=" + department +
                ", employee=" + employee +
                '}';
    }
}
