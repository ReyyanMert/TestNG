package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QalitydemyPage {

    public QalitydemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[@class=\"btn btn-sign-in-simple\"]")
    public WebElement ilkLoginButonu;

    @FindBy(xpath = "//a[@onclick=\"cookieAccept();\"]")
    public WebElement cookiesKabulButonu;

    @FindBy(xpath = "//*[@name=\"email\"]")
    public WebElement emailKutusu;

    @FindBy(xpath = "//*[@name=\"password\"]")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(linkText = "My courses")
    public WebElement basariliGirisKontrolElementi;
}
