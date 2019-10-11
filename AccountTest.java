package com.capgemini.test;
import com.capgemini.service.*;
import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.exceptions.InvalidAccountnumberException;
import com.capgemini.repo.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AccountTest {
	
	AccountService accountservice;
	@Mock
	AccountRepos accountRepos;
	
	@Before
	public void setup() throws Exception 
	{
		MockitoAnnotations.initMocks(this);
		accountservice=new AccountServiceImpl(accountRepos);
	}
	@Test
	public void whenvalidinfoispassed() throws InsufficientOpeningBalanceException
	{
		Account account=new Account();
		account.setAccountnumber(201);
		account.setAmount(2000);
		when(accountRepos.save(account)).thenReturn(true);
		assertEquals(account,accountservice.createAccount(201, 2000));
	}
	@Test(expected=com.capgemini.exceptions.InsufficientOpeningBalanceException.class)
	public void amountlessthan500() throws InsufficientOpeningBalanceException
	{
		accountservice.createAccount(201,400);
	}
	@Test(expected=com.capgemini.exceptions.InvalidAccountnumberException.class)
	public void accountnumberiswrong() throws InvalidAccountnumberException
	{
		accountservice.depositAmount(202,1000);
	}
	
	

	@Test(expected=com.capgemini.exceptions.InvalidAccountnumberException.class)
	public void accountnumberiswrong_wd() throws InvalidAccountnumberException,InsufficientBalanceException
	{
		accountservice.withdrawAmount(201,1000);
	}
	
	@Test(expected=com.capgemini.exceptions.InsufficientBalanceException.class)
	public void amountisnotsufficient() throws InsufficientBalanceException, InvalidAccountnumberException
	{
		Account account=new Account();
		account.setAccountnumber(201);
		account.setAmount(5000);
		when(accountRepos.searchAccount(201)).thenReturn(account);
		accountservice.withdrawAmount(201,6000);
	}
	
}
