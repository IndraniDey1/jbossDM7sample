package com.syngenta.sadie.agreportingrules.rules.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The test class that will instantiate all of the cucumber feature files.
 * 
 * @author Sunil Samuel (web_github@sunilsamuel.com)
 *com.syngenta.sadie.agreportingrules.rules
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/syngenta/sadie/agreportingrules/rules/cucumber", glue = "com/syngenta/sadie/agreportingrules/rules/cucumber/steps", plugin = {
		"pretty" }, monochrome = true, tags = { "~@Ignore" })
public class AgReportingRulesTest {

}
