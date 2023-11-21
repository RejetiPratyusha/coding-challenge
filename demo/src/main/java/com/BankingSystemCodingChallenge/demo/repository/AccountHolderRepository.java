package com.BankingSystemCodingChallenge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingSystemCodingChallenge.demo.model.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer>{

}
