package com.jsp.hibernate_onetoone_uni.service;

import java.time.LocalDate;
import java.time.Period;

public class GovernmentService {
	
	public Period ageCalculator(LocalDate date) {
		int pYear=date.getYear();
		int age=LocalDate.now().getYear()-pYear;
		Period period=Period.between(date, LocalDate.now());
		return period;
	}

}
