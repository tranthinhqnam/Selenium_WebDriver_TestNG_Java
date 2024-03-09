package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_07_TextBox_TextArea {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exec");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    public void TC_01_Register() {
        driver.findElement(By.xpath("//a[text()='here']")).click();
        driver.findElement(By.name("emailid")).sendKeys();
        driver.findElement(By.name("btnLogin")).click();
        //String userID = driver.findElement(By.xpath(""));


    }

    @Test
    public void TC_02() {

    }

    @Test
    public void TC_03() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}