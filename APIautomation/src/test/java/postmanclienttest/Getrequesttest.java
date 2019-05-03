package postmanclienttest;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import postmanbase.Testbase;
import postmanclient.Getrequest;

public class Getrequesttest extends Testbase {

	Testbase testbase;
	
	String geturl;
	String getrequesturl;
	CloseableHttpResponse httpresponse;

	@BeforeMethod
	public void setup() {
		testbase = new Testbase();
         geturl = prop.getProperty("getrequesturl");
	}

	@Test
	public void gettest() throws ClientProtocolException, IOException {
		Getrequest getrequest = new Getrequest();
		getrequest = new Getrequest();
	CloseableHttpResponse httpresponse=	getrequest.get(geturl);
		//Status code
		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode,RESPOSE_STATUS_CODE_200,"Status is not equals to 200");
		
		
		//Json String
		String responsestring = EntityUtils.toString(httpresponse.getEntity(),"UTF-8");
		String Responsestring = responsestring.substring(2);
		JSONObject jsonresponse = new JSONObject(Responsestring);
		System.out.println("JSON Response"  +jsonresponse);
		
		//Headers
		Header[] headersarray = httpresponse.getAllHeaders();
		HashMap<String,String> allheaders =new HashMap<String,String>();
		 for(Header header : headersarray ) {
			 allheaders.put(header.getName(),header.getValue());
			  }
		 System.out.println("Headers  " +allheaders );
		
		}
	
		
	}

