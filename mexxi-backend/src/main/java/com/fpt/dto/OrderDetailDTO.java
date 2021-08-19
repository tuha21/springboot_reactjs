package com.fpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO implements Serializable {

    private Integer id;

    private Integer orderId;

    private Integer productId;

    private Double price;

    private Integer size;

    private Integer quantity;

}
