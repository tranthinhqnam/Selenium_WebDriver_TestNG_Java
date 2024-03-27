package webdriver;

import graphql.language.Selection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_08_Template_Default_Dropdown_List {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    Action action;
    Select select;
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

        driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_NopCommerce() {

        driver.get("https://demo.nopcommerce.com/");
        String firstName ="Tran";
        String lastName ="Thinh";
        String Email ="autofc" + getRandomNumber() +"@gmail.net";
        String companyName ="DevSamurai";
        String day ="3";
        String month ="April";
        String year ="2001";
        String company ="DevSamurai";
        String password = "123456";

        By genderMaleBy = By.id("gender-male");
        By firstNameBy = By.id("FirstName");
        By lastNameBy = By.id("LastName");
        By dateDropdownMoth = By.name("DateOfBirthDay");
        By monthDropdownMoth = By.name("DateOfBirthMonth");
        By yearDropdownMoth = By.name("DateOfBirthYear");


    //    driver.findElement(By.cssSelector(".icon-register")).click();
        driver.findElement(By.xpath("//a[contains(@class,'ico-register')]")).click();
        driver.findElement(genderMaleBy).click();
        driver.findElement(firstNameBy).sendKeys(firstName);
        driver.findElement(lastNameBy).sendKeys(lastName);

        select = new Select(driver.findElement(dateDropdownMoth));

        //Chon 1 item A
        select.selectByVisibleText(day);
        //Kiem tra dropdown nay co phai la multiple select hay ko
        Assert.assertFalse(select.isMultiple());
        //Kiem tra xem da chon dung item A chua
        Assert.assertEquals(select.getFirstSelectedOption().getText(),day);

        //Get ra tong so item trong dropdown la bao nhieu? =>Verify
      //  Assert.assertEquals(select.getOptions().size(),"32");

        select = new Select(driver.findElement(monthDropdownMoth));
        select.selectByVisibleText(month);

        select = new Select(driver.findElement(yearDropdownMoth));
        select.selectByVisibleText(year);



        driver.findElement(By.id("Email")).sendKeys(Email);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
//
//       WebElement expectedResult = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
//       String actualMessage = expectedResult.getText();
//        Assert.assertEquals(actualMessage,"Your registration completed");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

//        Assert.assertTrue(driver.findElement(genderMaleBy).isSelected());
//        Assert.assertEquals(driver.findElement(firstNameBy).getAttribute("value"),firstName);
    }

    public int getRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(9999);
    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}