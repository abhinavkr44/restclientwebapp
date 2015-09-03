package com.rest.example;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestClient {

	@Autowired
	private WebClient webClient;

	@RequestMapping(value = "/getJsonResponse", method = RequestMethod.GET)
	public @ResponseBody String getJsonResponse() {
	  Response response = webClient.post(null);
	  String json = null;
	  if(response.getStatus() == 200){
		  json = response.readEntity(String.class);
	  }
	  return json;
	}
	
	@RequestMapping(value = "/setJsonRequest", method = RequestMethod.POST)
	public @ResponseBody String setJsonRequest() {
	  Response response = webClient.post(null);
	  String json = null;
	  if(response.getStatus() == 200){
		  json = response.readEntity(String.class);
	  }
	  return json;
	}
	
  }
