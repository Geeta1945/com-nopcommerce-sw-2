package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    @Before
    public void openMyUrl(){

        openBrowser_NopCommerce();
    }


    @Test



    public void userShouldNavigateToRegisterPageSuccessfully(){

        WebElement registerPage = driver.findElement(By.className("ico-register"));
        registerPage.click();

        String expectedRegisterMessage = "Register";
        WebElement registerMessageElement = driver.findElement(By.xpath("//h1[text()='Register']"));

        String actualRegisterMessage = registerMessageElement.getText();
        Assert.assertEquals(expectedRegisterMessage,actualRegisterMessage);

    }

    @Test

    public void userShouldRegisterAccountSuccessfully(){

        WebElement registerPage = driver.findElement(By.className("ico-register"));
        registerPage.click();

        WebElement genderFemale = driver.findElement(By.xpath("//input[@id='gender-female']"));
        genderFemale.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Sofia");

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Yunus");

        WebElement dateOfBirth = driver.findElement(By.xpath("//select[@name ='DateOfBirthDay']"));
        dateOfBirth.sendKeys("12");

        WebElement dateOfMonth = driver.findElement(By.xpath("//select[@name ='DateOfBirthMonth']"));
        dateOfMonth.sendKeys("January");
        WebElement dateOfYear = driver.findElement(By.xpath("//select[@name ='DateOfBirthYear']"));
        dateOfYear.sendKeys("2000");

        WebElement emailAddress = driver.findElement(By.xpath("//input[@type='email']"));
        emailAddress.sendKeys("geeta12@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("MyPassword123");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("MyPassword123");



        WebElement registerButton = driver.findElement(By.xpath("//button[@name='register-button']"));
        registerButton.click();
        String expectedMessage3 = "Your registration completed";

        WebElement registerElement = driver.findElement(By.xpath("//div[@class='result']"));

       String actualMessage3 =  registerElement.getText();
        System.out.println(actualMessage3);

        Assert.assertEquals(expectedMessage3,actualMessage3);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After

    public void closeBrowser1(){

        //endProcedure();// calling parent method in child class to quit browser.
    }
}
