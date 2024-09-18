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
	
	public VoterId saveVoterDao(VoterId voter) {
		et.begin();
		em.persist(voter);
		et.commit();
		return voter;
	}
	
	public Person savePersonDao(Person person, int voterId) {
		VoterId voter=em.find(VoterId.class, voterId);
		person.setV(voter);
		et.begin();
		em.persist(person);
		et.commit();
		return person;
	}

}
