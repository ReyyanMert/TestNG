package tests.day13_TestNGReport;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluİlkTest extends TestBaseRapor {

    /*
        TestNG kendisi raporlama yapamaz
        AvenStack dependency kullanılarak rapor olusturabilir

        Bunun için
        1- Rapor istediğimiz classı testBaseRapor a extend etmeliyiz
        2- TestBaseRaporda bofpreTest bizim rapor olusturabilmemiz için
        ihtiyac duyduğumuz 3 objeyi olusuturp
        extendrapor ve extendReporter objelerine deger atar
        eksik kalan extendtest objesine her test methodunun basında biz atama yapmalıyız
        3- test içerisinde raporda cıkmasını istediğimiz tüm adımlar için
        extendTest objesi ile bilgi veya test sonucu yazdırın
     */

    @Test
    public void aramaTesti(){

        extentTest = extentReports.createTest("arama testi","kullanıcının aradıgı urun stokta olmalı");

        //testotomasyon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanıcı testotomasyon anasayfaya gider");

        //arama kutusuna phone yazıp aratın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        extentTest.info("arama kutusuna phone yazıp aratır");

        //arama sonucunda ürün bulunabildiğini test edin
        int sonucSayisi =testOtomasyonuPage.bulunanUrunlerListesi.size();
        Assert.assertTrue(sonucSayisi > 0);
        extentTest.pass("arama sonucunda ürün bulundugunu test eder");

        //ve sayfayı kapatın

        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
