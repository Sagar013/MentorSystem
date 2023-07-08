package com.mentorsys.entities;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@SequenceGenerator(name = "USER_seq", sequenceName = "USER_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_seq")
	private int id;
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Column(unique = true, name = "Email")
	private String email;
	@Column(name = "Password", nullable=false)
	private String password;
	@Column(name = "Role")
	private String role;
	
	/*@OneToMany
	private List<Faculty> faculty = new ArrayList<>();
	*/
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

/*
	public List<Faculty> getFaculty() {
		return faculty;
	}


	public void setFaculty(List<Faculty> faculty) {
		this.faculty = faculty;
	}
*/

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", faculty=" + "]";
	}
	
	
	
}
