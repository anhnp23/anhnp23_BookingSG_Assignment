package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReviewPage extends BasePage {
    public ReviewPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "(//img[@alt='BookingSG-app-logo'])[1]")
    private WebElement bookingAppLogo;
    @FindBy(xpath = "//button[@data-testid='back-button']")
    private WebElement nameTitle;
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    private WebElement submitBtn;

    public void clickOnSubmitButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(bookingAppLogo));
        getWebDriverWait().until(ExpectedConditions.visibilityOf(nameTitle));
        getWebDriverWait().until(ExpectedConditions.visibilityOf(submitBtn)).click();
    }

}
