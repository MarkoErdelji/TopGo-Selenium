package topgoSelenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
    @FindBy(id = "mat-input-2")
    WebElement departure;
    @FindBy(id = "mat-input-3")
    WebElement destination;


    public void logout(){
        WebElement logoutButton = new WebDriverWait(webDriver,10).until(ExpectedConditions.elementToBeClickable(this.webDriver.findElement(By.id("logout"))));
        logoutButton.click();
    }
    public PassengerHomePage(WebDriver driver){
        this.webDriver = driver;

        PageFactory.initElements(driver,this);
    }
    public void enterDepartureAndDestination(String departureAddress,String destinationAddress)
    {
        departure.sendKeys(departureAddress);
        destination.sendKeys(destinationAddress);
        goButton.click();
    }
    public boolean isRouteLoaded() {
        try {
            WebElement marker = (new WebDriverWait(webDriver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='assets/destination-marker.png']")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickCancelReview(){
        WebElement cancelReviewButton = new WebDriverWait(webDriver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dialog-review #cancel-btn")));
        cancelReviewButton.click();
    }
    public boolean isReviewDialogUp(){
        try {
            WebElement ride = (new WebDriverWait(webDriver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-review")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void selectStandard()
    {
        WebElement select = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("mat-select-2")));
        select.click();
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("mat-option-0"))).click();
        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("order-button"))).click();

    }
    public boolean isRideCreated()
    {
        try {
            WebElement ride = (new WebDriverWait(webDriver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm-ride-info")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitForRideDialogWithMessage(String message)
    {
        try {
            WebElement dialog = (new WebDriverWait(webDriver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id(message)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean waitForNoDriversDialog()
    {
        try {
            WebElement dialog = (new WebDriverWait(webDriver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("no-drivers")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }









    public boolean isPageOpened(){
        boolean isOpened = (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.textToBePresentInElement(goButton,"Go"));

        return isOpened;
    }
}
