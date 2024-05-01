package com.detyrajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvgSalary {

    private Integer deptNo;
    private String deptName;
    private Double salary;
}
