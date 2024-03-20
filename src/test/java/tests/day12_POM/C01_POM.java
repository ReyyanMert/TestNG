package tests.day12_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_POM {


    @Test
    public void test01(){

        //testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        ReusableMethods.bekle(1);
        //dress için arama yapın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("dress" + Keys.ENTER);

        ReusableMethods.bekle(1);
        //arama sonucunda ürün bulundugunu test edin
        int bulunanurunSayisi = testOtomasyonuPage.bulunanUrunlerListesi.size();

        Assert.assertTrue(bulunanurunSayisi > 0);

        ReusableMethods.bekle(2);
        //saydayı kapatın
        Driver.closeDriver();


    }
}
