package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Runner {

    protected WebDriver driver;
    protected Actions actions;


    @Parameters("browserName")
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

//    protected void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        actions = new Actions(driver);
//    }


    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }

}
