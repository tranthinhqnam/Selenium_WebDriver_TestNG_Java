package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Web_Element_Command_II {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://automationfc.github.io/basic-form/index.html");
    }

    @Test
    public void TC_01() {

        WebElement emailTextbox= driver.findElement(By.id("mail"));
        if(emailTextbox.isDisplayed()){

            emailTextbox.sendKeys("Automation Testing");
            System.out.println("Email textbox is displayed");
        } else {
            System.out.println("Not displayed");
        }


        WebElement ageOver18Radio = driver.findElement(By.id("over_18"));
        if(ageOver18Radio.isDisplayed()){

            ageOver18Radio.click();
            System.out.println("Age Over 18 is displayed");
        } else {
            System.out.println("Not displayed");
        }


        WebElement eduTextare = driver.findElement(By.id("edu"));
        if(eduTextare.isDisplayed()){

            eduTextare.sendKeys("Automation Testing");
            System.out.println("Education is displayed");
        } else {
            System.out.println("Not displayed");
        }


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