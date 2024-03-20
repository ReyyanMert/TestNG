package tests.day12_POM;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegatifLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3 farkli test method’u olusturun.
    //	- gecerli username, gecersiz password
    //	- gecersiz username, gecerli password
    //	- gecersiz username, gecersiz password.
    //4- Sign in butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin




    @BeforeMethod
    public void setup(){

    }

    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //3 farkli test method’u olusturun.
        //	- gecerli username, gecersiz password
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //	- gecersiz username, gecerli password
        //	- gecersiz username, gecersiz password.
        //4- Sign in butonuna basarak login olmayi deneyin
        testOtomasyonuPage.signInFormuSubmitButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.signInPasswordKutusu.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();

    }

    @Test
    public void gecersizUsernameTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //3 farkli test method’u olusturun.
        //	- gecerli username, gecersiz password
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //	- gecersiz username, gecerli password
        //	- gecersiz username, gecersiz password.
        //4- Sign in butonuna basarak login olmayi deneyin
        testOtomasyonuPage.signInFormuSubmitButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.signInPasswordKutusu.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();

    }


    @Test
    public void gecersizUsernameGecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        //3 farkli test method’u olusturun.
        //	- gecerli username, gecersiz password
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //	- gecersiz username, gecerli password
        //	- gecersiz username, gecersiz password.
        //4- Sign in butonuna basarak login olmayi deneyin
        testOtomasyonuPage.signInFormuSubmitButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.signInPasswordKutusu.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();

    }
}
