package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    @Before
    public void openBrowser2(){ // public no return type method created

        openBrowser_NopCommerce();   // calling parent class public method into child class


    }

    /*1. userShouldNavigateToComputerPageSuccessfully
     * click on the ‘Computers’ Tab
     * Verify the text ‘Computers
     */

    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        String expectedMessage = "Computers";

        WebElement computerOption = driver.findElement(By.xpath("//a[@href='/computers']"));

        System.out.println(computerOption.getText());

        computerOption.click();

        WebElement diplayMessage = driver.findElement(By.xpath("//h1[text()='Computers']"));
        System.out.println(diplayMessage.getText());

        String actualMessage = diplayMessage.getText(); // saving actual message received from above web-element
        Assert.assertEquals(expectedMessage,actualMessage);

        // 2. when user click on Electronics tab - it should navigate to that page
        // checking whether that page have message displayed - 'Electronics'

        WebElement electronicsoption = driver.findElement(By.xpath("//a[@href='/electronics']"));

        electronicsoption.click(); // clicking on Electronics tab

        String expectedElectronicsMessage ="Electronics"; // saving expected message
        WebElement displayElectronicsMessage = driver.findElement(By.xpath("//h1[normalize-space()='Electronics']"));
        String actualElectronicMessage = displayElectronicsMessage.getText();

        Assert.assertEquals(expectedElectronicsMessage,actualElectronicMessage);

        //3. when user click on Apparel tab - it should navigate to that page
        // checking whether that page have message displayed - 'Apparel'
        String expectedApparelMessage = "Apparel";

        WebElement apparel = driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Apparel']"));

        apparel.click();

        WebElement apprelMessageElement = driver.findElement(By.xpath("//h1[normalize-space()='Apparel']"));
        String actualAppearMessage = apprelMessageElement.getText();

        Assert.assertEquals(expectedApparelMessage,actualAppearMessage);

        //4. when user click on Digital downloads tab - it should navigate to that page
        // checking whether that page have message displayed - 'Digital downloads'

        String expectedDigitalMessage = "Digital downloads";

        WebElement digitalOption = driver.findElement(By.xpath("//a[@href='/digital-downloads']"));
        digitalOption.click();

        WebElement DigitalElement = driver.findElement(By.xpath("//h1[normalize-space()='Digital downloads']"));

        String actualDigitalMessage = DigitalElement.getText();
        Assert.assertEquals(expectedDigitalMessage,actualDigitalMessage);

        //5. when user click on Books tab - it should navigate to that page
        // checking whether that page have message displayed - 'Books'

        String expectedBooksMessage ="Books";

        WebElement booksOption = driver.findElement(By.xpath("//a[@href='/books']"));
        booksOption.click();

        WebElement actualBooksElement = driver.findElement(By.xpath("//h1[normalize-space()='Books']"));
        String actualBooksMessage = actualBooksElement.getText();

        Assert.assertEquals(expectedBooksMessage,actualBooksMessage);


        //6. when user click on  Jewelry tab - it should navigate to that page
        // checking whether that page have message displayed - 'Jewelry'

        WebElement jewelryOption = driver.findElement(By.xpath("//a[@href='/jewelry']"));
        jewelryOption.click();

        String expectedJewelryMessage = "Jewelry";
        WebElement actualJewelryElement = driver.findElement(By.xpath("//h1[normalize-space()='Jewelry']"));
        String actualJewelryMessage = actualJewelryElement.getText();
        Assert.assertEquals(expectedJewelryMessage,actualJewelryMessage);



        //7. when user click on Gift Cards tab - it should navigate to that page
        // checking whether that page have message displayed - 'Gift Cards’

        WebElement giftCardsOption = driver.findElement(By.xpath("//a[@href='/gift-cards']"));
        giftCardsOption.click();
        String expectedGiftCardMessage ="Gift Cards";

        WebElement actualGiftCardsElement = driver.findElement(By.xpath("//h1[normalize-space()='Gift Cards']"));
        String actualGiftMessage = actualGiftCardsElement.getText();
        Assert.assertEquals(expectedGiftCardMessage,actualGiftMessage);



    }


    @After // after the test case finished this below mehtod will be executed

    public void closeBrowser1(){

        endProcedure();// calling parent method in child class to quit browser.
    }


}
