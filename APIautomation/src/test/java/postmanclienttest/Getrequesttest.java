package postmanclienttest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import postmanbase.Testbase;
import postmanclient.Getrequest;

public class Getrequesttest extends Testbase {

	Testbase testbase;
	String geturl;
	String getrequesturl;
	
	
	@BeforeMethod
	public void setup()
{
		testbase =new Testbase();
		
		geturl= prop.getProperty("getrequesturl");
		
		}

	@Test
	public void gettest() throws ClientProtocolException, IOException {
		Getrequest getrequest = new Getrequest();
		getrequest = new Getrequest();
		getrequest.get(geturl);
	}}
