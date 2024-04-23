package stepDef;

import base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;

public class ServiceHooks {
    BasePage basePage = new BasePage();

    @Before
    public void initTest() {
        try {
            basePage.setup();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @After
    public void afterTest(Scenario scenario) {
        if(scenario.isFailed()) {
            scenario.attach(((TakesScreenshot)basePage.getWebDriver()).getScreenshotAs(OutputType.BYTES),
                    "image/png", "BookingSG");
        }
        basePage.getWebDriver().quit();
    }
}
