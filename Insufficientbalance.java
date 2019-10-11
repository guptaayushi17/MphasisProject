package com.capgemini.invalid;

public class Insufficientbalance extends Exception {
	public Insufficientbalance()
	{
		
	}
	public Insufficientbalance(String msg1)
	{
		super(msg1);
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "balance insufficient";
	}
	

}
