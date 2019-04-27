package postmanclienttest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import postmanbase.Testbase;
import postmanclient.Postrequest;
import postmandata.Postrequestdata;


public class Postrequesttest extends Testbase {
	Testbase testbase;
	Postrequest postrequest;
	String apiurl;
	CloseableHttpResponse closeablehttpresponse;
	
	
	@BeforeMethod
	public void setup() {
		testbase= new Testbase();
		 apiurl= prop.getProperty("url");
		
		}
	
	@Test
	public void postrequest() throws JsonGenerationException, JsonMappingException, IOException {
		postrequest =new Postrequest();
		HashMap<String,String> headermap= new HashMap<String,String>();
		headermap.put("Content-Type","application/json");
		
		//Jackson API
		ObjectMapper mapper =new ObjectMapper();
		Postrequestdata data =new Postrequestdata(11111,9735,"Its Me","Hello");
		
		//Object to JsonFile
		mapper.writeValue(new File("C:\\Users\\Suneetha\\eclipse-workspace\\APIautomation\\src\\main\\java\\postmandata\\Jsondata"), data);
		
		
		//Object to Json in String
		String jsonString= mapper.writeValueAsString(data);
		System.out.println(jsonString);
		closeablehttpresponse = postrequest.post(apiurl, jsonString, headermap);
		
		//Status Code
		int statuscode=closeablehttpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode,testbase.RESPOSE_STATUS_CODE_201);
		
		//Json String
		String responsestring = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");
		JSONObject response = new JSONObject(responsestring);
		System.out.println("The response from API :" + response);
		
		//Json to Java Object
		Postrequestdata request = mapper.readValue(responsestring, Postrequestdata.class);
		System.out.println(request);
		System.out.println(data.getTitle().equals(request.getTitle()));
		System.out.println(data.getBody().equals(request.getBody()));
		
		
		
	}
}
