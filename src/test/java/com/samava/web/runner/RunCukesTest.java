package com.samava.web.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "json:target/cucumber.json", features =
        "src/test/resources/features/",
        glue = "com.samava.web.stepdefs")
public class RunCukesTest {

}