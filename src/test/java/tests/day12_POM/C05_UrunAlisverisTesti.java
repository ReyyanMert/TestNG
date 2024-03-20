package tests.day12_POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_UrunAlisverisTesti {

    @Test
    public void urunAlisverisTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();

        //3- gecerli kullanici adi ve sifre ile giris yapin
        testOtomasyonuPage.signInEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.signInPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        testOtomasyonuPage.signInFormuSubmitButonu.click();

        //4- electronics linkine tiklayin
        testOtomasyonuPage.electronicsLinki.click();

        //5- ilk urunu secip add to cart butonuna tiklayin
        //eger sayfada görünmüyprsa Action class ı ile obje olustur ve TAB tusunu kullan
        testOtomasyonuPage.ilkUrunElementi.click();

        //urunu daha sonraki adımlarda test edebilmek için kaydediyoruz
        String secilenUrunİsmi = testOtomasyonuPage.seciliUrunİsimElementi.getText();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                        .perform();
        ReusableMethods.bekle(1);
        testOtomasyonuPage.addToCardButonu.click();

        //6- your Cart linkini tiklayin
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(1);
        testOtomasyonuPage.yourCardLinki.click();

        //7- urunun sepete eklendigini test edin
        //7. adımda ürünün sepete eklendiğini test edebilmek için
        // bu adımda urun ismini kaydediyorum
        String sepettekiUrunİsmi = testOtomasyonuPage.sepettekiUrunİsimElementi.getText();

        Assert.assertTrue(secilenUrunİsmi.equalsIgnoreCase(sepettekiUrunİsmi));

        //8- checkout butonuna basin
        testOtomasyonuPage.checkoutButonu.click();
        ReusableMethods.bekle(1);

        //9- ilgili alanlari doldurup place order now butonuna basin
        //adfres yoksa adres ekleyin
        testOtomasyonuPage.adresEkleButonu.click();
        testOtomasyonuPage.adresEkleİsimKutusu.click();
        ReusableMethods.bekle(1);
        Faker faker = new Faker();
        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Turkey")
                .sendKeys(Keys.TAB)
                .sendKeys("Adana Province")
                .sendKeys(Keys.TAB)
                .sendKeys("Adana")
                .sendKeys(Keys.TAB)
                .sendKeys("01100")
                .sendKeys(Keys.TAB).perform();
        ReusableMethods.bekle(2);
        testOtomasyonuPage.adresEkleFormuSubmitButonu.click();

        // gereken checkbox'lari click yapin
        testOtomasyonuPage.billingAdressCheckBox.click();
        testOtomasyonuPage.deliveryAdressSameCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        testOtomasyonuPage.shippingMethodCheckBox.click();
        testOtomasyonuPage.acceptTermsCheckBox.click();
        testOtomasyonuPage.placeOrderNowButonu.click();



        //10- your order is successfully done yazisinin ciktigini test edin
        Assert.assertTrue(testOtomasyonuPage.alisverisBasariliYaziElementi.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
