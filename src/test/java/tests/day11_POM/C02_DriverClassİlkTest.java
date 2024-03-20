package tests.day11_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DriverClassİlkTest {

    @Test
    public void test01(){

        //testotomasyonu.com anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        //arama kutusuna phone yazıp aratın
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        //arama sonucunda gelen ürünlerden ilkine tıklayın
        Driver.getDriver()
                .findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]")).click();

        //ürün isim detayında phone geçtiğini test edin

        WebElement urunAciklamaElementi = Driver.getDriver().findElement(By.xpath("//div[@class=\"product-short-desc  my-2\"]"));

        String urunAciklamasi = urunAciklamaElementi.getText().toLowerCase();

        Assert.assertTrue(urunAciklamasi.contains("phone"));

        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
