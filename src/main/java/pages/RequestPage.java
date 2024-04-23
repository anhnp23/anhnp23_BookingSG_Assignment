package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RequestPage extends BasePage {
    public RequestPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "//*[@data-testid='desktop-viewBookings']")
    private WebElement viewBookingsBtn;

    public void clickOnViewYourRequestButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(viewBookingsBtn)).click();
    }
}
