package com.BankingSystemCodingChallenge.demo.dto;

public class BalanceUpdateDto {
	private int accountHolderId;
	private String balance;
	public int getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(int accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
}
