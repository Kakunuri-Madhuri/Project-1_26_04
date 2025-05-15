package com.medimention.testCases;

import org.testng.annotations.Test;

import com.medimention.PageObject.*;

public class TC_001_Registration extends BaseClass
{
	@Test
   public void account_Register()
   {
	   FrontPage fp=new FrontPage(driver);
	   HomePage hp=new HomePage(driver);
	   RegisterPage rp=new RegisterPage(driver);
	   
	   String password=randomStr()+randomNum();
	   String busiName=randomStr();
	   String UserName=randomStr()+randomNum();
	   String UserEmail=randomStr()+"@xyz.com";
	   
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
   }
}
