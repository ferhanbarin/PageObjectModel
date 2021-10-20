package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {

    @Test
    public void test() {

        Driver.getDriver().get(ConfigReader.getProperty("AmazonURL"));
        Driver.getDriver().get(ConfigReader.getProperty("FacebookURL"));
        Driver.getDriver().get(ConfigReader.getProperty("CHURL"));

        // Driver driver = new Driver();
        // Driver class'indan obje üretilemesin istedigimiz icin Driver class'i SINGLETON yapiyoruz.
        // Bunun icin default constructor yerine parametresiz bir constructor olusturup access modifier'i private seciyoruz.

        // Driver driver = new Driver("Ferhan");
        // Driver class'inda parametreli bir constructor olmadigi icin kullanamayiz.

        Driver.closeDriver();
    }
}
