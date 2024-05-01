package com.detyrajpa.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
public class TitleIdEntity implements Serializable {

    private Integer employeeId;
    private String title;
    private LocalDate fromDate;


}
