package com.functiongraph;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.consoleui.DGConsoleUI;
import com.gui.DGGUI;

/**
 *
 * @author moguzyildiz
 */
public class FunctionGraphDrawMain {

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int select = 0;  
		boolean done = true;

		while(done)
		{ 
			try
			{
				System.out.println("Enter 1 for GUI\nEnter 2 for Console");
				select = keyboard.nextInt();
				done = false;			

				switch(select)
				{
				case 1:
					guiFunction();
					break;
				case 2:
					consoleFunction();
					break;
				default:
					System.out.println("Error: Unvalid Selection.");
					done = true;
					break;
				}//end of switch block
			}//end of try block
			catch(InputMismatchException e)
			{
				keyboard.nextLine();
				System.out.println("Not a correctly selected.");
				System.out.println("Try again.");
			}//end of catch block
			finally{
				if(keyboard!=null){
					keyboard.close();
				}
			}
		}
	}        

	public static void guiFunction()
	{
		DGUserInterface drawGraphInterface = new DGGUI();
		drawGraphInterface.processCommands();
	}

	public static void consoleFunction()
	{
		DGUserInterface drawGraphInterface = new DGConsoleUI();
		drawGraphInterface.processCommands();
	}        
}
