package topgoSelenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver webDriver;

    private static String PAGE_URL="http://localhost:4200/login";

    @FindBy(id = "login-header-h1")
    WebElement loginHeader;

    public LoginPage(WebDriver driver){
        this.webDriver = driver;
        driver.get(PAGE_URL);

        PageFactory.initElements(driver,this);
    }

    public void insertCredentials(String email,String password){

        WebElement emailInput = webDriver.findElement(By.cssSelector("#email-field input"));
        emailInput.sendKeys(email);

        WebElement passwordInput = webDriver.findElement(By.cssSelector("#password-field input"));
        passwordInput.sendKeys(password);

        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();

    }


    public boolean isErrorDialogVisibleWithMessage(String message){
        WebElement dialog =(new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("validation-error-dialog"))));

        return (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.textToBePresentInElement(dialog.findElement(By.cssSelector(".mat-dialog-content")), message));
    }
    public boolean isPageOpened(){
        boolean isOpened = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.textToBePresentInElement(loginHeader, "SIGN IN"));

        return isOpened;
    }
}
