package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.logging.Logger;

public class BookingInfoPage extends BasePage {
    public BookingInfoPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "//div[contains(@data-testid,'status-pill')]/div")
    private WebElement statusBtn;
    @FindBy(xpath = "//*[@data-testid='reschedule-button']")
    private WebElement rescheduleBtn;
    @FindBy(xpath = "//*[@data-testid='cancel-button']")
    private WebElement cancelBtn;
    @FindBy(xpath = "//*[@data-testid='service-provider-title']")
    private WebElement serviceProviderName;
    @FindBy(xpath = "//*[contains(@data-testid, 'booking-list-table-row') and contains(@data-testid,'service') and not(contains(@data-testid,'Provider'))]")
    private WebElement serviceNameText;
    @FindBy(xpath = "//*[contains(@data-testid, 'booking-list-table-row') and contains(@data-testid,'time')]//p[2]")
    private WebElement bookingTime;

    public boolean verifyStatus(String status) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(statusBtn));
        Assert.assertEquals(status.toUpperCase(), statusBtn.getText().toUpperCase());
        String actualStatus = statusBtn.getText().toUpperCase();
        String expectStatus = status.toUpperCase();
        return actualStatus.contains(expectStatus);
    }

    public boolean isProviderNameVisible(String serviceName) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(serviceProviderName));
        Logger.getLogger("Provider name is: " + serviceProviderName.getText());
        String actualProviderName = serviceProviderName.getText();
        String expectProviderName = (serviceName.replace("_", " ").toLowerCase().toLowerCase()) + " sp";
        return actualProviderName.contains(expectProviderName);
    }

    public boolean isCancelBtnEnable() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(cancelBtn));
        return cancelBtn.isEnabled();
    }

    public boolean isRescheduleBtnEnable() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(rescheduleBtn));
        return rescheduleBtn.isEnabled();
    }

    public boolean isEndTimeDisplayed() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(bookingTime));
        String time = bookingTime.getText();
        return (time.contains("-") && time.contains(END_TIME));
    }
}
