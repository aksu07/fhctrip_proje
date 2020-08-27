package com.fhctrip.test;


import com.fhctrip.pages.FhcLoginPage;
import com.fhctrip.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class FhcLoginTest extends TestBase {

    @Test
    public void pozitiveTestLogin(){
       driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2Fadmin%2Fuseradmin");

        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.loginButton2.click();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Admin - ListOfUsers"));

    }

    @Test
    public void NegativeTestLogin1(){ // gecersiz user name
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2Fadmin%2Fuseradmin");

        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
        fhcLoginPage.username.sendKeys("manage");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.loginButton2.click();
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains("Try again please"));

    }

    @Test
    public void NegativeTestLogin2(){ // gecersiz password
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2Fadmin%2Fuseradmin");

        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager");
        fhcLoginPage.loginButton2.click();
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains("Try again please"));

    }

    @Test
    public void NegativeTestLogin3(){ // gecersiz password and gecersiz user name
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2Fadmin%2Fuseradmin");

        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
        fhcLoginPage.username.sendKeys("maner2");
        fhcLoginPage.password.sendKeys("Man1ager");
        fhcLoginPage.loginButton2.click();
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains("Try again please"));

    }

}
