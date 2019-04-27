package amazonaws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoBase.Testbase;

public class Newuserpage extends Testbase {
	@FindBy(xpath = "//input[@id='user_username']")
	WebElement Username;
	@FindBy(xpath = "//input[@id='user_password']")
	WebElement Password;
	@FindBy(xpath = "//input[@id='user_email']")
	WebElement Email;
	@FindBy(xpath = "//li[@id='user_submit_action']")
	WebElement createuser;
	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement Cancel;
	@FindBy(xpath = "//li[@id='user_username_input']//p[contains(text(),\"can't be blank\")]")
	WebElement UserNameBlank;
	@FindBy(xpath = "//li[@id='user_password_input']//p[contains(text(),\"can't be blank\")]")
	WebElement PasswordBlank;
	@FindBy(xpath = "//li[@id='user_email_input']//p[contains(text(),\"is invalid\")]")
	WebElement EmailBlank;

	public Newuserpage() {
		PageFactory.initElements(driver, this);

	}
// Verify Title

	public String verifytitle() {
		String title = driver.getTitle();
		return title;
	}
//Create User

	public Userdetailspage CreateAccount() {
		Username.sendKeys(prop.getProperty("username"));
		Password.sendKeys(prop.getProperty("password"));
		Email.sendKeys(prop.getProperty("email"));
		createuser.click();

		return new Userdetailspage();
	}

//Blank UserName

	public boolean BlankUserName() {
		Password.sendKeys(prop.getProperty("password"));
		Email.sendKeys(prop.getProperty("email"));
		createuser.click();
		return UserNameBlank.isDisplayed();
	}

//Blank Password

	public boolean BlankPassword() {
		Username.sendKeys(prop.getProperty("username"));
		Email.sendKeys(prop.getProperty("email"));
		createuser.click();
		return PasswordBlank.isDisplayed();

	}

//Blank Email

	public boolean BlankEmail() {
		Username.sendKeys(prop.getProperty("username"));
		Password.sendKeys(prop.getProperty("password"));
		createuser.click();
		return EmailBlank.isDisplayed();

	}

//Cancel Creating Account

	public String Cancelaccount() {
		Username.sendKeys(prop.getProperty("username"));
		Password.sendKeys(prop.getProperty("password"));
		Email.sendKeys(prop.getProperty("email"));
		Cancel.click();
		String url = driver.getCurrentUrl();
		return url;

	}

}
