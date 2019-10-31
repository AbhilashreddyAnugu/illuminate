package com.qa.Illuminate.TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Illuminate.Base.TestBase;
import com.qa.Illuminate.Pages.Loginpage;
import com.qa.Illuminate.Util.TestUtil;

public class LoginTest extends TestBase {
	Loginpage loginpage;
	TestUtil testutil;
	
	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		browserName();
		loginpage = new Loginpage();
		testutil=new TestUtil();
	}

	@DataProvider
	public Object[][] getTestLoginData(){
		Object data[][] =TestUtil.getTestData("login");
		return data;
	}
	
	@Test(dataProvider="getTestLoginData")
	public void verifyLogintest(String username,String password)
	{
		loginpage.login(username, password);
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
