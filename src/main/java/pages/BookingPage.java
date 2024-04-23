package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingPage extends BasePage {
    public BookingPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "(//img[@alt='BookingSG-app-logo'])[1]")
    private WebElement bookingAppLogo;
    @FindBy(xpath = "//h1[@data-testid='service-title']")
    private WebElement bookingTitle;
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//*[@data-testid='calendar-date-text']")
    private WebElement calenderTitle;
    @FindBy(xpath = "//p[contains(text(),'Afternoon slots')]")
    private WebElement afterSlots;
    @FindBy(xpath = "(//*[@data-testid='card-content'])[1]//span[1]")
    private WebElement firstTimeSlot;
    @FindBy(xpath = "//div[@data-testid='selected-date-time']//h4")
    private WebElement confirmTimeSlotInfor;

    public void chooseTheFirstSlot() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(firstTimeSlot)).isDisplayed();
        firstTimeSlot.click();
    }

    public boolean isComfirmButtonEnabled() {
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(confirmBtn)).isEnabled();
    }

    public boolean isConfirmTimeSlotDisplay() {
        return getWebDriverWait().until(ExpectedConditions.visibilityOf(confirmTimeSlotInfor)).isDisplayed();
    }

    public void getEndTimeOfSlot() {
        String timeSlotText = getWebDriverWait().until(ExpectedConditions.visibilityOf(firstTimeSlot)).getText();
        timeSlotText = timeSlotText.substring(0, timeSlotText.length() - 2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime startTime = LocalTime.parse(timeSlotText, formatter);
        System.out.println("Start Time: " + startTime);
        LocalTime plusHoursTime = startTime.plusHours(1);
        END_TIME = plusHoursTime.format(formatter);
        System.out.println("End Time: " + END_TIME);
    }


    public void clickOnConfirmBtn() {
        confirmBtn.click();
    }
}
