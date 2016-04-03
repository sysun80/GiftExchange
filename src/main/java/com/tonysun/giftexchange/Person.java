package com.tonysun.giftexchange;

public class Person {
	private int id;
	private int familyId;
	private String firstName;
	private String lastName;
	private String email;
	
	public Person(int id, int familyId, String firstname, String lastname, String email){
		this.id = id;
		this.familyId = familyId;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFamilyId() {
		return familyId;
	}
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
