package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Run_On_Browser {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        //Open Firefox driver
        driver = new FirefoxDriver();

        //Set timeouts to find elements
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // Open application (AUT/SUT): Application Under Testing, System Under Testing
        driver.get("https://phptravels.net/signup");
    }
    @Test
    public void TC_01(){
        //single element
        driver.findElement(By.id("firstname")).sendKeys("Tran");
        driver.findElement(By.id("last_name")).sendKeys("Thinh");
        driver.findElement(By.xpath("//button[@title='Select Country']")).click();
        driver.findElement(By.cssSelector("a[id='bs-select-1-232'] span[class='text']")).click();
        driver.findElement(By.id("phone")).sendKeys("0919140625");
        driver.findElement(By.id("user_email")).sendKeys("tranthinhqnam@gmail.com");
        driver.findElement(By.id("password")).sendKeys("vanthinh123");

        WebElement iFrame = driver.findElement(By.xpath("//div[@class='g-recaptcha']"));
        driver.switchTo().frame(iFrame);
        WebElement iFrame_checkbox = driver.findElement(By.className("recaptcha-checkbox-checkmark"));
        iFrame_checkbox.click();

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}