package com.vmchalla.coin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This class demonstrates try with resources 
 * introduced in java 7
 * @author vmohanchalla
 *
 */
public class TryWithResources {
	
	public void tryWithResourceDifferenceDemo(){
		//Using try with resources java se7 style
		String se7file ="se7.txt";
		try(OutputStream out = new FileOutputStream(se7file)){
			out.write("Hello world as Bytes".getBytes());
			"abc".charAt(3);
		} catch (StringIndexOutOfBoundsException|IOException e) {
			System.out.println("Error while Working with se7.txt"+e.getMessage());
		}
		
		//Using try java se6 style
		String se6File = "se6.txt";
		try{
			@SuppressWarnings("resource")
			OutputStream out = new FileOutputStream(se6File);
			out.write("Hello World as Bytes".getBytes());
			"abc".charAt(3);
		}catch(StringIndexOutOfBoundsException|IOException e){
			System.out.println("Error while Working with se6.txt"+e.getMessage());
		}
		
		//let Us see if the files were closed for se7 style ( se6 style is not closed)
		File se7f = new File(se7file);
		if(se7f.delete()){
			System.out.println("Delete Successful"+se7file);
		} else {
			System.out.println("Error deleting the file "+se7file);
		}
		
		File se6f = new File(se6File);
		if(se6f.delete()){
			System.out.println("Delete Successful"+se6File);
		} else {
			System.out.println("Error deleting the file "+se6File);
		}
	}
	
	
	

}
