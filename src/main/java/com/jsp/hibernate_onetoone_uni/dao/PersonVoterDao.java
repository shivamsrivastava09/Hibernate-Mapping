package com.jsp.hibernate_onetoone_uni.dao;

import java.time.LocalDate;
import java.time.Period;

import com.jsp.hibernate_onetoone_uni.entity.Person;
import com.jsp.hibernate_onetoone_uni.entity.VoterId;
import com.jsp.hibernate_onetoone_uni.service.GovernmentService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PersonVoterDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	GovernmentService service = new GovernmentService();

	public Person savePersonVoterDao(VoterId voter, Person person) {
		try {
			Period period = service.ageCalculator(voter.getDob());
			person.setAge(period.getYears());
			et.begin();
			em.persist(person);
			em.persist(voter);
			et.commit();
			return person;

		} catch (Exception e) {
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
		VoterId voter = em.find(VoterId.class, voterId);
		Period period = service.ageCalculator(voter.getDob());
		person.setAge(period.getYears());
		person.setV(voter);
		et.begin();
		em.persist(person);
		et.commit();
		return person;
	}

	public Person getPersonDetailsById(int personId) {
		return em.find(Person.class, personId);
	}

	public boolean deleteVoteById(int vId) {
		VoterId voter = em.find(VoterId.class, vId);
		if (voter != null) {
			Query query = em.createNativeQuery("select * from person where voter_id=?", Person.class);
			query.setParameter(1, vId);
			Person person = (Person) query.getSingleResult();
			if (person != null) {
				person.setV(null);
				et.begin();
				em.merge(person);
				em.remove(voter);
				et.commit();
				return true;
			}
			else {
				et.begin();
				em.remove(voter);
				et.commit();
				return true;
			}
			
		} else {
			return false;
		}

	}
}
