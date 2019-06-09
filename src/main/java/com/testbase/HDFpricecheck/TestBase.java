package com.testbase.HDFpricecheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	static Properties prop;
	
	public TestBase() {
		// TODO Auto-generated constructor stub
		FileInputStream file;
		try {
			prop=new Properties();
			file = new FileInputStream("/home/epage/eclipse-workspace/HDFpricecheck/config.properties");
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void intialization() {
		if(prop.getProperty("browser").contentEquals("chrome")) {
			driver=new ChromeDriver();
			System.setProperty("webdriver.chrome.driver","/home/epage/eclipse-workspace/HDFpricecheck/chromedriver");
		}
		else {
			System.out.println("Failed");
		}
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();;
		driver.get(prop.getProperty("url"));
	
	}

}
