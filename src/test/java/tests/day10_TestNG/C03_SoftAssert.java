package tests.day10_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_SoftAssert extends TestBase {

    @Test(groups = {"regression","e2e1"})
    public void test01(){

        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        // 3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        // 4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        // 6. sayfanın düzelmesi için geri tusuna basalım
        driver.navigate().back();

        // Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropdownMenu = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(dropdownMenu);
        select.selectByValue("EUR");

        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();

        String expectedSecim = "Eurozone (euro)";
        String actualSecim = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecim,expectedSecim,"manuden eurozone secimi yanlıs");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        //"Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
        //"Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
        //"Thailand (baht)"


        String[] expectedOptıonArr = {"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
                "Thailand (baht)"};
        List<String> expectedOptıonList = Arrays.asList(expectedOptıonArr);

        List<WebElement> tumOptıonElementleriList = select.getOptions();//actual beklentısı için (web elemntlerden olusan list)
        List<String> actualOptıonsList = new ArrayList<>();//stringlerden oluşan listeye kaydetme

        for (int i = 0; i < tumOptıonElementleriList.size(); i++) {

            actualOptıonsList.add(tumOptıonElementleriList.get(i).getText());//tüm opsına git/i.ci index elementi alıp yazıyı al/aldıgını actualoptıonliste ekle

        }
        softAssert.assertEquals(actualOptıonsList,expectedOptıonList);



        softAssert.assertAll();
    }
}
