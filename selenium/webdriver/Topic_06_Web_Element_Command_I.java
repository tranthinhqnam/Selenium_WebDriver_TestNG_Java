package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Web_Element_Command_I {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {

        //Tra ve du lieu nam trong attribute cua element
        WebElement element =driver.findElement(By.id(""));
        element.getAttribute("placeholder");//co the lay id, class

        //Lay thuoc tinh cua element
        element.getCssValue("background-color");
        //4ab2f1- hexa
        //rbg

        element.getLocation();
        element.getRect();
        element.getSize();

        //Take Screenshot => Attach to HTML
        element.getScreenshotAs(OutputType.BASE64);
        element.getScreenshotAs(OutputType.FILE);
        element.getScreenshotAs(OutputType.BYTES);

        //Kiem tra 1 element co hien thi hay khong (hien thi : nguoi dung co the nhin thay duoc va thao tac duoc )
        element.isDisplayed();
        //Kiem tra 1 element co the thao tac duoc hay khong (ko bi disable hay read only field)
        element.isEnabled();
        //kiem tra 1 element da duoc chon hay chua (radio/checkbox/dropdown)
        element.isSelected() ;

        //submit vao 1 form
        element.submit();



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