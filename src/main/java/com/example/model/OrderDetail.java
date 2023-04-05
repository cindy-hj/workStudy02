package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_orderdetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderdetailId;
	
	// FK
	@JoinColumn(name = "order_id")
	@ManyToOne
	@JsonBackReference
	private Order orders;
	
	@JoinColumn(name = "product_id")
	@ManyToOne
	@JsonBackReference
	private Product products;
	
	private int count;
	
	private int orderdetailPrice;
	
	
}
