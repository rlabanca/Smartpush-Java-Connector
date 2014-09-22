package br.com.instead.smartpush.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import br.com.instead.smartpush.model.SmartpushRequest;
import br.com.instead.smartpush.model.SmartpushResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SmartpushClient {

	private static SmartpushClient instance;
	
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
		HttpPost method = new HttpPost("http://api.instad.com.br/push");
		CloseableHttpResponse response = null;
		
		try {
			
			System.out.println(json);
			
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("data", json));
            
            UrlEncodedFormEntity form = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
            
            method.setEntity(form);
			
            method.setHeader("Content-Type", "application/x-www-form-urlencoded");
            
			response = httpclient.execute(method);
			
			String responseJson = EntityUtils.toString(response.getEntity());
			
			System.out.println(responseJson);

			SmartpushResponse smartResponse = gson.fromJson(responseJson, SmartpushResponse.class);
			
			return smartResponse;
			
			
			
		} finally {
			
			if (response != null) {
				response.close();
			}
			
		}
		
	}
	
}
