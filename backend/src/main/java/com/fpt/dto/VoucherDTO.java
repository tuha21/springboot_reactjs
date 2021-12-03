package com.fpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherDTO {

    private Integer id;

    private String name;

    private BigDecimal conditions;

    private BigDecimal discount;

    private String code;

    private Integer status;

    private String description;
}
