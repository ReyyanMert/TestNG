package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void tumSayfaFotografCek(WebDriver driver,String screenshotIsmi){

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        //dosya adını dinamik yapalım
        //target/screenShot/tumSayfaSS.png
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmm");
        localDateTime.format(istenenFormat);// 2310080829


        String dinamikDoyaAdi = "target/screenShot/"+screenshotIsmi+
                                localDateTime.format(istenenFormat)+".png";
        File tümSayfaSS = new File(dinamikDoyaAdi);
        File gecıcıDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(gecıcıDosya,tümSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        screenshot dosyası için hep aynı ismi kullanırsak tüm cekilen fotolar
        aynı isimler kayıt olacagından tek bir dosya olur son cekilelen foto eskilerin
        üzerine kayıt olur

        cektiğimiz fotoların hepsinin kalması ve istenilen isimde olmasın için
        dosya adını dinamik yapalım

        1 methodun cağrıldıgı yerde bir foto ismi yazılsın
        2 method da tarih etiketi ekleyelim
        ilkUrun2310080829
         */
    }

    public static void webElementScreenShotCek(WebElement istenenWebElement,String screenshotIsmi) throws IOException {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmm");
        localDateTime.format(istenenFormat);// 2310080829


        String dinamikDoyaAdi = "target/screenShot/"+screenshotIsmi+
                localDateTime.format(istenenFormat)+".png";
        File WebElementSS = new File(dinamikDoyaAdi);

        File geciciDosya = istenenWebElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,WebElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}
