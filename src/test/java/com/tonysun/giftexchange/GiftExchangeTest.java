package com.tonysun.giftexchange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftExchangeTest {
	
	GiftExchange giftExchange;
	
	@Before
	public void setup(){
		giftExchange = new GiftExchange();
		Person[] persons = new Person[6];
		giftExchange.personLength = 6;
		giftExchange.persons = persons;
		persons[0] = new Person(0, "lili", "lee", "lili@example.com");
		persons[1] = new Person(1, "kevin", "lee", "kevin@example.com");
		persons[2] = new Person(2, "ray", "lee", "ray@example.com");
		persons[3] = new Person(3, "alex", "kull", "alex@example.com");
		persons[4] = new Person(4, "harry", "potter", "harry@example.com");
		persons[5] = new Person(5, "lizz", "potter", "lizz@example.com");
		List<Person> list1 = new ArrayList<>();
		list1.add(persons[0]);
		list1.add(persons[1]);
		list1.add(persons[2]);
		List<Person> list2 = new ArrayList<>();
		list2.add(persons[3]);
		List<Person> list3 = new ArrayList<>();
		list3.add(persons[4]);
		list3.add(persons[5]);
		Family family1 = new Family(1, list1);
		Family family2 = new Family(1, list2);
		Family family3 = new Family(1, list3);
		giftExchange.giverFamily = new PriorityQueue<>(new FamilyComparator());
		giftExchange.giverFamily.add(family1);
		giftExchange.giverFamily.add(family2);
		giftExchange.giverFamily.add(family3);
	}
	
	@After
	public void destroy(){
		giftExchange.giverFamily = null;
		giftExchange.persons = null;
		giftExchange = null;
	}

	@Test
	public void TestSwapPosition(){
		giftExchange.swapPosition(giftExchange.persons[1], giftExchange.persons[3]);
		Assert.assertEquals(giftExchange.persons[1].getId(), 1);
		Assert.assertEquals(giftExchange.persons[1].getFirstName(), "alex");
		Assert.assertEquals(giftExchange.persons[1].getLastName(), "kull");
		Assert.assertEquals(giftExchange.persons[1].getEmail(), "alex@example.com");
		
		Assert.assertEquals(giftExchange.persons[2].getId(), 2);
		Assert.assertEquals(giftExchange.persons[2].getFirstName(), "ray");
		Assert.assertEquals(giftExchange.persons[2].getLastName(), "lee");
		Assert.assertEquals(giftExchange.persons[2].getEmail(), "ray@example.com");
		
		Assert.assertEquals(giftExchange.persons[3].getId(), 3);
		Assert.assertEquals(giftExchange.persons[3].getFirstName(), "kevin");
		Assert.assertEquals(giftExchange.persons[3].getLastName(), "lee");
		Assert.assertEquals(giftExchange.persons[3].getEmail(), "kevin@example.com");
	}
	
	@Test
	public void TesTexchangeGifts(){
		List<Gift> gifts = giftExchange.exchangeGifts();
		giftExchange.printResultList(gifts);
		Set<Person> gifterSet = new HashSet<>();
		Set<Person> recipientSet = new HashSet<>();
		for(Gift gift:gifts){
			//System.out.println(gift.getGifter().getFirstName()+" "+gift.getGifter().getLastName()+"->"
			//		+gift.getRecipient().getFirstName()+" "+gift.getRecipient().getLastName());
			Assert.assertNotEquals(gift.getGifter().getLastName(), gift.getRecipient().getLastName());
			Assert.assertTrue(gifterSet.add(gift.getGifter()));
			Assert.assertTrue(recipientSet.add(gift.getRecipient()));
		}
	}
}
