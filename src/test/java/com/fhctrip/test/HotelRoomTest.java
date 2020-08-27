package com.fhctrip.test;

import com.fhctrip.pages.FhcLoginPage;
import com.fhctrip.pages.HotelCreatePage;
import com.fhctrip.pages.HotelRoomCreatePage;
import com.fhctrip.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomTest extends TestBase {

    @Test
    public void createHotelRoom ()  {
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2Fadmin%2Fuseradmin");

        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
        HotelCreatePage hotelCreatePage = new HotelCreatePage(driver);
        HotelRoomCreatePage hotelRoomCreatePage = new HotelRoomCreatePage(driver);

        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager2!");

        //Login butonuna basin.
        fhcLoginPage.loginButton2.click();
        hotelCreatePage.hotelManagement.click();
        hotelRoomCreatePage.hotelRoom.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement addHotelRoom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='hidden-480']")));
        hotelRoomCreatePage.addHotelRoom.click();

        Select select = new Select(hotelRoomCreatePage.selectHotelButton);
        select.selectByVisibleText("Aksu");

        hotelRoomCreatePage.code.sendKeys("King");
        hotelRoomCreatePage.name.sendKeys("Aksu");
        hotelRoomCreatePage.loction.sendKeys("New Jersey");

        hotelRoomCreatePage.description.sendKeys("Doga manzarali");

        actions.dragAndDrop(hotelRoomCreatePage.kaynak,hotelRoomCreatePage.hedef).perform();

        select = new Select(hotelRoomCreatePage.roomType);
        select.selectByVisibleText("King");

        hotelRoomCreatePage.adultAmount.sendKeys("3");
        hotelRoomCreatePage.childrenAmount.sendKeys("2");
        hotelRoomCreatePage.isAvailable.click();

        //Save butonuna basin.
        hotelRoomCreatePage.submitButton.submit();

        //“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
        //explicit wait
        wait = new WebDriverWait(driver,20);
        boolean isTrue = wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);

        //OK butonuna tiklayin.
        hotelRoomCreatePage.okButton.click();
        actions.sendKeys(Keys.HOME).perform();




    }
}
