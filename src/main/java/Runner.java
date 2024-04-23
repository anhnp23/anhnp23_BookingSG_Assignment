import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
            features = "src/main/resources/feature/Services.feature",
            glue = "stepDef",
            tags = ""
    )
    public class Runner {
        private TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass
        public void beforeTest() {
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }
        @Test(dataProvider = "getScenario")
        public void runnerGetScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
            testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
        @DataProvider
        public Object[][] getScenario() {
            return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass
        public void afterTest() {
            testNGCucumberRunner.finish();
        }
}
