package com.fhctrip.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelCreatePage {
    WebDriver driver;

    public HotelCreatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(id = "Name")
    public WebElement name;
    @FindBy(id = "Address")
    public WebElement address;
    @FindBy(id = "Phone")
    public WebElement phone;
    @FindBy(id = "Email")
    public WebElement email;
    @FindBy(id = "IDGroup")
    public WebElement idgroup;
    @FindBy(id = "btnSubmit")
    public WebElement saveButton;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;
    @FindBy(className = "bootbox-body")
    public WebElement massage;
    @FindBy(className = "hidden-480")
    public WebElement addUser;
    @FindBy(xpath = "(//span[@class='title'])[3]")
    public WebElement hotelManagement;
    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelList;
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotel;







}
