package tests.day09_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_Priority extends TestBase {

    /*
    testNG de birden fazla test metodu çalısacaksa isim sırasına
    göre calışır

    eger priority ile sıralama yapılmıssa priority degeriküçükten
    büyüğe dofru çalısır eger aynı priority değerine sahip olan varsa
    isim sırasına göre çalışır eger priority değeri atanmamıssa
    defoult değer olan priority = 0 göre çalışır
     */

    @Test(priority = -23)
    public void amazonTest(){

        driver.get("https://www.amazon.com");
        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }


    @Test(groups = {"smoke","regression","e2e1"})
    public void youtubeTest(){
        driver.get("https://www.youtube.com");
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }

    @Test(groups = {"smoke"})
    public void facebookTest(){
        driver.get("https://www.facebook.com");
        String expectedUrlIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }
}
