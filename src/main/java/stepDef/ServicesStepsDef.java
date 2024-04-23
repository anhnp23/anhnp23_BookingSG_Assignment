package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

public class ServicesStepsDef {
    MockLoginPage loginPage = new MockLoginPage();
    BookingPage bookingPage = new BookingPage();
    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
    ReviewPage reviewPage = new ReviewPage();
    RequestPage requestPage = new RequestPage();
    BookingInfoPage bookingInfoPage = new BookingInfoPage();

    @Given("User opens browser and navigate {string} with {string} and click on Mock Login")
    public void userOpensBrowserAndNavigateToAndLogin(String serviceName, String url) {
        System.out.println("The recent service is " + serviceName.toUpperCase());
        loginPage.navigateToService(url);
        loginPage.clickOnLoginBtn();
    }

    @When("User should see Booking page chooses the time slot")
    public void userShouldSeeBookingPageOfAndChoosesTheFirstTimeSlot() {
        bookingPage.chooseTheFirstSlot();
        Assert.assertTrue(bookingPage.isConfirmTimeSlotDisplay());
        bookingPage.getEndTimeOfSlot();
        Assert.assertTrue(bookingPage.isComfirmButtonEnabled());
    }

    @When("User clicks confirm button in Booking page")
    public void userClicksConfirmButtonInBookingPage() {
        Assert.assertTrue(bookingPage.isComfirmButtonEnabled());
        bookingPage.clickOnConfirmBtn();
    }

    @And("User should see Personal details page and click on Next button")
    public void userShouldSeePersonalDetailsPageAndClickOnNextButton() {

        personalDetailsPage.clickOnNextButton();
    }

    @And("User should see Review page and click on Submit button")
    public void userShouldSeeReviewPageAndClickOnSubmitButton() {

        reviewPage.clickOnSubmitButton();
    }

    @And("User should see Booking request page and click on View booking button")
    public void userShouldSeeBookingRequestPageAndClickOnViewBookingButton() {
        requestPage.clickOnViewYourRequestButton();
    }

    @Then("User should see Your bookings page")
    public void userShouldSeeYourBookingsPage() {

    }

    @And("User should see Booking request page in {string}")
    public void userShouldSeeBookingRequestPageWith(String serviceName) {
        switch (serviceName.toUpperCase()) {
            case "SERVICE_1", "SERVICE_2", "SERVICE_4", "SERVICE_6":
                requestPage.clickOnViewYourRequestButton();
                break;
            case "SERVICE_3", "SERVICE_5":
                requestPage.clickOnViewYourRequestButton();
        }
    }

    @And("User should see information of booking request in {string} with status as {string}")
    public void userShouldSeeInformationOfBookingRequestInWithStatusAs(String serviceName, String status) {
        switch (serviceName.toUpperCase()) {
            case "SERVICE_1":
                Assert.assertTrue(bookingInfoPage.isProviderNameVisible(serviceName), "Booking request is assigned for admin");
                Assert.assertTrue(bookingInfoPage.isEndTimeDisplayed(), "End time is displayed");
                Assert.assertFalse(bookingInfoPage.isCancelBtnEnable(), "Cancel button is disabled");
                Assert.assertFalse(bookingInfoPage.isRescheduleBtnEnable(), "Reschedule button is disabled");
                Assert.assertTrue(bookingInfoPage.verifyStatus(status), "Status: Pending Approval");
                break;
            case "SERVICE_2":
                Assert.assertFalse(bookingInfoPage.isProviderNameVisible(serviceName), "Booking request has been assigned for admin");
                Assert.assertTrue(bookingInfoPage.isEndTimeDisplayed(), "End time is displayed");
                Assert.assertFalse(bookingInfoPage.isCancelBtnEnable(), "Cancel button is disabled");
                Assert.assertFalse(bookingInfoPage.isRescheduleBtnEnable(), "Reschedule button is disabled");
                Assert.assertTrue(bookingInfoPage.verifyStatus(status), "Status: Pending Acceptance");
                break;
            case "SERVICE_3":
                Assert.assertTrue(bookingInfoPage.isProviderNameVisible(serviceName), "Booking request is assigned for admin");
                Assert.assertTrue(bookingInfoPage.isEndTimeDisplayed(), "End time is displayed");
                Assert.assertFalse(bookingInfoPage.isCancelBtnEnable(), "Cancel button is disabled");
                Assert.assertTrue(bookingInfoPage.isRescheduleBtnEnable(), "Reschedule button is enabled");
                Assert.assertTrue(bookingInfoPage.verifyStatus(status), "Status: Accepted");
                break;
            case "SERVICE_4":
                Assert.assertFalse(bookingInfoPage.isProviderNameVisible(serviceName), "Booking request has been assigned for admin");
                Assert.assertFalse(bookingInfoPage.isEndTimeDisplayed(), "End time is not displayed");
                Assert.assertFalse(bookingInfoPage.isCancelBtnEnable(), "Cancel button is disabled");
                Assert.assertFalse(bookingInfoPage.isRescheduleBtnEnable(), "Reschedule button is disabled");
                Assert.assertTrue(bookingInfoPage.verifyStatus(status), "Status: Pending Approval");
                break;
            case "SERVICE_5":
                Assert.assertTrue(bookingInfoPage.isProviderNameVisible(serviceName), "Booking request is assigned for admin");
                Assert.assertFalse(bookingInfoPage.isEndTimeDisplayed(), "End time is not displayed");
                Assert.assertTrue(bookingInfoPage.isCancelBtnEnable(), "Cancel button is enabled");
                Assert.assertFalse(bookingInfoPage.isRescheduleBtnEnable(), "Reschedule button is disabled");
                Assert.assertTrue(bookingInfoPage.verifyStatus(status), "Status: Accepted");
                break;
            case "SERVICE_6":
                Assert.assertFalse(bookingInfoPage.isProviderNameVisible(serviceName), "Booking request has been assigned for admin");
                Assert.assertFalse(bookingInfoPage.isEndTimeDisplayed(), "End time is not displayed");
                Assert.assertFalse(bookingInfoPage.isCancelBtnEnable(), "Cancel button is disabled");
                Assert.assertFalse(bookingInfoPage.isRescheduleBtnEnable(), "Reschedule button is disabled");
                Assert.assertTrue(bookingInfoPage.verifyStatus(status), "Status: Pending Acceptance");
                break;
            default:
                System.out.println("Launching Chrome");
        }
    }
}
