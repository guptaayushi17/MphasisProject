package com.capgemini.beans;
import com.capgemini.invalid.*;
public class Account {
	private int accno;
	private int amount;
	public Account(int accno,int amount) {
		super();
		this.accno=accno;
		this.amount=amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	

}
