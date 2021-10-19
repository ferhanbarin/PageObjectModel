package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // 1- Properties objesi olusturacagiz.
    static Properties properties;


    // 2- Bu class'in amaci configuration.properties dosyasini okumak ve oradaki Key-Value ikililerini kullanarak istedigimiz Key'e ait Value'yi bize getirmek.
    static {
        String filePath = "configuration.properties";

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 3- Test class'larindan configReader class'ina ulasip yukaridaki islemleri yapmamizi saglayacak bir method olusturacagiz.
    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        return value;
    }
}
