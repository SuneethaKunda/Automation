package amazonaws.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazonaws.pages.Userspage;
import amazonaws.pages.Homepage;
import demoBase.Testbase;

public class Userspagetest extends Testbase {

	Homepage homepage;
	Userspage userspage;

	public Userspagetest() {

		super();

	}

	@BeforeMethod
	public void setup()

	{
		intialization();

		homepage = new Homepage();
		userspage = homepage.OpenUserPage();
	}
// Validate URL

	@Test(priority = 1)
	public void geturlTest() {
		String url = userspage.geturl();
		Assert.assertEquals(url, "http://ec2-54-84-52-184.compute-1.amazonaws.com:8080/admin/users");
	}
	// FilterUsers

	@Test(priority = 2)
	public void FilterUsersTest() {
		userspage.selectFilter(1, 0, "test", "test", "2019-04-16", "2019-04-25");

	}

	@AfterMethod
	public void quit() {
		driver.close();
	}
	}
