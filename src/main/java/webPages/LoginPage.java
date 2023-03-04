package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "identifierId")
	private WebElement email;
	
	@FindBy(xpath = ".//span[text()='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath = ".//div[text()='Enter your password']")
	private WebElement password;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterEmail(String emailid)
	{
		email.sendKeys(emailid);
		
	}
	public void clickNextButton()
	{
		nextButton.click();
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	
}
