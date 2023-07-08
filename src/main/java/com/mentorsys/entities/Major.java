package com.mentorsys.entities;

import javax.persistence.*;

@Entity
@Table(name ="MAJOR")
public class Major {

	@Id
	/*@SequenceGenerator(name = "FACULTY_seq", sequenceName = "FACULTY_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACULTY_seq")*/
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(unique = true,name="Contact_Details")
	private String phoneno;
	
	@Column(unique = true, name="Email")
	private String email;
	
	@Column(name= "Seats_Available")
	private String seats;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}
	
}
