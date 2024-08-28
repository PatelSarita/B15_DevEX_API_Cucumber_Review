package api.devEx.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "api/devEx/stepDefinitions",
        dryRun = false,
        tags = "@ui_api_e2e"
)

public class CukesRunner {
}
