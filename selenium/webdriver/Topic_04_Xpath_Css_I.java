package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Xpath_Css_I {

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
        driver.navigate().refresh();
        driver.findElement(By.id("email")).sendKeys("tranthinhqnam@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("1234567");
        //Click button
        driver.findElement(By.id("send2")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");

    }

    @Test
    public void TC_05_Create_New_Account() {

        //register

        driver.get("http://live.techpanda.org/index.php/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account'][normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Tran");
        driver.findElement(By.id("middlename")).sendKeys("Van");
        driver.findElement(By.id("lastname")).sendKeys("Thinh");
        driver.findElement(By.id("email_address")).sendKeys("t11111ranthinhqnam@gmail.com");
        driver.findElement(By.id("password")).sendKeys("030401T");
        driver.findElement(By.id("confirmation")).sendKeys("030401T");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.xpath("//button[@title='Register']")).click();
        //verify the name displays on dashboard
        WebElement element =driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'Tran Van Thinh')]"));
        String actualText = element.getText();
        Assert.assertEquals(actualText,"Tran Van Thinh\n" +
                "t11111ranthinhqnam@gmail.com\n" +
                "Change Password");
        driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
        driver.findElement(By.xpath("//a[@title='Log Out']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText(),"YOU ARE NOW LOGGED OUT");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
