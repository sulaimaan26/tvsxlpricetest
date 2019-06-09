package com.pageselectors;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testbase.HDFpricecheck.TestBase;

public class PageElements extends TestBase {
	
	@FindBy(xpath="//select[@name=\"ddlState\"]")    //STATE Dropdown Element
	WebElement selectstate;
	
	@FindBy(xpath="//select[@name=\"ddlCity\"]")    //STATE Dropdown Element
	WebElement selecttown;
	
	/*@FindBy(xpath="//img[@alt=\"TVS XL100 Comfort logo\"]")  //Producttype
	WebElement tvscomfort;*/
	
	@FindBy(xpath="//span[@id=\"spxlcomfort\"]")
	WebElement xlcomfortproductprice;
	
	@FindBy(xpath="//span[@id=\"spxlcomfort\"]")
	WebElement previousbutton;
	
	public PageElements() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	String alterstate(String inputstate) {
		inputstate =inputstate.replace(" " , "");
		inputstate=inputstate.toLowerCase();
		String temp=new String();
		if(inputstate==("andaman")){temp="Andaman Nicobar";}
		else if(inputstate==("andhrapradesh")){temp="Andhra Pradesh";}
		else if(inputstate==("northeast - Arunachal Pradesh")){temp="Arunachal Pradesh";}
		else if(inputstate==("assam")){temp="Assam";}
		else if(inputstate==("bihar")){temp="Bihar";}
		else if(inputstate==("chandigarh")){temp="Chandigarh";}
		else if(inputstate==("chattisgarh")){temp="Chattisgarh";}
		else if(inputstate==("")){temp="Dadar & Nagar Haveli";}
		else if(inputstate==("goa")){temp="Goa";}
		else if(inputstate==("gujarat")){temp="Gujarat";}
		else if(inputstate==("haryana")){temp="Haryana";}
		else if(inputstate==("himachalpradesh")){temp="Himachal Pradesh";}
		else if(inputstate==("jammu & Kashmir")){temp="Jammu & Kashmir";}
		else if(inputstate==("jarkhand")){temp="Jharkhand";}
		else if(inputstate==("karnataka")){temp="Karnataka";}
		else if(inputstate==("kerala")){temp="Kerala";}
		else if(inputstate==("madhyapradesh")){temp="Madhya Pradesh";}
		else if(inputstate==("maharashtra")){temp="Maharashtra";}
		else if(inputstate==("northeast - Manipur")){temp="Manipur";}
		//else if(inputstate==("silvasa")){temp="Meghalaya";}
		else if(inputstate==("northeast - Mizoram")){temp="Mizoram";}
		else if(inputstate==("northeast - Nagaland")){temp="Nagaland";}
		else if(inputstate==("orissa")){temp="Odisha";}
		else if(inputstate==("pondicherry")){temp="Pondicherry";}
		else if(inputstate==("punjab")){temp="Punjab";}
		else if(inputstate==("rajasthan")){temp="Rajasthan";}
		else if(inputstate==("tamilnadu")){temp="Tamil Nadu";}
		else if(inputstate==("telangana")){temp="Telangana";}
		else if(inputstate==("northeast -Tripura")){temp="Tripura";}
		else if(inputstate==("uttarpradesh")){temp="Uttar Pradesh";}
		else if(inputstate==("uttarkhand")){temp="Uttarakhand";}
		else if(inputstate==("westBengal")){temp="West Bengal";};
		return temp;
			
	}
	
	
	
	public String getprice(String inputstate) {
		String price=new String();
		try{
			Select state=new Select(selectstate);
			state.selectByVisibleText(inputstate);
			System.out.println("selectedstate----------->"+inputstate);
			price=xlcomfortproductprice.getText().replaceAll("[^0-9]", "");
			System.out.print("and extraceedprice----------->"+price);
		}catch(NoSuchElementException exception) {
			System.out.println("oops!!!!!State not found");
		}
		return price;
		
	}
	
	public String getproductprice() {
		return(xlcomfortproductprice.getText().replaceAll("[^0-9]", ""));
	}
	
	public void goprevious() {
		previousbutton.click();
	}

}
