package com.capgemini.repo;

import com.capgemini.beans.*;
public interface AccountRepos  {
	boolean save(Account account);
	Account searchAccount(int accountnumber);
}
