package amazonaws.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazonaws.pages.Homepage;
import demoBase.Testbase;

public class Homepagetest extends Testbase {
	Homepage homepage;

	public Homepagetest() {
		super();
		}

	@BeforeMethod
	public void setup() {
		intialization();
		homepage = new Homepage();
	}

	// Validate URL

	@Test
	public void currenturltest() {
		String CurrentUrl = homepage.currenturl();
		System.out.println(CurrentUrl);
		Assert.assertEquals(CurrentUrl, "http://ec2-54-84-52-184.compute-1.amazonaws.com:8080/admin/");
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
