package com.BankingSystemCodingChallenge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingSystemCodingChallenge.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
