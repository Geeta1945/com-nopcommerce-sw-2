package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// loading url and maximize webpage window
public class BaseTest {
    public static WebDriver driver; // public static webdriver variable created so it can be accessed globaly
    public void openBrowser_NopCommerce(){

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");

        String baseUrl_Nopcommerce = "https://demo.nopcommerce.com/";
        driver = new ChromeDriver();// creating chrome driver object
        driver.get(baseUrl_Nopcommerce); // opening Url
        driver.manage().window().maximize();// maximize window once opened url

    }


    public void endProcedure(){

        driver.quit();

    }

}
