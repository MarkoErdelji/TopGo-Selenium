package topgoSelenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class LoginTestBase {

    public static WebDriver driver;


    @BeforeSuite
    public void initializeWebDrivers() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void quitDriver1() {
        driver.quit();
    }

}
