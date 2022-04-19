package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class LoginTest  extends BaseTest { // inheritance created to access method of parent class - BaseTest

    @Before // @Before annotation in JUnit is used on a method containing java code to run before each est case

    public void openBrowser(){ // public no return type method created

        openBrowser_NopCommerce();   // calling parent class public method into child class


    }

    /*1. userShouldNavigateToLoginPageSuccessfully
     * click on the ‘Login’ link
     * Verify the text ‘Welcome, Please Sign In!’
     */
    @Test // this annotation is used to write code under test

    public void loginTest(){

        String expectedWelcomeMessage = "Welcome, Please Sign In!";

        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals("Not navigated to login page",expectedWelcomeMessage,actualMessage);

    }

    /*2. userShouldLoginSuccessfullyWithValidCredentials
    * click on the ‘Login’ link * Enter valid username
    * Enter valid password * Click on ‘LOGIN’ button
    * Verify the ‘Log out’ text is display
    */

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

    /*
    3. verifyTheErrorMessage * click on the ‘Login’ link
    * Enter invalid username * Enter invalid password
    * Click on Login button * Verify the error message ‘Login was unsuccessful.
    Please correct the errors and try again. No customer account found’
     */

    @Test
    public void verifyTheErrorMessage(){
//Login was unsuccessful. Please correct the errors and try again.
        String expectedErrorMessage ="Login was unsuccessful. Please correct the errors and try again.\n" +"No customer account found";

        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click(); // finding login click element from nopcommerce website and clicking it

        WebElement emailId = driver.findElement(By.xpath("//input[@name='Email']"));
        emailId.sendKeys("geeta1945p@gmail.com"); // entering username

        WebElement password = driver.findElement(By.xpath("//input[@class='password']"));
        password.sendKeys("Geeta20"); //finding element and enetering password

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();// first we find webelement with xpath in above line and then we used clicked method

        WebElement actualErrorMessageElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));

        System.out.println(actualErrorMessageElement.getText()+"   Second TEstCase Message");

        String actualErrorMessage = actualErrorMessageElement.getText();

      Assert.assertEquals(expectedErrorMessage,actualErrorMessage);

         }

    @After // after the test case finished this below mehtod will be executed

    public void closeBrowser(){

        endProcedure();// calling parent method in child class to quit browser.
    }


}
