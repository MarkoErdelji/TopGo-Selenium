package topgoSelenium.tests;

import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import topgoSelenium.pages.AdminHomePage;
import topgoSelenium.pages.DriverHomePage;
import topgoSelenium.pages.LoginPage;
import topgoSelenium.pages.PassengerHomePage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends LoginTestBase{

    @Test
    public void login_correctCredentials_passenger() {
        LoginPage login = new LoginPage(driver);
        assertTrue(login.isPageOpened());
        login.insertCredentials("passenger@example.com","test");
        PassengerHomePage passengerHomePage = new PassengerHomePage(driver);
        assertTrue(passengerHomePage.isPageOpened());
        passengerHomePage.logout();
    }

    @Test
    public void login_correctCredentials_admin() {
        LoginPage login = new LoginPage(driver);
        assertTrue(login.isPageOpened());
        login.insertCredentials("admin@gmail.com","test");
        AdminHomePage adminHomePage = new AdminHomePage(driver);
        assertTrue(adminHomePage.isPageOpened());
        adminHomePage.isPageOpened();
    }

    @Test
    public void login_correctCredentials_driver() {
        LoginPage login = new LoginPage(driver);
        assertTrue(login.isPageOpened());
        login.insertCredentials("erdeljimarko@gmail.com","test");
        DriverHomePage driverHomePage = new DriverHomePage(driver);
        assertTrue(driverHomePage.isPageOpened());
        driverHomePage.logout();
    }


    @Test
    public void login_incorrectFormat() {
        LoginPage login = new LoginPage(driver);
        assertTrue(login.isPageOpened());
        login.insertCredentials("Los","Test");
        assertTrue(login.isErrorDialogVisibleWithMessage("Validation failed for object='loginCredentialDTO'. Error count: 1"));
    }


    @Test
    public void login_incorrectCredentials() {
        LoginPage login = new LoginPage(driver);
        assertTrue(login.isPageOpened());
        login.insertCredentials("Los@gmail.com","Test");
        assertTrue(login.isErrorDialogVisibleWithMessage("Wrong username or password!"));
    }
}
