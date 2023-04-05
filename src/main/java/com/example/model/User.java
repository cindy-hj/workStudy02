package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_user")
public class User {
	@Id
	@Column(length = 50)
	private String userId;
	
	@Column(length = 50)
	private String userPw;

	@Column(length = 45)
	private String userName;

	@Column(length = 100)
	private String address;

	@Column(length = 45)
	private String phone;

	@Column(length = 45)
	private String tel;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Order> orders;
}
