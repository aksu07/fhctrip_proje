package com.fhctrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomCreatePage {
    WebDriver driver;

    public HotelRoomCreatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "IDHotel")
    public WebElement selectHotelButton;
    @FindBy(id = "Code")
    public WebElement code;
    @FindBy(id = "Name")
    public WebElement name;
    @FindBy(id = "Location")
    public WebElement loction;
    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement description;
    @FindBy(xpath = "//li[@data-id='500']")
    public WebElement kaynak;
    @FindBy(id = "Price")
    public WebElement hedef;

    @FindBy(id = "IDGroupRoomType")
    public WebElement roomType;

    @FindBy(id = "MaxAdultCount")
    public WebElement adultAmount;
    @FindBy(id = "MaxChildCount")
    public WebElement childrenAmount;
    @FindBy(id = "IsAvailable")
    public WebElement isAvailable;
    @FindBy(id = "btnSubmit")
    public WebElement submitButton;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[2]/a")
    public WebElement hotelRoom;
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoom ;


}
