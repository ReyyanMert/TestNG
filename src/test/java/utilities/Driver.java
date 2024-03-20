package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    driver classının sadece getDriver() ile kullanılmasını saglamak,
    bu class dan obje olusturulmasına engel olmak için
    POM dizanyın da Singleton Pattern kullanılır

    Singleton pattern bir classtan obje olusturulmasını engellemek için
    class içerinde istenen sartlara sahip constructor olusturup
    erişimi kapatmamıza dayanır
     */

    private Driver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");



        if (driver == null){
            switch (browser){
                case "safari" :
                    driver = new SafariDriver();
                    break;
                case "firefox" : new FirefoxDriver();
                break;
                case  "edge" : new EdgeDriver();
                break;
                default:
                    driver = new ChromeDriver();

            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        }

        //driver null degilse hiç bir sey yapma
        //var olan driver ile yoluna devam et


        return driver;
    }

    public static void closeDriver(){

      if(driver != null){
          driver.close();
          driver = null;
      }
    }
    public static void quitDriver(){

        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
