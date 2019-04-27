package amazonaws.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import demoBase.Testbase;



public class Userspage extends Testbase {

	@FindBy(xpath = "//div[@id='q_username_input']//select")
	WebElement UserName;
	@FindBy(xpath = "//input[@id='q_username']")
	WebElement UserNameText;
	@FindBy(xpath = "//div[@id='q_email_input']//select")
	WebElement Email;
	@FindBy(xpath = "//input[@id='q_email']")
	WebElement EmailText;
	@FindBy(xpath = "//input[@id='q_created_at_gteq_datetime']")
	WebElement Fromdate;
	@FindBy(xpath = "//input[@id='q_created_at_lteq_datetime']")
	WebElement Todate;
	@FindBy(xpath = "//div[@class='buttons']//input[@type='submit']")
	WebElement Filter;

	public Userspage() {
		PageFactory.initElements(driver, this);
	}

	public String geturl() {

		String url = driver.getCurrentUrl();
		System.out.println(url);
		return url;
	}
// Filter Users
	
	public void selectFilter(int UserNameIndex, int EmailIndex, String UserNametext, String Emailtext, String FromDate,
			String ToDate) {
		Select username = new Select(UserName);
		username.selectByIndex(UserNameIndex);
		UserNameText.sendKeys(UserNametext);
		Select email = new Select(Email);
		email.selectByIndex(EmailIndex);
		EmailText.sendKeys(Emailtext);
		Fromdate.sendKeys(FromDate);
		Todate.sendKeys(ToDate);
		Filter.click();

		List<WebElement> Results = driver.findElements(By.xpath("//div[@class='index_content']"));

		int numberofresults = Results.size();
		if (numberofresults != 0) {

			for (int i = 0; i < numberofresults; i++) {
				String results = Results.get(i).getText();
				System.out.println(results);
				System.out.println(results.contains(UserNametext));
				System.out.println(results.contains(Emailtext));

			}
		}

		else {
			driver.findElement(By.xpath("//span[contains(text(),'No Users found')]"));
			System.out.println("No Users Found");
		}
	}

}
	

	

