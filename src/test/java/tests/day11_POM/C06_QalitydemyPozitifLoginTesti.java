package tests.day11_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QalitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_QalitydemyPozitifLoginTesti {

    @Test
    public void pozitifLogintesti(){

        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //2- login linkine basin
        QalitydemyPage qalitydemyPage = new QalitydemyPage();
        qalitydemyPage.ilkLoginButonu.click();

        //cookies kabul butonu
        qalitydemyPage.cookiesKabulButonu.click();

        ReusableMethods.bekle(1);

        // 3- Kullanici email'i olarak valid email girin
        qalitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));

        // 4- Kullanici sifresi olarak valid sifre girin
        qalitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        ReusableMethods.bekle(1);

        // 5- Login butonuna basarak login olun
        qalitydemyPage.loginButonu.click();

        // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(qalitydemyPage.basariliGirisKontrolElementi.isDisplayed());

        ReusableMethods.bekle(5);
        Driver.closeDriver();


    }
}
