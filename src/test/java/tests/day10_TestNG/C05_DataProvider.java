package tests.day10_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_DataProvider extends TestBase {

    /*
    Data provider bu notasyon ile işaretlenmiş ve bize
    2 katlı bir object[][] donen methoddur
     */

    @DataProvider
    public static Object[][] ListeYollayacakProvider() {

        String[][] aranacakUrunler = {{"Nutella"}, {"Java"}, {"Armut"}, {"elma"}, {"Erik"}, {"Malatya"}};

        return aranacakUrunler;
    }

    //String[] aranacakUrunler = {"Nutella", "Java", "Armut", "elma", "Erik", "Malatya"};
    //data provider kendisine verilen arraydeki elementleri
    //tek tek parametre olarak bizim test methodumuza yollar

    @Test(dataProvider = "ListeYollayacakProvider")
    public void testAramaTesti(String aranacakUrun){
        //amazona gidelim
        driver.get("https://www.amazon.com");
        //parametre olarak data providerin bize yolladıgı uürünü aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='nav-input nav-progressive-attribute']"));
        aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
        //urun için bulunan sonuc sayısını 1000 den fazla oldugunu test edelim
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramaSonucstr = aramaSonucElementi.getText();

        String[] aramaSonucKelimeleri = aramaSonucstr.split(" ");
        String aramasonucSayisiStr;
        if (aramaSonucKelimeleri[2].equals("over")) {
            aramasonucSayisiStr = aramaSonucKelimeleri[3];
        } else {
            aramasonucSayisiStr = aramaSonucKelimeleri[2];
        }//3,000 strin olarak arama sonuc sayısı

        aramasonucSayisiStr = aramasonucSayisiStr.replaceAll("\\D", "");//"3000"(string olarak)
        int aramaSonucSayisiInt = Integer.parseInt(aramasonucSayisiStr);//3000(int olarak)

        Assert.assertTrue(aramaSonucSayisiInt>1000);

    }
}
