package com.BankingSystemCodingChallenge.demo.dto;

public class AccountDetailsDto {
	private int accountHolderId;
	private int accountId;
	private int bankExecutiveId;
	public int getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(int accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getBankExecutiveId() {
		return bankExecutiveId;
	}
	public void setBankExecutiveId(int bankExecutiveId) {
		this.bankExecutiveId = bankExecutiveId;
	}
}
