package com.capgemini.invalid;
import java.util.Arrays;

import com.capgemini.beans.*;

public class Invalidaccountnumber extends Exception {
	
		/*public Invalidaccountnumber() {
			
		}
		public Invalidaccountnumber(String msg)
		{
			super(msg);
		}*/
		public String getMessage() {
			// TODO Auto-generated method stub
			return "invalid account number";
		}
		
		
	}


