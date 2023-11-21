package com.BankingSystemCodingChallenge.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BankingSystemCodingChallenge.demo.dto.AccountDetailsDto;
import com.BankingSystemCodingChallenge.demo.dto.BalanceUpdateDto;
import com.BankingSystemCodingChallenge.demo.enumerates.Role;
import com.BankingSystemCodingChallenge.demo.enumerates.Type;
import com.BankingSystemCodingChallenge.demo.exception.InvalidIdException;
import com.BankingSystemCodingChallenge.demo.model.Account;
import com.BankingSystemCodingChallenge.demo.model.AccountDetails;
import com.BankingSystemCodingChallenge.demo.model.AccountHolder;
import com.BankingSystemCodingChallenge.demo.model.BankExecutive;
import com.BankingSystemCodingChallenge.demo.model.User;
import com.BankingSystemCodingChallenge.demo.service.AccountDetailsService;
import com.BankingSystemCodingChallenge.demo.service.AccountHolderService;
import com.BankingSystemCodingChallenge.demo.service.AccountService;
import com.BankingSystemCodingChallenge.demo.service.BankExecutiveService;
import com.BankingSystemCodingChallenge.demo.service.UserService;

@RestController
public class AccountDetailsController {

	@Autowired
	private AccountHolderService accountHolderService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private BankExecutiveService bankExecutiveService;

	@Autowired
	private UserService userservice;

	@Autowired
	private AccountDetailsService accountDetailsService;

	@PostMapping("/accountHolder/add")
	public AccountHolder insertAccountHolder(@RequestBody AccountHolder accountHolder) {
		accountHolder = accountHolderService.addAccountHolder(accountHolder);
		return accountHolder;
	}

	@PostMapping("/account/add")
	public Account insertAccountHolder(@RequestBody Account account) {
		account = accountService.addAccount(account);
		return account;
	}

	@PostMapping("/executive/add")
	public BankExecutive insertExecutive(@RequestBody BankExecutive executive) {
//		getting username and password from postman req
		User user = executive.getUser();
		user.setRole(Role.EXECUTIVE);
		user = userservice.insert(user);
		executive.setUser(user);
		return bankExecutiveService.insertExecutive(executive);

	}

	@PostMapping("/accountDetails/add")
	public ResponseEntity<?> insertAccountDetails(@RequestBody AccountDetailsDto accountDetailsDto) {
		try {
			// getting accountholder detailsby accountHolderId
			AccountHolder accountHolder = accountHolderService
					.getaccountHolderById(accountDetailsDto.getAccountHolderId());

			// getting account details by accountId
			Account account = accountService.getaccountById(accountDetailsDto.getAccountId());

			// getting bankexecutive by id
			BankExecutive executive = bankExecutiveService.getExecutiveById(accountDetailsDto.getBankExecutiveId());

			// setting all these in account details
			AccountDetails accountDetails = new AccountDetails();
			accountDetails.setAccount(account);
			accountDetails.setAccountHolder(accountHolder);
			accountDetails.setBankExecutive(executive);
			
           //created date is present date ---->local date
			accountDetails.setDate_of_creation(LocalDate.now());
			accountDetails = accountDetailsService.insertAccountDetails(accountDetails);
			return ResponseEntity.ok().body(accountDetails);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/account/accountType/{type}")
	public List<Account> getAccountsByType(@PathVariable("type") Type type) {
		return accountService.getAccountsByType(type);
	}

	

	@PutMapping("/updateaccount/balance")
	public ResponseEntity<?> updateAccountBalance(@RequestBody BalanceUpdateDto balanceUpdateDto) {
		try {
//			to check given account holder id is valid
			AccountHolder accountHolder = accountHolderService
					.getaccountHolderById(balanceUpdateDto.getAccountHolderId());

			AccountDetails accountdetails = accountDetailsService
					.getaccountDetailsByHolderId(balanceUpdateDto.getAccountHolderId());

			Account account = accountdetails.getAccount();
			if (balanceUpdateDto.getBalance() != null) {
				account.setBalance(balanceUpdateDto.getBalance());
			}
			account = accountService.addAccount(account);
			return ResponseEntity.ok().body(account);

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/accountHolders/{eid}")
	public ResponseEntity<?> getAccountHolderce(@PathVariable("eid") int eid) {
		try {
			BankExecutive executive = bankExecutiveService.getExecutiveById(eid);
			List<AccountDetails> accountdetails  = accountDetailsService.getaccountDetailsByExecutiveId(eid);
			List<AccountHolder> accountHolders = new ArrayList<>();
			for(AccountDetails accountDetail:accountdetails) {
				accountHolders.add(accountDetail.getAccountHolder());
			}
			return ResponseEntity.ok().body(accountHolders);

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
