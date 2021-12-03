package com.fpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private Integer id;


	private String name;


	private String image;


	private Double price;


	private Integer sale;


	private Date createDate;


	private Integer status;


	private Integer categoryId;
}
