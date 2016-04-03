package com.tonysun.giftexchange;

import java.util.ArrayList;
import java.util.List;

public class Family {
	private int id;
	private List<Person> members;
	
	public Family(){
		members = new ArrayList<>();
	}
	
	public Family(int id){
		this.id = id;
		this.members = new ArrayList<>();
	}
	
	public Family(int id, List<Person> members){
		this.id = id;
		this.members = members;
	}
	
	public Family clone(){
		List<Person> cloneMembers = new ArrayList<>(members);
		return new Family(this.id, cloneMembers);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Person> getMembers() {
		return members;
	}
	public void setMembers(List<Person> members) {
		this.members = members;
	}
}
