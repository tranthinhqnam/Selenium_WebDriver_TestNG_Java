package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Web_Browser_Command_II {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void TC_01_Url() {

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[text()='Đăng ký']")).click();
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink,"https://www.facebook.com/reg/");
    }
    @Test
    public void TC_02_Title() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[text()='Đăng ký']")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,"Đăng ký Facebook | Facebook");

    }

    @Test
    public void TC_03_Navigation() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[text()='Đăng ký']")).click();
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals(actualLink,"https://www.facebook.com/reg/");
        driver.navigate().back();
        String urlLoginPage = driver.getCurrentUrl();
        Assert.assertEquals(urlLoginPage,"https://www.facebook.com/");
        driver.navigate().forward();
        String actualTitleTc03 = driver.getTitle();
        Assert.assertEquals(actualTitleTc03,"Đăng ký Facebook | Facebook");

    }
    @Test
    public void TC_04_Page_Source(){

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[text()='Đăng ký']")).click();
        String registerPageSource = driver.getPageSource();
        Assert.assertTrue(registerPageSource.contains("Tạo tài khoản mới "));
        driver.findElement(By.id("//a[text()='Đăng nhập'")).click();
        String loginPageSource = driver.getPageSource();
        Assert.assertTrue(loginPageSource.contains("Đăng nhập Facebook"));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}