package com.vmchalla.coin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This class demonstrates the Muticatch feature in java 7
 * 
 * @author vmohanchalla
 *
 */
public class MultiCatch {

	public static void demoMulticatch() {

		try {
			Class<?> diamond = Class.forName("com.vmchalla.coin.Diamond");
			System.out.println(diamond.getMethods());
			Method[] methods = diamond.getMethods();
			for (Method m : methods) {
				System.out.println(" Diamonds " + m.getName()
						+ " method ");
				if(m.getName().equals("diamondedList"))m.invoke(null);

				

			}
		} catch (ClassNotFoundException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.out.println("Exception Caught");
		}
	}

}
