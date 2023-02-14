package awesomecucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber.html","summary"},
                snippets = CucumberOptions.SnippetType.CAMELCASE,
                //dryRun = true,
                //tags = "@dummyscneraio2",
                //glue = {"awesomecucumber.stepdef","awesomecucumber.hooks"},
                glue = {"awesomecucumber"},

                features = "src/test/resources/awesomecucumber"
                //monochrome = true
        )

public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

//    @BeforeClass
//    public static void beforeclass(){
//        System.out.println("befor class");
//    }
//
//    @AfterClass
//    public static void afterclass(){
//        System.out.println("after class");
//    }
}
