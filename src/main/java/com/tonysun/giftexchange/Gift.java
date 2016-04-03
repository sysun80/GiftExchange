package com.tonysun.giftexchange;

public class Gift {
	Person gifter;
	Person recipient;
	
	public Gift(Person p1, Person p2){
		this.gifter = p1;
		this.recipient = p2;
	}

	public Person getGifter() {
		return gifter;
	}

	public void setGifter(Person gifter) {
		this.gifter = gifter;
	}

	public Person getRecipient() {
		return recipient;
	}

	public void setRecipient(Person recipient) {
		this.recipient = recipient;
	}
}
