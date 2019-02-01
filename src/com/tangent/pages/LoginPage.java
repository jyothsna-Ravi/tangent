package com.tangent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	
@FindBy(id="username")
private WebElement unTB;

@FindBy(name="pwd")
private WebElement pwTB;

@FindBy(xpath="//div[.='Login ']")
private WebElement loginBtn;

public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void setUn(String un)
{
	unTB.sendKeys(un);
}
public void setPw(String pw)
{
	pwTB.sendKeys(pw);
}
public void clickLogin()
{
	loginBtn.click();
}

}

