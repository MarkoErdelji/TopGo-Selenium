package topgoSelenium.tests;

import org.testng.annotations.Test;
import topgoSelenium.pages.DriverHomePage;
import topgoSelenium.pages.LoginPage;
import topgoSelenium.pages.PassengerHomePage;

import static org.testng.AssertJUnit.assertTrue;

public class FinishingRideTest extends TestBase{
    @Test
    public void finishRideTest(){
        LoginPage loginPagePassenger = new LoginPage(driver);
        assertTrue(loginPagePassenger.isPageOpened());
        loginPagePassenger.insertCredentials("passenger@example.com","test");
        LoginPage driverPageDriver = new LoginPage(driver2);
        assertTrue(driverPageDriver.isPageOpened());
        driverPageDriver.insertCredentials("erdeljimarko@gmail.com","test");
        PassengerHomePage passengerHomePage = new PassengerHomePage(driver);
        assertTrue(passengerHomePage.isPageOpened());
        DriverHomePage driverHomePage = new DriverHomePage(driver2);
        assertTrue(driverHomePage.isPageOpened());
        driverHomePage.goOnline();
        passengerHomePage.enterDepartureAndDestination("Strazilovska 15","Maksima Gorkog 2,Novi Sad");
        assertTrue(passengerHomePage.isRouteLoaded());
        passengerHomePage.selectStandard();
        assertTrue(passengerHomePage.isRideCreated());
        assertTrue(driverHomePage.waitForAccept());
        assertTrue(passengerHomePage.waitForRideDialogWithMessage("ACCEPTED"));
        assertTrue(driverHomePage.isRouteLoaded());
        driverHomePage.startRide();
        assertTrue(driverHomePage.isRouteLoaded());
        driverHomePage.endRide();
        assertTrue(passengerHomePage.isReviewDialogUp());
        passengerHomePage.clickCancelReview();

    }
}
