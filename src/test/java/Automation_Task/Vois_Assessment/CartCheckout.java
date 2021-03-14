package Automation_Task.Vois_Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartCheckout {
    public static final String PATH_TO_WEBDRIVER = "src/test/resources/webdriver/chromedriver.exe";
    WebDriver driver;


    @BeforeTest
    public void openUrl() {

        System.setProperty("webdriver.chrome.driver", PATH_TO_WEBDRIVER);


        driver = new ChromeDriver();


        driver.navigate().to("http://automationpractice.com/index.php");


    }

    @Test(priority = 1)
    public void addToCart() {

        WebElement category = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        category.click();

        //scroll into page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");


        //adding to cart now

        WebElement addtocartbtn = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]/div/div[2]/div[2]/a[1]"));
        addtocartbtn.submit();

        //xpath of addtocartbtn ://*[@id="center_column"]/ul/li[5]/div/div[2]/div[2]/a[1]


        //validate that item is added to cart

       // WebElement successaddtocart = driver.findElement(By.className("icon-ok"));
        //Assert.assertTrue(successaddtocart.getText().contains("Product successfully added to your shopping cart\r\n"
          //      + "				"));


        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("scrollBy(0,900)");


    }

    @Test(priority = 2)
    public void checkingOut() {
        WebElement checkoutbtn = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
        checkoutbtn.submit();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1000)");


        WebElement checkoutbtn1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
        checkoutbtn1.submit();

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("scrollBy(0,1000)");

        WebElement checkoutbtn2 = driver.findElement(By.name("processAddress"));
        checkoutbtn2.submit();


        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("scrollBy(0,1000)");


        //confirm on terms and conditions

        WebElement checktermsandconditions = driver.findElement(By.id("uniform-cgv"));
        checktermsandconditions.click();

        WebElement checkoutbtn3 = driver.findElement(By.name("processCarrier"));
        checkoutbtn3.submit();

        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("scrollBy(0,1000)");


        WebElement paymentmethode = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p"));
        paymentmethode.click();


        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("scrollBy(0,1000)");


        WebElement checkoutbtn4 = driver.findElement(By.className("button btn btn-default button-medium"));
        checkoutbtn4.submit();

        //validate that checkout is done


        //WebElement alertmsg = driver.findElement(By.className("alert alert-success"));
        //Assert.assertTrue(alertmsg.getText().contains("Your order on My Store is complete"));
    }

    @AfterTest
    public void close() {
        driver.quit();

    }

}
