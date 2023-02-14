package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;
    private final TestContext context;

    public MyHooks(TestContext context){
        this.context=context;
    }

    @Before
    public void before(Scenario scenario){
        //context.scenarioName=scenario.getName();
        //System.out.println("DI: scenario name: " + context.scenarioName);
        System.out.println("before: thread id: "+Thread.currentThread().getId() + "," + "scenario name: " + scenario.getName());
        driver= DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        context.driver=driver;
    }

    @After
    public void after(Scenario scenario){
        System.out.println("after: thread id: "+Thread.currentThread().getId() + "," + "scenario name: " + scenario.getName());
        driver.quit();
    }
}
