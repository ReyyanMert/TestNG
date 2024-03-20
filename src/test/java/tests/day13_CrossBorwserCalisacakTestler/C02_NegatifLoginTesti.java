package tests.day13_CrossBorwserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C02_NegatifLoginTesti extends TestBaseCross {

    @Test
    public void gecersizEmailTesti(){


        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin

        driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();

        // 3- Kullanici email'i olarak gecersiz email girin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        // 5- Sign in butonuna basarak login olun
        driver.findElement(By.xpath("//button[@id='submitlogin']")).click();

        //6-basarılı olarak giriş yapılamadıgını test edin
        Assert.assertTrue(emailKutusu.isDisplayed());

    }

    @Test
    public void gecersizPasswordTesti(){


        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin

        driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();

        // 3- Kullanici email'i olarak gecersiz email girin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        // 5- Sign in butonuna basarak login olun
        driver.findElement(By.xpath("//button[@id='submitlogin']")).click();

        //6-basarılı olarak giriş yapılamadıgını test edin
        Assert.assertTrue(emailKutusu.isDisplayed());//locati değiştir

    }


    @Test
    public void gecersizEmailGecersizPasswordTesti(){


        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin

        driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();

        // 3- Kullanici email'i olarak gecersiz email girin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        // 5- Sign in butonuna basarak login olun
        driver.findElement(By.xpath("//button[@id='submitlogin']")).click();

        //6-basarılı olarak giriş yapılamadıgını test edin
        Assert.assertTrue(emailKutusu.isDisplayed());

    }
}
