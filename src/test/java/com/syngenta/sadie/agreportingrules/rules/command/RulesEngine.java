package com.syngenta.sadie.agreportingrules.rules.command;

import java.util.List;

import com.syngenta.sadie.agreportingrules.model.LoanAmount;

@SuppressWarnings("unchecked")
public class RulesEngine extends RulesEngineSupport {

	public LoanAmount getLoanAmount() {
		List<LoanAmount> loanAmounts = (List<LoanAmount>) get("loanAmount", LoanAmount.class);
		return (loanAmounts == null || loanAmounts.size() == 0 ? null : loanAmounts.get(0));
	}

	public List<LoanAmount> getLoanAmounts() {
		return (List<LoanAmount>) get("loanAmount", LoanAmount.class);
	}
}
