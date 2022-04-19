package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class Test_Login extends BaseTest {

    @Before

    public void openUrl(){

        openBrowser_NopCommerce();
    }



    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        String logoutMessageDisplay = "Log out";

        WebElement loginLink = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginLink.click(); // finding login click element from nopcommerce website and clicking it

        WebElement emailId = driver.findElement(By.xpath("//input[@name='Email']"));
        emailId.sendKeys("geeta1234@gmail.com"); // entering username

        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        password.sendKeys("MyPassword123"); //finding element and enetering password

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();// first we find webelement with xpath in above line and then we used clicked method



        WebElement logoutbutton = driver.findElement(By.linkText("Log out"));
        System.out.println(logoutbutton.getText());

        String logoutexist = logoutbutton.getText();

        Assert.assertEquals(logoutMessageDisplay,logoutexist);
    }

    @After

    public void closeBrowser1(){

        endProcedure();// calling parent method in child class to quit browser.
    }

}
