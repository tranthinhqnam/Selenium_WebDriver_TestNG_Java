package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Xpath_Css_II {

    String nametext, emailAdress, passtext, phonetext;
    WebDriver driver;
    //Action
    By name = By.id("txtFirstname");
    By email = By.id("txtEmail");
    By confirmEmail = By.id("txtCEmail");
    By password = By.id("txtPassword");
    By confirmPass = By.id("txtCPassword");
    By phone = By.id("txtPhone");
    By registerButton = By.xpath("//form[@id='frmLogin']//button");

    //Error Mesage
    By nameErrorMsg = By.id("txtFirstname-error");
    By emailErrorMsg = By.id("txtEmail-error");
    By emailConfirmErrorMsg = By.id("txtCEmail-error");
    By passErrorMsg = By.id("txtPassword-error");
    By passConfirmMsg = By.id("txtCPassword-error");
    By phoneErrorMsg = By.id("txtPhone-error");


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        nametext = " Pool";
        emailAdress = "tranthinhquangnam@gmail.net";
        passtext = "1234567";
        phonetext = "0903912978";


    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }


    @Test
    public void TC_01_Empty_Data() {
        driver.findElement(registerButton).click();
        Assert.assertEquals(driver.findElement(nameErrorMsg).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(emailErrorMsg).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(emailConfirmErrorMsg).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(passErrorMsg).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(passConfirmMsg).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(phoneErrorMsg).getText(), "Vui lòng nhập số điện thoại.");


    }

    @Test
    public void TC_02_Invalid_Email() {
//123@123.12@
        driver.findElement(name).sendKeys(nametext);
        driver.findElement(email).sendKeys("123@123.12@");
        driver.findElement(confirmEmail).sendKeys("123@123.12@");
        driver.findElement(password).sendKeys(passtext);
        driver.findElement(confirmPass).sendKeys(passtext);
        driver.findElement(phone).sendKeys(phonetext);
        Assert.assertEquals(driver.findElement(emailErrorMsg).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(emailConfirmErrorMsg).getText(), "Email nhập lại không đúng");

    }

    @Test
    public void TC_03_Incorrect_Confirm_Email() {
        driver.findElement(name).sendKeys(nametext);
        driver.findElement(email).sendKeys(emailAdress);
        driver.findElement(confirmEmail).sendKeys("tranthinhquangnam@gmail.net.vn");
        driver.findElement(password).sendKeys(passtext);
        driver.findElement(confirmPass).sendKeys(passtext);
        driver.findElement(phone).sendKeys(phonetext);
        Assert.assertEquals(driver.findElement(emailConfirmErrorMsg).getText(), "Email nhập lại không đúng");

    }

    @Test
    public void TC_04_Password_Less_Than_6_Chars() {

        driver.findElement(name).sendKeys(nametext);
        driver.findElement(email).sendKeys(emailAdress);
        driver.findElement(confirmEmail).sendKeys(emailAdress);
        driver.findElement(password).sendKeys("123");
        driver.findElement(confirmPass).sendKeys("123");
        driver.findElement(phone).sendKeys(phonetext);
        Assert.assertEquals(driver.findElement(passErrorMsg).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(passConfirmMsg).getText(), "Mật khẩu phải có ít nhất 6 ký tự");

    }

    @Test
    public void TC_05_Incorrect_Confirm_Password() {

        driver.findElement(name).sendKeys(nametext);
        driver.findElement(email).sendKeys(emailAdress);
        driver.findElement(confirmEmail).sendKeys(emailAdress);
        driver.findElement(password).sendKeys(passtext);
        driver.findElement(confirmPass).sendKeys("12345644");
        driver.findElement(phone).sendKeys(phonetext);
        Assert.assertEquals(driver.findElement(passConfirmMsg).getText(), "Mật khẩu bạn nhập không khớp");

    }

    @Test
    public void TC_06_Incorrect_Phone_Number() {

        //0987823724534
        //Số điện thoại phải từ 10-11 số.

        driver.findElement(name).sendKeys(nametext);
        driver.findElement(email).sendKeys(emailAdress);
        driver.findElement(confirmEmail).sendKeys(emailAdress);
        driver.findElement(password).sendKeys(passtext);
        driver.findElement(confirmPass).sendKeys(passtext);
        driver.findElement(phone).sendKeys("0991");
        driver.findElement(registerButton).click();
        Assert.assertEquals(driver.findElement(phoneErrorMsg).getText(),"Số điện thoại phải từ 10-11 số.");

        //098782372
        //Số điện thoại phải từ 10-11 số.
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys("1234");
        driver.findElement(registerButton).click();
        Assert.assertEquals(driver.findElement(phoneErrorMsg).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys("qeweda");
        driver.findElement(registerButton).click();
        Assert.assertEquals(driver.findElement(phoneErrorMsg).getText(),"Vui lòng nhập con số");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
