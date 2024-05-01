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
@Table(name="titles")
public class TitleEntity {
    @EmbeddedId
    private TitleIdEntity titleId;
    @Column(name= "to_date")
    private LocalDate toDate;
    @ManyToOne
    @JoinColumn(name="emp_no", referencedColumnName = "emp_no")
    @MapsId("employeeId")
    private EmployeeEntity employee;

    @Override
    public String toString() {
        return "Title{" +
                "titleId=" + titleId +
                ", toDate=" + toDate +
                ", employee=" + employee +
                '}';
    }
}
