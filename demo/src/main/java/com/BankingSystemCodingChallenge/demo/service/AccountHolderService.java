package com.BankingSystemCodingChallenge.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingSystemCodingChallenge.demo.exception.InvalidIdException;
import com.BankingSystemCodingChallenge.demo.model.AccountHolder;
import com.BankingSystemCodingChallenge.demo.repository.AccountHolderRepository;

@Service
public class AccountHolderService {
	@Autowired
private AccountHolderRepository accountHolderRepository;
	public AccountHolder addAccountHolder(AccountHolder accountHolder) {
		return accountHolderRepository.save(accountHolder);
	}
	public AccountHolder getaccountHolderById(int aid) throws InvalidIdException {
		Optional<AccountHolder> optional = accountHolderRepository.findById(aid);
		if(!optional.isPresent())
			throw new InvalidIdException("AccountHolder id invalid");
		return optional.get();
	}

}
