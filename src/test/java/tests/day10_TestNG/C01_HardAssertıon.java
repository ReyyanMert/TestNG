package tests.day10_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_HardAssertıon extends TestBase {
    @Test(groups = {"e2e1"})
    public void amazonTest(){
        /*
        testNG JUnit deki assertıon methodlarının tamamına sahiptir
        sadece sıralama JUNıtden farklıdır

        Assert classından methodlar kullanarak yaptığımız assertıon larda
        failed olan ilk assertıonda classın calışması durur kod hata verir

        siz o hatayı düzeltfikten sonta yeniden çalıştırırsanız sonraki hataları göürüsünüz
         */

        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //url in "https://www.amazon.com"amazon içerdiğini test edin
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        //nutella için arama yapın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='nav-input nav-progressive-attribute']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama sonuclarının nutella içerdiğini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedAramaIcerik ="Nutella";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedAramaIcerik));

        //ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //ilk urun ismini nutella içerdiğini test edin
        WebElement ilkUrunİsmi = driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIlkUrunIcerik = "Nutella";
        String actualIlkUrunIsmi = ilkUrunİsmi.getText();

        Assert.assertTrue(actualIlkUrunIsmi.contains(expectedIlkUrunIcerik));



    }


}
