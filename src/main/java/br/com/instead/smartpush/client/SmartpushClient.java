package br.com.instead.smartpush.client;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import br.com.instead.smartpush.model.SmartpushRequest;
import br.com.instead.smartpush.model.SmartpushResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SmartpushClient {

	private static SmartpushClient instance;
	
	private HttpClient client; 
	
	public static SmartpushClient getInstance() {
		if  (instance == null) {
			instance = new SmartpushClient();
		}
		return instance;
	}
	
	private SmartpushClient() {
		
	}
	
	public SmartpushResponse post(SmartpushRequest request) throws IOException {
		
		Gson gson = new GsonBuilder()
	    					.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
	    					.create();
		
		String json = gson.toJson(request);
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost method = new HttpPost("http://localhost/");
		CloseableHttpResponse response = null;
		
		try {
		    
			method.setEntity(new StringEntity(json));
			
			response = httpclient.execute(method);			
			String responseJson = EntityUtils.toString(response.getEntity());
//			String responseJson = "{\n    \"status_code\": 200,\n    \"status_message\": \"OK\",\n    \"response\": {\n   \"pushid\": \"AFb123d90C00134\"\n}\n}\n\n";
			
			SmartpushResponse smartResponse = gson.fromJson(responseJson, SmartpushResponse.class);
			
			return smartResponse;
			
			
			
		} finally {
			
			if (response != null) {
				response.close();
			}
			
		}
		
	}
	
}
