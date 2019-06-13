package com.navlabs.excel.reader;

import java.util.ArrayList;

public class Excel_inputs {

	public static int i;
	
	//
	public static ArrayList<Object[]> getdatafrmexcel(){
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		Xls_Reader reader=new Xls_Reader(System.getProperty("user.dir")+"/src/main/java/com/testdata/Priceupdate.xlsx");
		for(i=2;i<=reader.getRowCount("price");i++) {
			String statename=reader.getCellData("price","State", i); //state name
			String productprice=reader.getCellData("price","productone", i); //product price
			//productprice=productprice.replaceAll("[.]","" );
			mydata.add(new Object[] {statename,productprice,i});
		}
		return mydata;
	}
	
	
	
}
