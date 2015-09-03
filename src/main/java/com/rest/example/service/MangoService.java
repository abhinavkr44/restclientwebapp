package com.rest.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.rest.example.bean.Person;

@Service
public class MangoService {
	
	@Autowired
	DB database;
	
	public void insertDocument(Object object, String collectionDoc) {
		DBCollection collection = database.getCollection(collectionDoc);
		//DBObject myPerson = new BasicDBObject("_id", "jo").append("fname", "Abhinav").append("lname", "Kumar").append("age", "25");
		if(object instanceof Person){
			collection.insert(toDBObject((Person)object));
		} else {
			System.out.println("not an instance of person");
		}
	}
	
	public List getAllDocuments(String collectionDoc) {
		DBCollection collection = database.getCollection(collectionDoc);
		List listOfPerson = new ArrayList();
		if(collectionDoc.equals("person")){
			DBCursor cursor = collection.find();
			try {
				while(cursor.hasNext()) {
					listOfPerson.add(cursor.next());
				}
			} finally {
				cursor.close();
			}
		} else {
			System.out.println("not an instance of person");
		}
		return listOfPerson;
	}
	
	public static final DBObject toDBObject(Person person) {
	    return new BasicDBObject()
	                     .append("fname", person.getFname())
	                     .append("lname", person.getLname())
	                     .append("age", person.getAge());
	}
}
