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
@Table(name="salaries")
public class SalaryEntity {

    @EmbeddedId
    private SalaryIdEntity id;
    private Integer salary;
    @Column(name = "to_date")
    private LocalDate toDate;

    @ManyToOne
    @JoinColumn(name = "emp_no",referencedColumnName = "emp_no")
    @MapsId("empNo")
    private EmployeeEntity employee;


    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salary=" + salary +
                ", toDate=" + toDate +
                ", employee=" + employee +
                '}';
    }
}
