package com.tonysun.giftexchange;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GiftExchange {
	
	Person[] persons;
	PriorityQueue<Family> giverFamily; 
	int personLength = 0;
	
	public void init(){
		persons = new Person[1000];
		giverFamily = new PriorityQueue<>(new FamilyComparator());
		try{
			loadParticipants();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void loadParticipants() throws FileNotFoundException, IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(Util.filename))) {
			int familyId = 0;
			int personIndex = 0;
			Family family = new Family(familyId++);
		    String line = br.readLine();
		    while (line != null) {
		        String[] person = line.split("\\s");
		        if(person.length == 3){
		        	Person p = new Person(personIndex, person[0], person[1], person[2]);
		        	family.getMembers().add(p);
		        	persons[personIndex++] = p;
		        }else{
		        	if(family.getMembers().size() > 0){
		        		giverFamily.add(family);
		        		family = new Family(familyId++);
		        	}
		        }
		        line = br.readLine();
		    }
		    if(family.getMembers().size() > 0){
        		giverFamily.add(family);
        		family = new Family(familyId++);
        	}
		    personLength = personIndex;
		}
	}
	
	public List<Gift> exchangeGifts(){
		List<Gift> gifts = new ArrayList<>();
		int maxEnd = personLength-1;
		while(!giverFamily.isEmpty()){
			int currEnd = maxEnd;
			//start finding person1
			Family family1 = giverFamily.poll();
			int random1 = Util.generateRandomNumber(family1.getMembers().size());
			Person p1 = family1.getMembers().remove(random1);
			if(family1.getMembers().size() > 0){
				giverFamily.add(family1);
			}
			
			//move persons from the same family to the end of the array
			if(p1.getId() <= currEnd){
				swapPosition(p1, persons[currEnd]);
				currEnd--;
			}
			if(!family1.getMembers().isEmpty()){
				for(Person p:family1.getMembers()){
					if(p.getId() <= currEnd){
						swapPosition(p, persons[currEnd]);
						currEnd--;
					}
				}
			}
			
			//start finding person2
			int random2 = Util.generateRandomNumber(currEnd+1);
			swapPosition(persons[random2], persons[maxEnd]);
			Person p2 = persons[maxEnd];
			maxEnd--;
			
			//make sure the last person won't got his own gift
			if(p1.getId() == p2.getId()){
				Person lastRecipient = gifts.get(gifts.size()-1).getRecipient();
				gifts.get(gifts.size()-1).setRecipient(p2);
				p2 = lastRecipient;
			}
			Gift gift = new Gift(p1, p2);
			gifts.add(gift);
		}
		return gifts;
	}
	
	public void swapPosition(Person p1, Person p2){
		if(p1.getId() != p2.getId()){
			persons[p1.getId()] = p2;
			persons[p2.getId()] = p1;
			int tempId = p1.getId();
			p1.setId(p2.getId());
			p2.setId(tempId);
		}
	}
	
	public void printResultList(List<Gift> gifts){
		for(Gift gift:gifts){
			if(Util.user != null && Util.pwd != null){
				Util.sendEmail(gift.getGifter(), gift.getRecipient());
			}
			System.out.println(gift.getGifter().getFirstName()+" "+gift.getGifter().getLastName()+"->"
					+gift.getRecipient().getFirstName()+" "+gift.getRecipient().getLastName());
		}
	}
	
	public void startGame(){
		init();
		List<Gift> gifts = exchangeGifts();
		printResultList(gifts);
	}
	
	public static void main(String[] args){
		if(args.length > 0){
			String command = "";
            for(String c:args){
            	if(command.equalsIgnoreCase("-f")){
            		Util.filename = c;
            	}else if(command.equalsIgnoreCase("-u")){
            		Util.user = c;
            	}else if(command.equalsIgnoreCase("-p")){
            		Util.pwd = c;
            	}
            	command = c;
            }
        }
		if(Util.filename != null){
			GiftExchange ge = new GiftExchange();
			ge.startGame();
		}else{
			System.err.println("f command is required, please use -f ???");
		}
	}
}
