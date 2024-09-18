package com.jsp.hibernate_onetoone_uni.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.jsp.hibernate_onetoone_uni.dao.PersonVoterDao;
import com.jsp.hibernate_onetoone_uni.entity.Person;
import com.jsp.hibernate_onetoone_uni.entity.VoterId;

/**
 * Hello world!
 */
public class PersonVoterController {
	public static void main(String[] args) {
		PersonVoterDao dao = new PersonVoterDao();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. TO INSERT THE PERSON AND VOTER DETAILS\n2. TO INSERT VOTER\n3. TO INSERT PERSON WITH THE VOTER ID\n4. TO EXIT THE APPLICATION");
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
			case 2:
				System.out.println("ENTER THE VOTER ID");
				int nId=sc.nextInt();
				System.out.println("ENTER THE ADRESS OF THE VOTER");
				sc.nextLine();
				String nAddress=sc.nextLine();
				System.out.println("ENTER THE DATE OF BIRTH OF THE VOTER");
				String nDob=sc.next();
				System.out.println("ENTER THE GENDER OF THE VOTER");
				String nGender=sc.next();
				System.out.println("ENTER THE DATE OF ISSUE FOR THE VOTER CARD");
				String nDoi=sc.next();
				VoterId nVoter = new VoterId(nId, nAddress, LocalDate.parse(nDob), nGender,LocalDate.parse(nDoi));
				System.out.println(dao.saveVoterDao(nVoter)); 
				break;
			case 3:
				System.out.println("ENTER THE ID FOR THE PERSON");
				int npId=sc.nextInt();
				System.out.println("ENTER THE NAME OF THE PERSON");
				sc.nextLine();
				String npName=sc.nextLine();
				System.out.println("ENTER THE EMAIL OF THE PERSON");
				String nEmail=sc.next();
				System.out.println("ENTER THE PHONE NUMBER OF THE PERSON");
				long nNo=sc.nextLong();
				Person nPerson=new Person(npId, npName, nEmail, nNo, null);
				System.out.println("ENTER THE VOTER ID FOR THIS PERSON");
				int vId=sc.nextInt();
				System.out.println(dao.savePersonDao(nPerson,vId));
				break;
			case 4:
				System.out.println("THANK YOU.....");
				return;
			}
		}

	}
}
