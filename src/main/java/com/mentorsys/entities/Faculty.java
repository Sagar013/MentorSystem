package com.mentorsys.entities;

import javax.persistence.*;

@Entity
@Table(name="FACULTY")
public class Faculty {

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)*/
	@Id
	/*@SequenceGenerator(name = "FACULTY_seq", sequenceName = "FACULTY_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACULTY_seq")*/
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Specialization")
	private String specialization;
	@Column(unique = true,name="Contact_Details")
	private String phoneno;
	@Column(unique = true, name="Email")
	private String email;
	@Column(name = "Description")
	private String description;
	
	/*@ManyToOne
	private User user;*/
	
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	
	
}
