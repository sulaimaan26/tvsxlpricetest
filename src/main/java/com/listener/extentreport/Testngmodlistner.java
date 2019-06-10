package com.listener.extentreport;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.navlabs.excel.reader.Excel_inputs;
import com.navlabs.excel.reader.Xls_Reader;
import com.testbase.HDFpricecheck.TestBase;

public class Testngmodlistner extends TestListenerAdapter{

	
	
	
	 @Override
	  public void onTestFailure(ITestResult tr) {
		 Xls_Reader reader=new Xls_Reader("/home/epage/eclipse-workspace/HDFpricecheck/src/main/java/com/testdata/Priceupdate.xlsx");
			reader.setCellData("price", "productonestatus",TestBase.rnum,"failed");
			System.out.println(TestBase.rnum);
	  
	 }
	 
	 @Override
	  public void onTestSuccess(ITestResult tr) {
		 Xls_Reader reader=new Xls_Reader("/home/epage/eclipse-workspace/HDFpricecheck/src/main/java/com/testdata/Priceupdate.xlsx");
			reader.setCellData("price", "productonestatus",TestBase.rnum,"passed");
			System.out.println(TestBase.rnum);
	  
	  }

	 
	
	 
	  
	 
	  


}
