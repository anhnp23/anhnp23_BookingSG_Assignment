package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MockLoginPage extends BasePage {

    public MockLoginPage() {
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy(id = "submit_btn")
    private WebElement loginBtn;

    public void navigateToService(String url) {
        getWebDriver().get(url);
    }
    public void clickOnLoginBtn() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(loginBtn)).click();
    }
}
