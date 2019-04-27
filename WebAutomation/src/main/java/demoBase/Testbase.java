package demoBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase() {
		try {
		prop=new Properties();
		
		FileInputStream ip=new FileInputStream("C:\\Users\\Suneetha\\eclipse-workspace\\WebAutomation\\src\\main\\java\\democonfig\\configProperties");
		prop.load(ip);
		}
	catch(FileNotFoundException e)
	{ e.printStackTrace();
	}
		catch (IOException e)
		{
			e.printStackTrace();
		}
}
	public static void intialization() {
	String browsername = prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suneetha\\Downloads\\selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}
	else if (browsername.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Suneetha\\Downloads\\selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
		
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	
	}
}
