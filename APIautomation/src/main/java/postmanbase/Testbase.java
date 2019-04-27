package postmanbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Testbase {
	public  Properties prop;
	public int RESPOSE_STATUS_CODE_200 =200;
	public int RESPOSE_STATUS_CODE_201 =201;
	public int RESPOSE_STATUS_CODE_404 =404;
	public int RESPOSE_STATUS_CODE_400 =400;
	public int RESPOSE_STATUS_CODE_500 =500;

	
	public Testbase() {
		try {
		prop=new Properties();
		
		FileInputStream ip=new FileInputStream("C:\\Users\\Suneetha\\eclipse-workspace\\APIautomation\\src\\main\\java\\configproperties\\Configproperties");
		prop.load(ip);
		}
	catch(FileNotFoundException e)
	{ e.printStackTrace();
	}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}}





















































































