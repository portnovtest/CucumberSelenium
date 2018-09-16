package runner;


import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/features"},
        glue = {"steps"}, monochrome = true,
        //tags = {"@sanity, @prod"},
        plugin = {"pretty","html:target/cucumber","com.cucumber.listener.ExtentCucumberFormatter"})

public class RunCuke /*extends AbstractTestNGCucumberTests*/ {

    @BeforeClass
    public static void setup(){
        ExtentCucumberFormatter.initiateExtentCucumberFormatter();

        // Loads the extent config xml to customize on the report
        ExtentCucumberFormatter.loadConfig(new File("src/extent-config.xml"));

        // User can add the system information as follows
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Firefox");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v62.0");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v3.14.0");
    }

}
