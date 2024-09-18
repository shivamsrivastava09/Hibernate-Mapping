package com.jsp.hibernate_onetoone_uni.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.jsp.hibernate_onetoone_uni.dao.PersonVoterDao;
import com.jsp.hibernate_onetoone_uni.entity.Person;
import com.jsp.hibernate_onetoone_uni.entity.VoterId;

/**
 * Hello world!
 */
public class PersonController {
	public static void main(String[] args) {
		PersonVoterDao dao = new PersonVoterDao();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. TO INSERT THE PERSON AND VOTER DETAILS\n");
			int option = sc.nextInt();
			
			switch (option) {
			case 1:
				System.out.println("ENTER THE VOTER ID");
				int id=sc.nextInt();
				System.out.println("ENTER THE ADRESS OF THE VOTER");
				sc.nextLine();
				String address=sc.nextLine();
				System.out.println("ENTER THE DATE OF BIRTH OF THE VOTER");
				String dob=sc.next();
				System.out.println("ENTER THE GENDER OF THE VOTER");
				String gender=sc.next();
				System.out.println("ENTER THE DATE OF ISSUE FOR THE VOTER CARD");
				String doi=sc.next();
				VoterId voter = new VoterId(id, address, LocalDate.parse(dob), gender, LocalDate.parse(doi));
				System.out.println("ENTER THE ID FOR THE PERSON");
				int pId=sc.nextInt();
				System.out.println("ENTER THE NAME OF THE PERSON");
				sc.nextLine();
				String pName=sc.nextLine();
				System.out.println("ENTER THE EMAIL OF THE PERSON");
				String email=sc.next();
				System.out.println("ENTER THE PHONE NUMBER OF THE PERSON");
				long no=sc.nextLong();
				Person person=new Person(pId, pName, email, no, voter);
				System.out.println(dao.savePersonVoterDao(voter,person));
				break;
			}
		}

	}
}
