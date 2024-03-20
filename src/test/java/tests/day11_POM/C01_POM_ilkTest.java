package tests.day11_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class C01_POM_ilkTest {

    @Test
    public void test01(){

        /*
           ilk iktiyacımız WebDriver
        daha önce driver'i parent edindiğimiz TestBase den alıyorduk
        POM'de driver olusturmak için extends ile parent edindiğimiz
        TestBase class ını kullanmak yerine;

        Farklı bir class da olup bize bir WebDriver objesi döndüren sıradan
        bir method haline getireceğiz.

         */

        Driver.getDriver().get("https://www.testotomasyonu.com");

        ReusableMethods.bekle(1);

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        //Yazı yollamak için

        aramaKutusu.sendKeys("shoes" + Keys.ENTER);

        ReusableMethods.bekle(2);

        Driver.closeDriver();

        Driver.getDriver().get("https://www.testotomasyonu.com");

        aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        ReusableMethods.bekle(2);

        Driver.closeDriver();


    }
}
