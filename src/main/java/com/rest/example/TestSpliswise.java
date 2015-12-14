package com.rest.example;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.rest.example.bean.SplitwiseApi;

public class TestSpliswise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		System.out.println(response.getBody());
		
		
		
		/*OAuthRequest request1 = new OAuthRequest(Verb.GET, "http://api.company.com/protected-resource/");
		
		Response response1 = request1.send();
		System.out.println(response.getBody());*/
	}

}
