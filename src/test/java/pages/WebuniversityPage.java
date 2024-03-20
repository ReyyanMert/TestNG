package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebuniversityPage {

    public WebuniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Our Products")
    public WebElement ourproductsLinki;

    @FindBy(id = "container-product1")
    public WebElement camerasElementi;

    @FindBy(id = "frame")
    public WebElement iFrameElementi;

    @FindBy(className = "modal-body")
    public WebElement popupElementi;

}
