package Automation_Task.Vois_Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
    public static final String PATH_TO_WEBDRIVER = "src/test/resources/webdriver/chromedriver_linux";
    WebDriver driver;

    //initiate driver and navigate to website


    @BeforeTest
    public void openUrl() {

        System.setProperty("webdriver.chrome.driver", PATH_TO_WEBDRIVER);


        driver = new ChromeDriver();


        driver.navigate().to("http://automationpractice.com/index.php");


    }


    @Test
    public void LogIn() {
        driver.findElement(By.className("login")).click();

        WebElement Email = driver.findElement(By.id("email"));

        Email.sendKeys("nada7528@gmail.com");


        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("nada@123");

        WebElement signinbtn = driver.findElement(By.id("SubmitLogin"));

        signinbtn.submit();


        //check user logged successfully

        WebElement successlogin = driver.findElement(By.className("header_user_info"));
        Assert.assertTrue(successlogin.getText().contains("nada tarek"));


    }


    @AfterTest
    public void close() {
        driver.quit();

    }
}
