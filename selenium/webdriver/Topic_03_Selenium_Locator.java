package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_03_Selenium_Locator {

    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    }

    @Test
     public void TC_01_FindElement(){
        //Single Element : Web Element
        WebElement loginButton = driver.findElement(By.className("button"));
        loginButton.click();

        //Multiple Element
        List<WebElement> buttons = driver.findElements(By.className("button"));
        buttons.get(0).click();

    }

    @Test
     public void TC_02_ID(){
        //Selenium Locator
        driver.findElement(By.id("send2")).click();

        //verify email error message xuat hien
         Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());
    }
    @Test
    public void TC_03_Class(){
        driver.navigate().refresh();
        driver.findElement(By.className("validate-password")).sendKeys("123");
    }
    @Test
    public void TC_04_Name(){
        driver.navigate().refresh();
        driver.findElement(By.name("send")).click();
        //verify email error message xuat hien
        Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());
    }
    @Test
    public void TC_05_TagName(){
        driver.navigate().refresh();
        //Hien thi tat ca duong link sau do getText ra
        List<WebElement> LoginPageLinks = driver.findElements(By.tagName("a"));
        for (WebElement webElement : LoginPageLinks ){
            System.out.println(webElement.getText());
        }
    }
    @Test
    public void TC_06_Link_Test(){
        driver.navigate().refresh();
        driver.findElement(By.linkText("Forgot Your Password?")).click();
        Assert.assertTrue(driver.findElement(By.id("email_address")).isDisplayed());
    }

    @Test
    public void TC_07_ParticalLinkTest(){
        driver.findElement(By.partialLinkText("Back to")).click();
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
    }

}
