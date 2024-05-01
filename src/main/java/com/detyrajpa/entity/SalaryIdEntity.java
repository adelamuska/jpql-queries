package com.detyrajpa.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
public class SalaryIdEntity implements Serializable {

    private Integer empNo;
    private LocalDate fromDate;

}
