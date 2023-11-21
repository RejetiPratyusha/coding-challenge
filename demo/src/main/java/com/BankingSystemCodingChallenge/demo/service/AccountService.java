package com.BankingSystemCodingChallenge.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingSystemCodingChallenge.demo.enumerates.Type;
import com.BankingSystemCodingChallenge.demo.exception.InvalidIdException;
import com.BankingSystemCodingChallenge.demo.model.Account;
import com.BankingSystemCodingChallenge.demo.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account getaccountById(int aid) throws InvalidIdException {
		Optional<Account> optional = accountRepository.findById(aid);
		if(!optional.isPresent())
			throw new InvalidIdException("Account id invalid");
		return optional.get();
	}

	public List<Account> getAccountsByType(Type type) {
		return accountRepository.findByType(type);
	}

	
}
