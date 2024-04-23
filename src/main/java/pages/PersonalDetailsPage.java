package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalDetailsPage extends BasePage {
    public PersonalDetailsPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "//button[@data-testid='submit-button']")
    private WebElement nextBtn;

    public void clickOnNextButton() {

        getWebDriverWait().until(ExpectedConditions.visibilityOf(nextBtn)).click();
    }
}
