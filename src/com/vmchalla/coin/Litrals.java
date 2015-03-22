package com.vmchalla.coin;
/**
 * This class demonstrates the improved literals in java 7 
 * #project Coin
 * @author vmohanchalla
 *
 */
public class Litrals {
	//Ease of code readability - does not have any impact on the value
	private long creditCardNumber = 1234_1232_1234_3232L;

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	

}
