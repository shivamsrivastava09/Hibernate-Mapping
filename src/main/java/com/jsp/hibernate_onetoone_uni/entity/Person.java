package com.jsp.hibernate_onetoone_uni.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
	
	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
	
	@JoinColumn(name="voter_id")
	@OneToOne
	private VoterId V;

}
