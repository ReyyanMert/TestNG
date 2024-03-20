package tests.day09_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBase_BeforeClass;

public class C02_dependsOnMetods extends TestBase_BeforeClass {

    @Test(groups = {"smoke","e2e1","e2e2"})
    public void amazonTest() throws InterruptedException {
        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        //url'in amazon içerdiğini test edin ve screenshot alın
        String expectedUrlIcerik = "amazon";
        String actualUrlIcerik = driver.getCurrentUrl();
        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));



    }

    @Test(dependsOnMethods = "amazonTest",groups = {"smoke"})
    public void nutellaTest() throws InterruptedException {
        Thread.sleep(5000);
        //Nutella için arama yapın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@name='field-keywords']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        Thread.sleep(2000);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));


    }

    @Test(dependsOnMethods = "nutellaTest")
    public void ilkUrunTest() throws InterruptedException {

        // ilk urune tiklayin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        Thread.sleep(2000);
        // urun isminin Nutella icerdigini test edin ve urun isminin SS alin
        WebElement urunIsimElementi = driver.findElement(By.xpath("//h1[@id='title']"));
        Thread.sleep(2000);
        String expectedurunIcerik = "Nutella";
        String actualUrunIcerik = urunIsimElementi.getText();

        Assert.assertTrue(actualUrunIcerik.contains(expectedurunIcerik));


    }
}
