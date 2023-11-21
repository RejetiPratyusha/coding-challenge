package com.BankingSystemCodingChallenge.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankingSystemCodingChallenge.demo.exception.InvalidIdException;
import com.BankingSystemCodingChallenge.demo.model.BankExecutive;
import com.BankingSystemCodingChallenge.demo.repository.BankExecutiverepository;

@Service
public class BankExecutiveService {
	
	@Autowired
	private BankExecutiverepository bankExecutiverepository;

	public BankExecutive insertExecutive(BankExecutive executive) {
		return bankExecutiverepository.save(executive);
	}

	public BankExecutive getExecutiveById(int eid) throws InvalidIdException {
		Optional<BankExecutive> optional = bankExecutiverepository.findById(eid);
		if(!optional.isPresent())
			throw new InvalidIdException("executive id invalid");
		return optional.get();
	}

}
