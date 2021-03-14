package Automation_Task.Vois_Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Registration {
    public static final String PATH_TO_WEBDRIVER = "src/test/resources/webdriver/chromedriver.exe";
    WebDriver driver;

    //initiate driver and navigate to website


    @BeforeTest
    public void openUrl() {

        System.setProperty("webdriver.chrome.driver", PATH_TO_WEBDRIVER);


        driver = new ChromeDriver();


        driver.navigate().to("http://automationpractice.com/index.php");


    }


    @Test
    public void signUp() {
        WebElement SignInbtn = driver.findElement(By.className("login"));

        System.out.println(SignInbtn.getText()); //print "Sign in"

        SignInbtn.click();

        //WebElement header = driver.findElement(By.className("page-heading"));

        //Assert.assertTrue(header.getText().contains("Authentication"));

        //find text box to create account
        WebElement EmailElement = driver.findElement(By.id("email_create"));

        EmailElement.sendKeys("tnada463@gmail.com");


        WebElement Createbtn = driver.findElement(By.id("SubmitCreate"));
        Createbtn.submit();

        //validate that user is successfully redirected to sign up page

       // WebElement header1 = driver.findElement(By.className("page-heading"));

       //Assert.assertTrue(header1.getText().contains("Create an account"));


        WebElement CheckMR = driver.findElement(By.id("uniform-id_gender1"));
        CheckMR.click();


        WebElement CheckMRS = driver.findElement(By.id("uniform-id_gender2"));


        if (CheckMRS.isSelected()) {
            CheckMRS.click();

        }


        WebElement FUsername = driver.findElement(By.id("customer_firstname"));
        FUsername.clear();
        FUsername.sendKeys("nada");

        WebElement LUsername = driver.findElement(By.id("customer_lastname"));

        LUsername.clear();
        LUsername.sendKeys("nasr");


        WebElement Email = driver.findElement(By.id("email"));
        Email.clear();
        Email.sendKeys("tnada463@gmail.com");


        WebElement Password = driver.findElement(By.id("passwd"));
        Password.clear();
        Password.sendKeys("username@123");


        WebElement Fname = driver.findElement(By.id("firstname"));
        Assert.assertEquals(FUsername.getAttribute("value"), Fname.getAttribute("value"));


        WebElement Lname = driver.findElement(By.id("lastname"));
        Assert.assertEquals(LUsername.getAttribute("value"), Lname.getAttribute("value"));


        WebElement Address = driver.findElement(By.id("address1"));
        Address.sendKeys("thabit");


        WebElement City = driver.findElement(By.id("city"));
        City.sendKeys("Helwan");

        //working with drop down menu

        WebElement State = driver.findElement(By.id("id_state"));
        Select Selectstates = new Select(State);
        Assert.assertTrue(!Selectstates.isMultiple());


        Assert.assertEquals(50, Selectstates.getOptions().size());


        Selectstates.selectByVisibleText("Alabama");

        Assert.assertEquals("Alabama", Selectstates.getFirstSelectedOption().getText());


        WebElement ZipCode = driver.findElement(By.id("postcode"));
        ZipCode.sendKeys("17028");


        WebElement Country = driver.findElement(By.id("id_country"));

        Select Selectcountry = new Select(Country);
        Assert.assertTrue(!Selectcountry.isMultiple());


        Assert.assertEquals(2, Selectstates.getOptions().size());


        Selectstates.selectByVisibleText("United States");

        Assert.assertEquals("United States", Selectcountry.getFirstSelectedOption().getText());


        WebElement Phone = driver.findElement(By.id("phone_mobile"));
        Phone.sendKeys("01156283948");


        //WebElement Address2 = driver.findElement(By.id("alias"));
        //Address2.sendKeys("xyz");


        WebElement Registerbtn = driver.findElement(By.id("submitAccount"));

        Registerbtn.submit();


        //validate that user is signed up successfully


        //WebElement successsignup = driver.findElement(By.className("info-account"));

       // Assert.assertTrue(successsignup.getText().contains("Welcome to your account. Here you can manage all of your personal information and orders."));


    }


    @AfterTest
    public void close() {
        driver.quit();

    }
}
