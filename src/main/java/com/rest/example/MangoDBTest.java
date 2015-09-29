package com.rest.example;


public class MangoDBTest {/*

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		MongoClient mongoClient;
		try {
			mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
			DB database = mongoClient.getDB("restwebapp");
			DBCollection collection = database.getCollection("person");
			DBCursor cursor = collection.find();
			//DBObject myPerson = new BasicDBObject("_id", "jo").append("fname", "Abhinav").append("lname", "Kumar").append("age", "25");
			//Person myPerson = new Person("Abhinav", "Kumar", 22);
			//collection.insert(toDBObject(myPerson));
			while(cursor.hasNext()) {
				DBObject next = cursor.next();
				System.out.println(next);
			}
			mongoClient.close();
		} catch (UnknownHostException e) {	
			
		}
		
		
	}
	
	public static final DBObject toDBObject(Customer person) {
	    return new BasicDBObject()
	                     .append("fname", person.getFname())
	                     .append("lname", person.getLname())
	                     .append("age", person.getAge());
	}

*/}
