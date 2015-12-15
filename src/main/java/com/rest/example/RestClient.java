package com.rest.example;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rest.example.bean.Customer;
import com.rest.example.bean.SplitwiseApi;
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
	
	public String getListOfCurrencies(){
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
		    public X509Certificate[] getAcceptedIssuers(){return null;}
		    public void checkClientTrusted(X509Certificate[] certs, String authType){}
		    public void checkServerTrusted(X509Certificate[] certs, String authType){}
		}};

		// Install the all-trusting trust manager
		try {
		    SSLContext sc = SSLContext.getInstance("TLS");
		    sc.init(null, trustAllCerts, new SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
		}
		
		
		OAuthService service = new ServiceBuilder()
		.provider(SplitwiseApi.class)
		.apiKey("AlFxMUiq1DLICUiAz6APo7QdK2ZuY23hHn5z06ly")
		.apiSecret("zQCGVXr8HwubKc6XQOezz5FiZChsdoLE4oMyxXVr")
		.build();
		//Token requestToken = service.getRequestToken();
		//String authUrl = service.getAuthorizationUrl(requestToken);
		//Verifier v = new Verifier("verifier you got from the user");
		//Token accessToken = service.getAccessToken(requestToken, verifier); // the requestToken you had from step 2
		OAuthRequest request = new OAuthRequest(Verb.GET, "https://secure.splitwise.com/api/v3.0/get_currencies");
		//service.signRequest(accessToken, request); // the access token from step 4
		Response response = request.send();
		/*JsonObject jsonObject = (JsonObject)new JsonParser().parse(response.getBody());
		JsonArray asJsonArray = jsonObject.getAsJsonArray("currencies");
		Iterator<JsonElement> iterator = asJsonArray.iterator();
		while(iterator.hasNext()){
			JsonElement next = iterator.next();
			JsonObject asJsonObject = next.getAsJsonObject();
			JsonElement jsonElement = asJsonObject.get("unit");
			System.out.println(jsonElement.getAsString());
		}*/
		return response.getBody();
	}

	public String setJsonRequest() {
		return null;
	}

}
