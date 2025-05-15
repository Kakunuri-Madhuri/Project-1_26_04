package com.medimention.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.medimention.PageObject.AccountPage;
import com.medimention.PageObject.FrontPage;
import com.medimention.PageObject.HomePage;
import com.medimention.PageObject.RegisterPage;
import com.medimention.Utilities.DataProviders;

public class TC_001_Register_DDT extends BaseClass
{
	@Test(dataProvider="RegData", dataProviderClass= DataProviders.class, groups="DataDriven")
	 public void account_Register(String B_Name,String U_Name,String U_email,String Pass,String C_pass)
	   {
		   FrontPage fp=new FrontPage(driver);
		   HomePage hp=new HomePage(driver);
		   RegisterPage rp=new RegisterPage(driver);
		   AccountPage ap=new AccountPage(driver);
		   
//		   Faker fake=new Faker();
		   
//		   String password=fake.internet().password();
//		   String busiName=fake.name().name();
//		   String UserName=fake.name().firstName();
//		   String UserEmail=fake.internet().emailAddress();
		   
//		   try
//		   {
		   fp.homebtn();
		   hp.registerbtn();
		   rp.selectGroup();
		   rp.BloodBank();
		   rp.BName(B_Name);
		   rp.setUser(U_Name);
		   rp.setEmail(U_email);
		   rp.setPass(Pass);
		   rp.setConfpass(C_pass);
		   rp.setterms();
		   rp.regButton();
		   
		   System.out.println(B_Name+"\t"+U_Name+"\t"+U_email+"\t"+Pass);
		   System.out.println(ap.AccHeading());
		   System.out.println(ap.NameText());
		   System.out.println(ap.AdminDropdown());
		   
		   Assert.assertTrue(ap.AccHeading().contains(B_Name));
		   Assert.assertEquals(ap.NameText(), B_Name);
		   Assert.assertTrue(ap.AdminDropdown().contains(U_Name));
		   
		   ap.logoutDrop();
		   ap.logout();
		   hp.MediHeading();
//		   }
//		   catch(Exception e)
//		   {
//			   driver.navigate().refresh();
//		   }
	   }

}
