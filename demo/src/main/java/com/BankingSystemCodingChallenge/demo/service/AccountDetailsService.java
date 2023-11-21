package com.BankingSystemCodingChallenge.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingSystemCodingChallenge.demo.model.AccountDetails;
import com.BankingSystemCodingChallenge.demo.model.AccountHolder;
import com.BankingSystemCodingChallenge.demo.repository.AccountDetailsRepository;

@Service
public class AccountDetailsService {
	
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	public AccountDetails insertAccountDetails(AccountDetails accountDetails) {
		return accountDetailsRepository.save(accountDetails);
	}

	public AccountDetails getaccountDetailsByHolderId(int id) {
		return accountDetailsRepository.findByAccountHolderId(id);
	}

	public List<AccountDetails> getaccountDetailsByExecutiveId(int eid){
		return accountDetailsRepository.findByBankExecutiveId(eid);
	}

	

}
