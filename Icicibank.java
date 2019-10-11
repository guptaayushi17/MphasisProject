package com.capgemini.bank;
import java.util.LinkedList;
import com.capgemini.beans.*;
import com.capgemini.invalid.*;
public class Icicibank {
	LinkedList<Account> accounts=new LinkedList();
	
	public String createaccount(int accno,int amount)
	{
		Account account=new Account(accno,amount);
		accounts.add(account);
		return "account created";
	}
	public Account searchaccount(int accno)throws Invalidaccountnumber
	{
		for(Account account:accounts)
		{
			if(account.getAccno()==accno)
			{
				return account;
			}
		}
		throw new Invalidaccountnumber();
	}
	
	public int withdraw(int accno,int amount) throws Insufficientbalance, Invalidaccountnumber 
	{
		Account account=searchaccount(accno);
		if(account.getAmount()>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		else 
		throw new Insufficientbalance();
	}
    
	public int deposit(int accno,int amount) throws Invalidaccountnumber
	{
		Account account=searchaccount(accno);
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
	}
	
	public String fundtransfer(int accno1,int accno2,int amount)  throws Insufficientbalance, Invalidaccountnumber 
	{	Account account=searchaccount(accno1);
		Account account2=searchaccount(accno2);
		account.setAmount(account.getAmount()-amount);
		account2.setAmount(account2.getAmount()+amount);
		return "balance of ac 1 is:"+ account.getAmount()+"and balance of account2 is"+account2.getAmount();
	}


}
