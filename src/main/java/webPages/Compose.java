package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Compose {

	@FindBy(xpath = "(//div[contains(text(),'Compose')])[1]")
	private WebElement compose;
	
	@FindBy(xpath = "(//div[@id=':q4'])[1]")
	private WebElement To;
	
	@FindBy(xpath = "(//input[@id=':pt'])[1]")
	private WebElement Subject;
	
	@FindBy(xpath = "(//div[@id=':qz'])[1]")
	private WebElement messagebody;
	
	@FindBy(xpath = "(//div[@id=':o6'])[1]")
	private WebElement sendButton;
	
	public Compose(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonCompose()
	{
		compose.click();
	}
	public void enterToEmail()
	{
		To.sendKeys("acxs@gmail.com");
	}
	public void enterSubject()
	{
		Subject.sendKeys("Incubyte");
	}
	public void enterMessage()
	{
		messagebody.sendKeys("Automation QA test for Incubyte");
	}
	public void clickonSendButton()
	{
		sendButton.click();
	}
	
}
