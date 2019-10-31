package com.qa.Illuminate.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentHtmlReporter reporter;
	public static ExtentTest log;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\sh\\workspace\\Test\\src\\main\\java\\com\\qa\\Illuminate\\config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
    
	public static void browserName() {
		String br = prop.getProperty("browser");

		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sh\\Downloads\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\sh\\Downloads\\drivers\\iedriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
