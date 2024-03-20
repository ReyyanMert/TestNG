package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


        static Properties properties;//dosyaları daha rahat okumak için (configuration.properties)

        static {//statik blok(herseyden önce calısır)

            String dosyaYolu= "configuration.properties";
            try {

                FileInputStream fis= new FileInputStream(dosyaYolu);//dosyaya ulaşmak için
                properties= new Properties();//yukarda declare edilen properties'e yeni atama (obje olusturma+deger atama)
                properties.load(fis);//properties objesine file ınput sistemle gittiğimiz her seyi yükleme


            } catch (IOException e) {
                System.out.println("properties dosyasi okunamadi");

            }

        }

        public static String getProperty(String key){//https...url alıp return ediyor

            return properties.getProperty(key);

}


    }

