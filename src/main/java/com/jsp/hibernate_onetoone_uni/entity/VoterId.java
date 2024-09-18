package com.jsp.hibernate_onetoone_uni.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class VoterId {
	
	@Id
	private int idNumber;
	private String address;
	private LocalDate dob;
	private String gender;
	private LocalDate doi;

}
