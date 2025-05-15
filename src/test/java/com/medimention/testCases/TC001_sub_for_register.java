package com.medimention.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.medimention.PageObject.*;

public class TC001_sub_for_register extends BaseClass
{
	@Test(groups="Regression")
	   public void account_Register()
	   {
		   FrontPage fp=new FrontPage(driver);
		   HomePage hp=new HomePage(driver);
		   RegisterPage rp=new RegisterPage(driver);
		   AccountPage ap=new AccountPage(driver);
		   Faker fake=new Faker();
		   
		   String password=fake.internet().password();
		   String busiName=fake.name().name();
		   String UserName=fake.name().firstName();
		   String UserEmail=fake.internet().emailAddress();
		   
		   fp.homebtn();
		   hp.registerbtn();
		   rp.selectGroup();
		   rp.BloodBank();
		   rp.BName(busiName);
		   rp.setUser(UserName);
		   rp.setEmail(UserEmail);
		   rp.setPass(password);
		   rp.setConfpass(password);
		   rp.setterms();
		   rp.regButton();
		   
		   System.out.println(busiName+"\t"+UserName+"\t"+UserEmail+"\t"+password);
		   System.out.println(ap.AccHeading());
		   System.out.println(ap.NameText());
		   System.out.println(ap.AdminDropdown());
		   
		   Assert.assertTrue(ap.AccHeading().contains(busiName));
		   Assert.assertEquals(ap.NameText(), busiName);
		   Assert.assertTrue(ap.AdminDropdown().contains(UserName));
	   }
}
