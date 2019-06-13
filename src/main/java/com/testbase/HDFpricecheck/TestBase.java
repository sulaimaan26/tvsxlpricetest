package com.testbase.HDFpricecheck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.util.UtilTvsxl;

import okio.Timeout;

public class TestBase {
	
	public static int rnum=0;
	public static WebDriver driver;
	static Properties prop;
	
	
	public TestBase() {
		// TODO Auto-generated constructor stub
		FileInputStream file;
		try {
			System.out.println(System.getProperty("user.dir"));
			prop=new Properties();
			file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
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
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver");
		}
		else {
			System.out.println("Failed");
		}
		try {
			driver.manage().timeouts().pageLoadTimeout(UtilTvsxl.pageloadtimeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(UtilTvsxl.implicitlyWait, TimeUnit.SECONDS);
			driver.manage().window().maximize();;
			driver.get(prop.getProperty("url"));
		
		}catch(TimeoutException e) {
			System.out.println("Alert Site seems very slow!!!! Please increase the page load time out in util class");
			driver.close();
			System.exit(0);
			
		}
		
	}

}
