package tests.day10_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_SoftAssertıon extends TestBase {

    @Test(groups = {"e2e2"})

    public void amazonTest(){
        /*
    TestNG bir method da birden fazla assertion olduğundT45
    tüm assertıonları tek seferde raporlama için SoftAssert clasından
    methodlar sunmustur

    SoftAssert ile assertıonları yapmak içim
    1- softassert objesi olustur
    2- istenilen tüm assertıonları yap
    3- tüm assertıonlar bittikten sonra sonucu raportlamamk için
    SoftAssert.assertAll() kullan

     */

        //amazon sayfasına gidin
        driver.get("https://www.amazon.com");
        //Url in "https://www.amazon.com/ oldugunu test edin
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"url test");

        //Nutella için arama yapın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='nav-input nav-progressive-attribute']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama sonuclarının Nutella içerdiğini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedAramaIcerik = "Nutella";
        String actualAramaSonucu = aramaSonucElementi.getText();

        softAssert.assertTrue(actualAramaSonucu.contains(expectedAramaIcerik),"nutella arama");

        //ilk ütrüne tıklayın
        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //ilk ürün isminin Nutella içerdiğini test edin
        WebElement ilkUrunİsmi = driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIlkUrunIcerik = "Nutella";
        String actualIlkUrunIsmi = ilkUrunİsmi.getText();

        softAssert.assertTrue(actualIlkUrunIsmi.contains(expectedIlkUrunIcerik),"ilk urun isim");

        softAssert.assertAll();
        System.out.println("failed olan assertıon olursa bu satır calışmaz");

        /*
        SoftAsert birden fazla aseertıon olsada calışmaya devam etmesi için kullanılır
        Biz assertall() kullanıncaya kadar buldugu hataları kendisi not eder calışmayı durdurmaz

        assertAll() satırına geldiğinde tüm assertıon sonuclarını rapor eder ve failed olan
        assertıon varsa assertAll() un calıştığında kodun calışması durur
        ve tüm failed olan assertıonlar raporlanır

        assertıonlardan sonra assertAll() yazılmassa failed olan assertıonlar olsada test passed olur

         */
    }

}
