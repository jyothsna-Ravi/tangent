package com.tangent.tests;

import org.testng.annotations.Test;

import com.tangent.libraries.BaseTest;
import com.tangent.pages.LoginPage;

public class Actitime_Login_ST_01 extends BaseTest
{
@Test 
public void actitime_login_ST_01()
{
	BaseTest.verifyPageByTitle(driver, "actitime - Login", "Login");
	LoginPage l1=new LoginPage(driver);
	l1.setUn("admin");
	l1.setPw("manager");
	l1.clickLogin();
	BaseTest.verifyPageByTitle(driver,"actitime-Enter Time-Tract","Enter");
	
}
}
