package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"},
        features = "./src/test/resources/features",
        glue = {"stepDefinitions","Hooks"},

        tags = "@All",

        dryRun = false,
        stepNotifications = true, // to see report gherkin step level
        monochrome = false, // outputların daha okunabilir olması ıcın
        publish = true  // it is to get online report
)
public class TestRunnerExtentReport {
}
