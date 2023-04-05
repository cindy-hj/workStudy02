package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	// FK user_id
	@JsonBackReference
	@JoinColumn(name="user_id")
	@ManyToOne
	private User user;
	
	private LocalDateTime orderDate = LocalDateTime.now();
	
	private int totalPrice;
	
	@Column(length = 10)
	private String orderState;
	
	@OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<OrderDetail> orderDetail;
}
