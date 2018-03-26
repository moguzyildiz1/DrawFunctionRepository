/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functiongraph;

/**
 * @author moguzyildiz
 */

import java.io.*;
import java.util.*;
import javax.swing.*;

public class DGConsoleUI implements DGUserInterface
{
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int SIZE = 20;

    public void processCommands()
    {
        Scanner keyboard = new Scanner(System.in); 
        System.out.println("Enter your process");

        String[] funcString = new String[SIZE];
        GITFunction[] func = new GITFunction[SIZE]; 
        Scanner inputStream = null;
        try
        {
            inputStream =
               new Scanner(new FileInputStream("graph.txt"));
        }
        catch(FileNotFoundException k)
        {
            System.out.println("File graph.txt was not found");
            System.out.println("or could not be opened.");
            System.exit(0);
        }

        String delimiters = ", ";
        int i = 0;
        while(inputStream.hasNextLine())
        {    
            funcString[i] = inputStream.nextLine();
            StringTokenizer nameFactory = 
                     new StringTokenizer(funcString[i], delimiters);

            String name = nameFactory.nextToken( );
            int min = (int)Double.parseDouble(nameFactory.nextToken( ));
            int max = (int)Double.parseDouble(nameFactory.nextToken( ));
            String color = nameFactory.nextToken( );

            func[i++] = new GITFunction(name,min,max,color);
        }
        
        JFrame frame1 = null;
        JFrame frame2 = null;
        
        while(true)
        {   
            System.out.println("Enter 1 for Read and draw");
            System.out.println("Enter 2 for Clear");
            System.out.println("Enter 3 for exit");
            int select = keyboard.nextInt(); 
            switch(select)
            {
                case 1:
                {  
                    if(frame2 != null)
                        frame2.dispose();
                    else if(frame1 != null)
                        frame1.dispose();
                    
                    frame1 = new JFrame("Graph Of Function");
                    DrawGraphJPanel graphPanel;                                    
                    graphPanel = new DrawGraphJPanel(i,func);
                    frame1.setSize(WIDTH,HEIGHT);
                    frame1.add(graphPanel);
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame1.setVisible(true);                     
                }
                    break;
                case 2:
                {   
                    if(frame1 != null)
                        frame1.dispose();
                    if(frame2 != null)
                        frame2.dispose();
                    
                    frame2 = new JFrame("Graph Of Function");
                    frame2.dispose();
                    DrawGraphJPanel graphPanel;
                    graphPanel = new DrawGraphJPanel(0);
                    frame2.setSize(WIDTH,HEIGHT);
                    frame2.add(graphPanel);
                    frame2.setVisible(true);                    
                }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("False selection,enter again...");
                    break;
            }    
        }
    }
}
