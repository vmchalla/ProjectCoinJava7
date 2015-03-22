package com.vmchalla.coin;


/**
 * This class demonstrates switch with string literals
 * this is a dummy implementation of List.contains()
 * @author vmohanchalla
 *
 */
public class StringInSwitch {
	
	public void stringInSwitchDemo( String value){
		
		if(value==null || value.isEmpty()){
			System.out.println("Nothing to process");
		} else {
			switch(value){
			case "Hello" : System.out.println("the value is Hello");
				break;
			case "World" : System.out.println("The value is world");
				break;
			default : System.out.println("The value is not in my list");
			}
		}
		
	}

}
