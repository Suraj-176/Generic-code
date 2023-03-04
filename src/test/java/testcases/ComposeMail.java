package testcases;

import org.testng.annotations.Test;

import generics.Excel;
import generics.SuperTest;
import webPages.Compose;
import webPages.LoginPage;


public class ComposeMail extends SuperTest {

	@Test
	public void test()
	{
		LoginPage l=new LoginPage(driver);
		String user = Excel.readData("LoginPage", 1, 0);
		l.enterEmail(user);
		l.clickNextButton();
		String pass = Excel.readData("LoginPage", 0, 1);
		l.enterPassword(pass);
		l.clickNextButton();
		
		Compose c=new Compose(driver);
		c.clickonCompose();
		c.enterToEmail();
		c.enterSubject();
		c.enterMessage();
		c.clickonSendButton();
	}
	
}
