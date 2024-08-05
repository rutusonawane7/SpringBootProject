package com.bankapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.entity.Account;
import com.bankapp.repo.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService {
	
	
	@Autowired 
	AccountRepository repo;

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		
		Account account_saved = repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account account_found = account.get();
		
		return account_found;
	}

	@Override
	public List<Account> getAllAccountDetails() {
		List<Account> listOfAccount = repo.findAll();
		return listOfAccount;
	}
	

	@Override
	public Account depositAmount(Long accountNumber, double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not Present ");
		}
		Account accountPresent = account.get();
		double totalBalance = accountPresent.getAccountBalance()+amount;
		accountPresent.setAccountBalance(totalBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withdrwaAmount(Long accountNumber, double amount) {
		Optional<Account> account = repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not Present ");
		}
		Account accountPresent = account.get();
		double accountBalance = accountPresent.getAccountBalance()-amount;
		accountPresent.setAccountBalance(accountBalance);
		repo.save(accountPresent);
		return accountPresent;
	
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
		
	}
	
	

}
