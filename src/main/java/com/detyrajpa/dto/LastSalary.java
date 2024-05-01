package com.detyrajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class LastSalary {

    private Integer empNo;
    private Integer salary;
    private LocalDate fromDate;
}
