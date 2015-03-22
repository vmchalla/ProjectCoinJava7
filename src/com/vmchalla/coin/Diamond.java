package com.vmchalla.coin;

import java.util.ArrayList;
import java.util.List;

/**
 * This class dempnstrates the diamond operator for generic Collections
 * @author vmohanchalla
 *
 */
public class Diamond {
	
	
	public static void diamondedList(){
		//You give the type parameter only once for List
		//The compiler uses the context for ArrayList definition.
		List<String> strings = new ArrayList<>();
		strings.add("Sai");
		strings.add("baba");
		System.out.println(strings);
	}

}
