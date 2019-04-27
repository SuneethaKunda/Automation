package amazonaws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoBase.Testbase;

public class Homepage extends Testbase {
	@FindBy(xpath = "//a[contains(text(),'Users')]")
	WebElement Users;
	@FindBy(xpath = "//a[contains(text(),'New User')]")
	WebElement NewUser;

	public Homepage() {
		PageFactory.initElements(driver, this);

	}
	
//Actions
	
	public Newuserpage OpenNewUserPage() {
		Users.click();
		NewUser.click();
		return new Newuserpage();
	}

	public Userspage OpenUserPage()

	{
		Users.click();

		return new Userspage();
	}

	public String currenturl() {
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}
}
