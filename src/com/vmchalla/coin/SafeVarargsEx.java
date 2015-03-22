package com.vmchalla.coin;

import java.util.List;
/**
 * This class demonstrates the safevarargs annotation which
 * Suppresses the warning on varargs.. (not sure if thats helpful at all...:O
 * @author vmohanchalla
 *
 */
public class SafeVarargsEx {
	
	@SafeVarargs
	public static void getNumbers(List<String>... stringLists){
		if(stringLists==null || stringLists.length==0){
			System.out.println("String Lists is empty");
		}
		for(int i=0;i<stringLists.length;i++){
			System.out.println(stringLists[i].get(0));
			
		}
	}

}
