package com.fhctrip.test;

import com.fhctrip.pages.FhcLoginPage;
import com.fhctrip.pages.HotelRoomRezervasyonPage;
import com.fhctrip.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomRezervasyonTest extends TestBase {

    @Test
    public void login() throws InterruptedException {
        driver.get("http://www.fhctrip.com/admin/RoomReservationAdmin/Create");
        FhcLoginPage fhcLoginPage = new FhcLoginPage(driver);
        fhcLoginPage.login2();// bu obje ile bu class'taki logine gittik.

        HotelRoomRezervasyonPage rezervasyonPage = new HotelRoomRezervasyonPage(driver);// bu class'taki locate'lere ulasiyoruz.

        Select idUserSl = new Select(rezervasyonPage.idUser);
        idUserSl.selectByIndex(1);

        Select idHotelRoomSl = new Select(rezervasyonPage.idHotelRoom);
        idHotelRoomSl.selectByIndex(7);

        rezervasyonPage.price.sendKeys("550");

        rezervasyonPage.dateStart.sendKeys("11/01/2021");

        rezervasyonPage.dateEnd.sendKeys("11/11/2020");

        rezervasyonPage.adultAmount.sendKeys("2");

        rezervasyonPage.childrenAmount.sendKeys("3");

        rezervasyonPage.surname.sendKeys("AKSU");

        rezervasyonPage.phone.sendKeys("12345678909");

        rezervasyonPage.email.sendKeys("ali@gmail.com");

        rezervasyonPage.notes.sendKeys("Doge Manzarali");

        rezervasyonPage.isApproved.click();

        rezervasyonPage.isPaid.click();

        rezervasyonPage.saveButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        Assert.assertTrue(wait.until(ExpectedConditions.textToBe(By.className("bootbox-body"),"RoomReservation was inserted successfully")));
        //Buradaki ilk degisikligimiz
    }
}
