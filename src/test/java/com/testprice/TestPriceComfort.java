package com.testprice;

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
	
	@DataProvider
	public Iterator<Object[]> testdata() {
		ArrayList<Object[]> testdata=Excel_inputs.getdatafrmexcel();
		return testdata.iterator();
	}
	
	@Test(dataProvider="testdata")
	public void test001(String state,String price) {
		pageelements=new PageElements();
		//pageelements.getprice(state);
		String exp=pageelements.getprice(state)+".0";
		String act=price;
		System.out.println(exp+act);
		Assert.assertEquals(act, exp);
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
		//System.out.println("Alert.......Eneded");
	}

}