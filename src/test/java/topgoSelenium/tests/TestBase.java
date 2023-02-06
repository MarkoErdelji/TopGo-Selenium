package topgoSelenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public static WebDriver driver;

    public static WebDriver driver2;

    @BeforeSuite
    public void initializeWebDrivers() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
    }

    @AfterSuite
    public void quitDriver1() {
        driver.quit();
    }

    @AfterSuite
    public void quitDriver2() {
        driver2.quit();
    }
}
