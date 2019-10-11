package com.capgemini.service;
import com.capgemini.beans.*;
import com.capgemini.exceptions.*;

public interface AccountService {
	
	Account createAccount(int accountnumber,int amount) throws InsufficientOpeningBalanceException;
	int depositAmount(int accountnumber,int amount) throws InvalidAccountnumberException;
   int withdrawAmount(int accountnumber,int amount) throws InvalidAccountnumberException,InsufficientBalanceException;
}