package com.testprice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.navlabs.excel.reader.Excel_inputs;
import com.pageselectors.PageElements;
import com.testbase.HDFpricecheck.TestBase;

public class TestPriceComfort extends TestBase {

	
	
	TestBase test;
	PageElements pageelements;
	public TestPriceComfort() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeTest
	public void browsersetup() {
		test=new TestBase();
		test.intialization();
		//System.out.println("Alert.......Started");
	}
	
	
	
	@Test(dataProvider="testdata")
	public void test001(String state,String price,int rownum) {
			
			pageelements=new PageElements();
			String exp=pageelements.getprice(state)+".0";
			String act=price;
			System.out.println(exp+act);
			rnum=rownum;
			Assert.assertEquals(act, exp);
			
		
		pageelements.getprice(state);
	}
	@DataProvider
	public Iterator<Object[]> testdata() {
		ArrayList<Object[]> testdata=Excel_inputs.getdatafrmexcel();
		return testdata.iterator();
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
		
	}

}
