package com.capgemini.service;
import com.capgemini.repo.*;
import com.capgemini.beans.*;
import com.capgemini.exceptions.*;

public class AccountServiceImpl implements AccountService {
	AccountRepos accountrepos;

	public AccountServiceImpl(AccountRepos accountrepo) {
		super();
		this.accountrepos = accountrepo;
	}
	
	public Account createAccount(int accountnumber,int amount) throws InsufficientOpeningBalanceException
	{
		if(amount<500)
		{
			throw new InsufficientOpeningBalanceException();
			
		}
		Account account=new Account();
		account.setAccountnumber(accountnumber);
		account.setAmount(amount);
		if(accountrepos.save(account))
		{
			return account;
		}
		return null;
	}
	public int withdrawAmount(int accountnumber,int amount) throws InvalidAccountnumberException,InsufficientBalanceException
	{
	Account account=accountrepos.searchAccount(accountnumber);
	if(account==null)
	{
		
		throw new InvalidAccountnumberException();
	}
	if(account.getAmount()<amount)
	{
		
		throw new InsufficientBalanceException();
	}
		account.setAmount(account.getAmount()-amount);
		accountrepos.save(account);
		return account.getAmount();
	}
	public int depositAmount(int accountnumber,int amount) throws InvalidAccountnumberException
	{
		Account account=accountrepos.searchAccount(accountnumber);
		if(account==null)
		{
			throw new InvalidAccountnumberException();
		}
		account.setAmount(account.getAmount()+amount);
		accountrepos.save(account);
		System.out.println("deposit successfull");
		return account.getAmount();
	}
}
	

