package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Find the signin link and click on it
        WebElement signinlink =  driver.findElement(By.linkText("Sign In"));
        signinlink.click();

        String expectedText = "Welcome Back!";
        //find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Not redirected to signin page",expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage() {
        //Find the signin link and click on it
        WebElement signinlink = driver.findElement(By.linkText("Sign In"));
        signinlink.click();

        //find the email field and type the email address to email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("heny123@gmail.com");

        //find the password field and type the password to  password field
        driver.findElement(By.name("user[password]")).sendKeys("heny123");

        //find the login btn element and click
        driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();

        String expectedErrorMessage = "Invalid username or password";
        //find the errormessage element and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='notice']")).getText();
        Assert.assertEquals("Invalid username or password", expectedErrorMessage,actualErrorMessage);


    }
    @After
    public void tearDown () {
        closeBrowser();

    }


}
