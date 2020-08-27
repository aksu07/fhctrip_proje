package com.fhctrip.test;

import com.fhctrip.pages.FhcLoginPage;
import com.fhctrip.pages.HotelCreatePage;
import com.fhctrip.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelCreateTest extends TestBase {


    @Test
    public void createHotel() throws InterruptedException {
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2Fadmin%2Fuseradmin");

        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
        HotelCreatePage hotelCreatePage = new HotelCreatePage(driver);


        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        //Login butonuna basin.
        fhcLoginPage.loginButton2.click();
        hotelCreatePage.hotelManagement.click();
        hotelCreatePage.hotelList.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement addHotel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='hidden-480']")));

        hotelCreatePage.addHotel.click();

        //Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
        hotelCreatePage.code.sendKeys("BUTIK");
        hotelCreatePage.name.sendKeys("Aksu");
        hotelCreatePage.address.sendKeys("NewJersey");
        hotelCreatePage.phone.sendKeys("11111111111");
        hotelCreatePage.email.sendKeys("aksuhotel@gmail.com");
        WebElement idGrup = driver.findElement(By.id("IDGroup"));
        Select select = new Select(hotelCreatePage.idgroup);
        select.selectByIndex(2);

        //Save butonuna basin.
        hotelCreatePage.saveButton.submit();

        wait = new WebDriverWait(driver, 10);
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.className("bootbox-body"),"Hotel was inserted successfully"));
        Assert.assertTrue(isTrue);

        //OK butonuna tiklayin.
        hotelCreatePage.okButton.click();

        //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
        Assert.assertTrue(hotelCreatePage.massage.isEnabled());
    }
}
