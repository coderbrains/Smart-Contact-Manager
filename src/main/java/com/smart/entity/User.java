package com.smart.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int userId;
	private String userName;
	@Column(unique =  true)
	private String email;
	private String password;
	private String imageUrl;
	@Column(length =  1200)
	private String userAbout;
	private String userRole;
	private boolean enable;
	@OneToMany(mappedBy = "user", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Contact> contacts = new ArrayList<>();
	
	
}
