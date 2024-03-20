package tests.day10_TestNG;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_DataProvider extends TestBase {

    @DataProvider
    public static Object[][] kullaniciBilgileriProvider() {

        Faker faker = new Faker();//fake email ve password için

        String[][] kullaniciListesi = new String[10][2];

        for (int i = 0; i <kullaniciListesi.length ; i++) {

            kullaniciListesi[i][0] = faker.internet().emailAddress();
            kullaniciListesi[i][1] = faker.internet().password();

        }
        return kullaniciListesi;
    }

    @Test(dataProvider = "kullaniciBilgileriProvider")
    public void negetifLoginTesti(String email, String password){
        //qualitydemy anasayfaya gidin
        driver.get("https://www.qualitydemy.com");
        //cookieleri kabul et(genel olarak bastan sona herhangi bir
        //hata olmamasına ragmen test failed oluyor cookieleri kabul edersem
        //düzelir mi . deneme!!(evet işe yaradı hatırlatma cookie locater ile test passed oldu)

        driver.findElement(By.xpath("//*[@*='cookieAccept();']")).click();



        //login linkine basın
        driver.findElement(By.linkText("Log in")).click();

        //bir liste olarak verilen yanlış kullanıcı email ve passwordlerini deneyerek
        //sisteme giriş yapılamadığını test edin

        WebElement emailKutusu = driver.findElement(By.id("login-email"));
        emailKutusu.sendKeys(email);

        WebElement passwordKutusu = driver.findElement(By.id("login-password"));
        passwordKutusu.sendKeys(password);

        //login butonuna basalım

        driver.findElement(By.xpath("//button[text()='Login']")).click();

        //giriş yapılamadıgını test edelim
        //cooki için tekrar locater
        driver.findElement(By.xpath("//*[@*='cookieAccept();']"));
        //email kutusu için tekrar locater
        emailKutusu = driver.findElement(By.id("login-email"));

        Assert.assertTrue(emailKutusu.isDisplayed());






    }
}
