package tests.day13_TestNGReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluPozitifLoginTesti extends TestBaseRapor {


    @Test
    public void pozitifLoginTesti(){

        extentTest = extentReports.createTest("pozitif login testi","kullanıcının gecerli email ve password girebilmesi ");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanıcı testotomasyon anasayfaya gider");

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        extentTest.info("kullanacı account linkine basar");

        // 3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("gecerli email girer");

        // 4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("gecerli password girer");

        // 5- Sign in butonuna basarak login olun
        testOtomasyonuPage.signInFormuSubmitButonu.click();
        extentTest.info("sign in butonuna basar ve login olur");
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("kullanıcı basarılı bir sekilde giris yapabildiğini test eder");
        ReusableMethods.bekle(1);
        //7-sayfayı kapatın

        Driver.closeDriver();
    }
}