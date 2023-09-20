package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_Command_I {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @Test
    public void TC_01() {

        //Lay ID hien tai cua window/tab dang active
     String messengerID=  driver.getWindowHandle();

        //lay ra tat ca cac ID cua tat ca cac tab/window dang co
        driver.getWindowHandles();

        //switch/nhay den 1 tab, window nao do
        driver.switchTo().window(messengerID);

        //tim ra 1  element vs locator nao do
        driver.findElement(By.id(""));
        //tim ra tat ca  element vs locator nao do
        driver.findElements(By.id(""));

        //tra ve url hien tai
        driver.getCurrentUrl();

        // set toa do cho man hinh
        driver.manage().window().setSize(new Dimension(1920,1080));


        //set nam ngay toa do 00, tren trai man hinh
        driver.manage().window().setPosition(new Point(0,0));
        //lay ra kich thuoc hien tai cua browser
            driver.manage().window().getSize();

            //back to page
        driver.navigate().back();

        //forward to page
        driver.navigate().forward();

        //tai lai trang
        driver.navigate().refresh();

        //keep history
        driver.navigate().to("https://www.messenger.com/");

        

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