package tests.day11_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QalitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_QalitydemyNegatifLoginTesti {

    //1- https://www.qualitydemy.com/ anasayfasina gidin
    //2- login linkine basin-
    //3 farkli test method’u olusturun.
    //	- gecerli username, gecersiz password
    //	- gecersiz username, gecerli password
    //	- gecersiz username, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void gecersizPasswordTesti(){

        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //2- login linkine basin-
        QalitydemyPage qalitydemyPage = new QalitydemyPage();
        qalitydemyPage.ilkLoginButonu.click();

        //cookies kabul
        qalitydemyPage.cookiesKabulButonu.click();

        ReusableMethods.bekle(1);


        //3 farkli test method’u olusturun.
        //	- gecerli username, gecersiz password
        qalitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));
        qalitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        ReusableMethods.bekle(1);

        //4- Login butonuna basarak login olun
        qalitydemyPage.loginButonu.click();

        ReusableMethods.bekle(1);

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(qalitydemyPage.emailKutusu.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();



    }

    @Test
    public void gecersizUsernameTesti(){

        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //2- login linkine basin-
        QalitydemyPage qalitydemyPage = new QalitydemyPage();
        qalitydemyPage.ilkLoginButonu.click();

        //cookies kabul
        qalitydemyPage.cookiesKabulButonu.click();

        ReusableMethods.bekle(1);


        //3 farkli test method’u olusturun.
        //	- gecersiz username, gecerli password
        qalitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizEmail"));
        qalitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        ReusableMethods.bekle(2);

        //4- Login butonuna basarak login olun
        qalitydemyPage.loginButonu.click();

        ReusableMethods.bekle(1);

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(qalitydemyPage.emailKutusu.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();



    }

    @Test
    public void gecersizUsernamevePasswordTesti(){

        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //2- login linkine basin-
        QalitydemyPage qalitydemyPage = new QalitydemyPage();
        qalitydemyPage.ilkLoginButonu.click();

        //cookies kabul
        qalitydemyPage.cookiesKabulButonu.click();

        ReusableMethods.bekle(1);


        //3 farkli test method’u olusturun.

        //	- gecersiz username, gecersiz password.
        qalitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizEmail"));
        qalitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        ReusableMethods.bekle(2);

        //4- Login butonuna basarak login olun
        qalitydemyPage.loginButonu.click();

        ReusableMethods.bekle(1);

        //5- Basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(qalitydemyPage.emailKutusu.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();



    }
}
