package com.rest.example;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.example.bean.Customer;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Component
public class RestClient {

	@Autowired
	private WebResource webResource;

	public List<Customer> getJsonResponse() {
		List<Customer> customerList = webResource.path("/customerList")
        			.accept(MediaType.APPLICATION_JSON)
        			.get(new GenericType<List<Customer>>() {});
		return customerList;
	}

	public String setJsonRequest() {
		return null;
	}

}
