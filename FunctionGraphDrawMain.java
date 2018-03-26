/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functiongraph;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author YOGA
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
            }
            catch(InputMismatchException e)
            {
                 keyboard.nextLine();
                 System.out.println("Not a correctly selected.");
                 System.out.println("Try again.");
            }
              
            switch(select)
            {
                case 1:
                    guiFunction();
                    break;
                case 2:
                    consoleFunction();
                    break;
                default:
                    System.out.println("Error: False Selection.");
                    done = true;
                    break;
            }
            //Systemclear
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
