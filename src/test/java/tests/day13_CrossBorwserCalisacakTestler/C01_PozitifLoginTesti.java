package tests.day13_CrossBorwserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_PozitifLoginTesti extends TestBaseCross {

    @Test
    public void pozitifLoginTesti(){

        /*
        POM da ihtiyacımız olan locate leri Page sayfalarında
        hazırlıyorduk
        ama page sayfalarına bizim normal Driver classımız tanımlandıgından
        oradaki locateleri crossbrowser testlerde KULLANAMAYIZ

         */

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin

        driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();

        // 3- Kullanici email'i olarak gecerli email girin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 5- Sign in butonuna basarak login olun
        driver.findElement(By.xpath("//button[@id='submitlogin']")).click();

        // 6- Basarili olarak giris yapilabildigini test edin
        WebElement logoutButonu = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assert.assertTrue(logoutButonu.isDisplayed());




        ReusableMethods.bekle(3);
    }
}
