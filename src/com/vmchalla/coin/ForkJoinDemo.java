package com.vmchalla.coin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * This class demonstrates the fork Join framework classes and how to use.
 * @author vmohanchalla
 *
 */
public class ForkJoinDemo extends RecursiveTask<List<String>>{

	private static final long serialVersionUID = 1L;
	//path and extension are declared as final so that they cannot be changed
	// by any thread while in execution.
	private final String path;
	
	private final String extention;
	
	public ForkJoinDemo(String path, String extention){
		this.path = path;
		this.extention = extention;
	}

	@Override
	protected List<String> compute() {
		return process();
	}
	
	private List<String> process(){
		//List of documents 
		List<String> result = new ArrayList<>();
		
		//List of tasks
		List<ForkJoinDemo> tasks = new ArrayList<>();
		
		//Start file Processing by getting the contents of directory
		File file = new File(path);
		File[] listOfFiles = file.listFiles();
		
		// The condition: if the file is a directory fork new Task
		// check file extension and document it.
		if(listOfFiles!=null){
			for(int i=0;i<listOfFiles.length;i++){
				
				// The fork if the element is a directory
				if(listOfFiles[i].isDirectory()){
					ForkJoinDemo task = new ForkJoinDemo(listOfFiles[i].getAbsolutePath(), extention);
					task.fork();
					tasks.add(task);
				} else {
					// This is a file find if extension is good enough for documentation
					if(listOfFiles[i].getName().endsWith(extention)){
						result.add(listOfFiles[i].getName());
					}
				}
			}
		}
		// Add the results from tasks
		for(ForkJoinDemo entry : tasks){
			result.addAll(entry.join());
		}
		
		return result;
	}
	
	

}
