package com.qa.Illuminate.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Illuminate.Base.TestBase;

public class Loginpage extends TestBase {
	
	@FindBy(name="emailid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="login_btn")
	WebElement loginbtn;
	
	public Loginpage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void login(String uname,String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
		
	}

}
