package com.testbase.HDFpricecheck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
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
			
			//System.out.println(System.getProperty("user.dir"));
			prop=new Properties();
			//CheckBrowserOS();
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
	
	
		static String OSDetector() {
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println(os);
			
			if (os.contains("win")) {
				return "Windows";
			} else if (os.contains("nux") || os.contains("nix")) {
				return "Linux";
			}else if (os.contains("mac")) {
				return "Mac";
			}else if (os.contains("|sunos")) {
				return "Solaris";
			}else {
				return "Other";
			}
			
		}
	
	
	public void intialization() {
		if(prop.getProperty("browser").contentEquals("chrome")&&OSDetector().contentEquals("Linux")) {
			File file = new File(System.getProperty("user.dir")+"/drivers/Chromedrivers/chromedriver");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			driver=new ChromeDriver();
			
		}else if(prop.getProperty("browser").contentEquals("chrome")&&OSDetector().contentEquals("Mac")) {
			File file = new File(System.getProperty("user.dir")+"/drivers/Chromedrivers/chromedriver");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			driver=new ChromeDriver();
			
		}else if(prop.getProperty("browser").contentEquals("chrome")&&OSDetector().contentEquals("Solaris")) {
			File file = new File(System.getProperty("user.dir")+"/drivers/Chromedrivers/chromedriver");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			driver=new ChromeDriver();
			
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
