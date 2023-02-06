package topgoSelenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerHomePage {


    private WebDriver webDriver;

    private static String PAGE_URL="http://localhost:4200/registered/home";

    @FindBy(id = "go-button")
    WebElement goButton;


    public void logout(){
        WebElement logoutButton = new WebDriverWait(webDriver,10).until(ExpectedConditions.elementToBeClickable(this.webDriver.findElement(By.id("logout"))));
        logoutButton.click();
    }
    public PassengerHomePage(WebDriver driver){
        this.webDriver = driver;

        PageFactory.initElements(driver,this);
    }








    public boolean isPageOpened(){
        boolean isOpened = (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.textToBePresentInElement(goButton,"Go"));

        return isOpened;
    }
}
