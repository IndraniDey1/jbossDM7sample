package com.syngenta.sadie.agreportingrules.rules.cucumber.steps;

import org.junit.Assert;

import com.syngenta.sadie.agreportingrules.model.CollegeStatus;
import com.syngenta.sadie.agreportingrules.model.LoanAmount;
import com.syngenta.sadie.agreportingrules.model.UserInformation;
import com.syngenta.sadie.agreportingrules.rules.command.RulesEngine;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserInformationSteps {
	private UserInformation userInformation;
	private LoanAmount loanAmount;
	private RulesEngine rulesEngineSupport;

	public UserInformationSteps() {
		userInformation = new UserInformation();
		rulesEngineSupport = new RulesEngine();
	}

	@Given("^a user with the first name (\\S+) and the last name (\\S+)$")
	public void userName(String firstName, String lastName) {
		userInformation.setFirstName(firstName);
		userInformation.setLastName(lastName);
	}

	@Given("^is identified with (\\d+)$")
	public void userIdentifier(Long identifier) {
		userInformation.setIdentifier(identifier);
	}

	@Given("^the user age is (\\d+)$")
	public void userAge(Integer age) {
		userInformation.setAge(age);
	}

	@Given("^the user college status is (\\S+)$")
	public void userCollegeStatus(CollegeStatus collegeStatus) {
		userInformation.setCollegeStatus(collegeStatus);
	}

	@Given("^the user family income is (\\d+)$")
	public void userFamilyIncome(Double familyIncome) {
		userInformation.setFamilyIncome(familyIncome);
	}

	@When("^I check the loan eligibility$")
	public void ruleLoanEligibility() {
		rulesEngineSupport.setDebug(false);
		rulesEngineSupport.initializeProcess("auditFile.log", userInformation);
		rulesEngineSupport.queryCommand("loanAmount", "Query LoanAmount");
		rulesEngineSupport.executeRules();
		loanAmount = rulesEngineSupport.getLoanAmount();
	}

	@Then("^the loan amount is ($|\\S+)$")
	public void validateLoanAmount(Double amount) {
		Assert.assertEquals(amount, loanAmount.getLoanAmount(), 0.001);
	}

	@Then("^the loan user identifier is (\\S+)$")
	public void validateUserIdentifier(Long userIdentifier) {
		Assert.assertEquals(userIdentifier, loanAmount.getUserIdentifier());
	}

	@Then("^the loan eligibility is (\\S+)$")
	public void validateUserIdentifier(Boolean eligibility) {
		Assert.assertEquals(eligibility, loanAmount.getEligible());
	}
}
