package amazonaws.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazonaws.pages.Homepage;
import amazonaws.pages.Newuserpage;
import demoBase.Testbase;

public class Newuserpagetest extends Testbase {
	Homepage homepage;
	Newuserpage newuserpage;

	public Newuserpagetest() {

		super();

	}

	// Launch the NewUser page

	@BeforeMethod
	public void setup() {
		intialization();
		homepage = new Homepage();
		newuserpage = homepage.OpenNewUserPage();
	}

// Validate title

	@Test(priority = 2)
	public void verifyTitle() {
		String Title = newuserpage.verifytitle();
		System.out.println(Title);

		Assert.assertEquals(Title, "New User | Active Admin Depot");
	}
// Click Cancel button 

	@Test(priority = 3)
	public void verifycanceluser() {
		String Url = newuserpage.Cancelaccount();
		System.out.println(Url);
		Assert.assertEquals(Url, "http://ec2-54-84-52-184.compute-1.amazonaws.com:8080/admin/users");

	}

	// Validate BlankUserName

	@Test
	public void BlankUserNameTest() {
		boolean text = newuserpage.BlankUserName();
		Assert.assertTrue(text);
	}

	// Validate BlankPassword

	@Test
	public void BlankPasswordTest() {
		boolean text = newuserpage.BlankPassword();
		Assert.assertTrue(text);
	}
	// Validate BlankEmail

	@Test
	public void BlankEmailTest() {
		boolean text = newuserpage.BlankEmail();
		Assert.assertTrue(text);
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
