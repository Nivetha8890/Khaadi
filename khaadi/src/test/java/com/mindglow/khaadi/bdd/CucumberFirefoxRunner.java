package com.mindglow.khaadi.bdd;

import com.mindglow.khaadi.bdd.support.WebConnector;
import com.mindglow.khaadi.bdd.support.WebConnector.Browsers;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@nivi", strict = true, format = {"html:target/cucumber"})
public class CucumberFirefoxRunner {
    @BeforeClass
    public static void setUp() {
        WebConnector.getInstance().initialiseDriver(Browsers.valueOf("Firefox"));
    }

    @AfterClass
    public static void tearDown() {
        WebConnector.driver.quit();
    }
}
