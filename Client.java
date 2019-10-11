package com.capgemini.client;

import com.capgemini.bank.Icicibank;
import com.capgemini.beans.Account;
import com.capgemini.invalid.Insufficientbalance;
import com.capgemini.invalid.Invalidaccountnumber;

public class Client {

	public static void main(String[] args) {
		
		Icicibank b=new Icicibank();
		//Account acc;
		
		try
		{
			System.out.println(b.createaccount(1234, 2000));
			System.out.println(b.createaccount(2344, 2000));
			//System.out.println(b.searchaccount(123));
			//System.out.println( b.withdraw(456,500));
			//System.out.println(b.deposit(123,500));
			System.out.println(b.fundtransfer(1234, 2344, 2000));
			
			
		}
		catch(Invalidaccountnumber a)
		{
			System.out.println(a.getMessage());
		}
		catch(Insufficientbalance e)
		{
			System.out.println(e.getMessage());
		}

	}

}
