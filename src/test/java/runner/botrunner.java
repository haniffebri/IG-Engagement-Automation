package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"step"},
        features = {"src/test/java/features"},
        plugin = {"pretty"}
)

public class botrunner {
}
