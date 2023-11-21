package com.BankingSystemCodingChallenge.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingSystemCodingChallenge.demo.model.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer>{

	AccountDetails findByAccountHolderId(int id);

	List<AccountDetails> findByBankExecutiveId(int eid);

}
