package com.navlabs.excel.reader;

import java.util.ArrayList;

public class Excel_inputs {

	
	
	
	public static ArrayList<Object[]> getdatafrmexcel(){
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		Xls_Reader reader=new Xls_Reader("/home/epage/eclipse-workspace/HDFpricecheck/src/main/java/com/testdata/Priceupdate.xlsx");
		for(int i=2;i<=reader.getRowCount("price");i++) {
			String statename=reader.getCellData("price","state", i); //state name
			String productprice=reader.getCellData("price","productone", i); //product price
			//productprice=productprice.replaceAll("[.]","" );
			mydata.add(new Object[] {statename,productprice});
		}
		return mydata;
	}
	
	
	
}
