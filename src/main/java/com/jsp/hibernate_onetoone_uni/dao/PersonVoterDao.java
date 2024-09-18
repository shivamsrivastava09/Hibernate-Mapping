package com.jsp.hibernate_onetoone_uni.dao;

import com.jsp.hibernate_onetoone_uni.entity.Person;
import com.jsp.hibernate_onetoone_uni.entity.VoterId;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonVoterDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Person savePersonVoterDao(VoterId voter,Person person) {
		try {
			et.begin();
			em.persist(person);
			em.persist(voter);
			et.commit();
			return person;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
