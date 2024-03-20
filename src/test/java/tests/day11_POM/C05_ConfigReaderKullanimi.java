package tests.day11_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_ConfigReaderKullanimi {

    @Test
    public void test01(){

        //testotomasyonu.com anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //belirlenmiş aranacak kelime için  arama yapın

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        //arama işlemi sonucunda ürün görüntülendiğini test edin
        //bu test için bulunan urunleri bir listeye kaydettik (testotomasyonu page'e kaydedildi.Locate ler orda depolanıyor)
        //listenin bos olmadıgını test ediyoruz

        Assert.assertTrue(testOtomasyonuPage.bulunanUrunlerListesi.size()>0,"Aranan urun bulunamadı");

        //ve sayfayı kapatın


        ReusableMethods.bekle(2);
        Driver.closeDriver();

    }
}
