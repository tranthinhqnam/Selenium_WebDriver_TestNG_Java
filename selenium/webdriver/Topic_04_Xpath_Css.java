package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_04_Xpath_Css {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    }
    @Test
    public void TC_01_Login_Empty_Email_And_Password() {

        //  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        //Nhap du lieu vao textbox
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.name("login[password]")).sendKeys("");
        //Click button
        driver.findElement(By.id("send2")).click();
        //Assert
        Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");

    }

    @Test
    public void TC_02_Login_Invalid_Email() {

        driver.findElement(By.id("email")).sendKeys("123@eqwew.333");
        driver.findElement(By.name("login[password]")).sendKeys("1234");
        //Click button
        driver.findElement(By.id("send2")).click();
        Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");


    }

    @Test
    public void TC_03_Login_Invalid_Password() {

        driver.findElement(By.id("email")).sendKeys("tranthinhqnam@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("1234");
        //Click button
        driver.findElement(By.id("send2")).click();
        Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void TC_04_Login_Incorrect_Email() {
        driver.findElement(By.id("email")).sendKeys("tranthinhqnam@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("1234567");
        //Click button
        driver.findElement(By.id("send2")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
