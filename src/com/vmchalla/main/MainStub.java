package com.vmchalla.main;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import com.vmchalla.coin.Diamond;
import com.vmchalla.coin.ForkJoinDemo;
import com.vmchalla.coin.Litrals;
import com.vmchalla.coin.MultiCatch;
import com.vmchalla.coin.SafeVarargsEx;
import com.vmchalla.coin.StringInSwitch;
import com.vmchalla.coin.TryWithResources;

public class MainStub {

	public static void main(String[] args) {
		/**
		 * Java 7 Project coin features
		 * ---------------------------------------------------------------------------
		 */
		//Literals 
		Litrals lit = new Litrals();
		System.out.println(lit.getCreditCardNumber());
		
		//SafeVarargs
		List<String> list1 = Arrays.asList("Sai", "SASA");
		List<String> list2 = Arrays.asList("Baba", "KAKA");
		SafeVarargsEx.getNumbers(list1, list2);
		
		//Diamond Operator
		Diamond.diamondedList();
		
		//MultiCatch
		MultiCatch.demoMulticatch();
		
		//String in Switch
		StringInSwitch sis = new StringInSwitch();
		sis.stringInSwitchDemo("Hello");
		
		//Try With Resources (uncomment the below line to try tryWithResources)
		//new TryWithResources().tryWithResourceDifferenceDemo();
		
		//Fork And Join (parallel programming or concurrent programming)
		
		//A ForkJoinPool -> Default constructor ( no. of threads is the no. of cores of your computer)
		ForkJoinPool pool = new ForkJoinPool();
		
		//Creating 3 ForkJoinTasks 
		ForkJoinDemo system = new ForkJoinDemo("C:\\Windows", "log");
		ForkJoinDemo apps = new ForkJoinDemo("C:\\Program Files", "log");
		ForkJoinDemo documents = new ForkJoinDemo("C:\\Documents And Settings", "docx");
		
		//Tasks executed using ForkJoinPools execute() method
		pool.execute(system);
		pool.execute(apps);
		pool.execute(documents);
		
		//Write info every second
		do{
			System.out.printf("******************************************\n");
	         System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
	         System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
	         System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
	         System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
	         System.out.printf("******************************************\n");
	         try{
	        	 TimeUnit.SECONDS.sleep(1);
	         } catch(InterruptedException e){
	        	 
	         }
		} while ((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));
		
		//Shutting down the pool 
		pool.shutdown();
		
		List<String> result;
		result = system.join();
		System.out.printf("System: %d files found.\n", result.size());
		result = apps.join();
		System.out.printf("Apps: %d files found.\n", result.size());
	    result = documents.join();
	    System.out.printf("Documents: %d files found.\n", result.size());
		
	    //Automatic Reloading with WatchService
	    
		//---------------------------END-----------------------------------------------

	}

}
