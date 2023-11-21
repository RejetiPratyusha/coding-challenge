package com.BankingSystemCodingChallenge.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingSystemCodingChallenge.demo.enumerates.Type;
import com.BankingSystemCodingChallenge.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	List<Account> findByType(Type type);

}
