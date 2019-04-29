package postmanclient;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Getrequest{
	
	
	//Get Method
	public void get(String Geturl) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(Geturl);
		CloseableHttpResponse httpresponse = httpclient.execute(httpget);
	//Status code
	int statuscode = httpresponse.getStatusLine().getStatusCode();
	System.out.println(statuscode);
	
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
