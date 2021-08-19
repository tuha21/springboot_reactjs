package com.fpt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image")
	private String image;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
}
