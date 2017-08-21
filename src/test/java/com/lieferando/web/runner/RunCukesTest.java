package com.lieferando.web.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "json:target/cucumber.json", features = {
        "src/test/resources/features/AddressOrPostcodeSearch.feature"},
        glue = "com.lieferando.web.stepdefs")
public class RunCukesTest {

}