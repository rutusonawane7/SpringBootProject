package com.bankapp.Service;

import java.util.List;

import com.bankapp.entity.Account;

public interface AccountService {
	
	public Account createAccount(Account account);
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	public List<Account> getAllAccountDetails();
	public Account depositAmount(Long accountNumber,double amount);
	public Account withdrwaAmount(Long accountNumber, double amount);
	public void closeAccount(Long accountNumber);
	

}
