package com.detyrajpa.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class DeptManagerIdEntity implements Serializable {

    private Integer empNo;
    private Integer deptNo;

}
