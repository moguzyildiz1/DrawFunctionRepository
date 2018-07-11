package com.functiongraph;

/**
 *
 * @author moguzyildiz
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 
import java.io.*; 

@SuppressWarnings("serial")
public class DrawGraphJFrame extends JFrame implements ActionListener{

	private static final int WIDTH = 500;
	private static final int HEIGHT= 300;
	public static final int NUMBER_OF_CHAR = 10;
	private static final int SIZE = 20;  

	public DrawGraphJFrame()
	{
		super("The Visualization of Functions");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		buttonPanel.setLayout(new GridLayout(16,1));

		JButton readFromFile = new JButton("Read and Draw");
		readFromFile.addActionListener(this);
		readFromFile.setBackground(Color.pink);
		buttonPanel.add(readFromFile);

		JButton clearVisualization = new JButton("Clear");
		clearVisualization.addActionListener(this);
		clearVisualization.setBackground(Color.pink);
		buttonPanel.add(clearVisualization);

		JButton exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setBackground(Color.pink);
		buttonPanel.add(exit);

		add(buttonPanel,BorderLayout.WEST);
		DrawGraphJPanel graphPanel = new DrawGraphJPanel(0); 
		add(graphPanel,BorderLayout.CENTER);
	}

	public DrawGraphJFrame(DrawGraphJPanel theGraphPanel)
	{
		super("The Visualization of Functions");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		buttonPanel.setLayout(new GridLayout(16,1));

		JButton readFromFile = new JButton("Read and Draw");
		readFromFile.addActionListener(this);
		readFromFile.setBackground(Color.pink);
		buttonPanel.add(readFromFile);

		JButton clearVisualization = new JButton("Clear");
		clearVisualization.addActionListener(this);
		clearVisualization.setBackground(Color.pink);
		buttonPanel.add(clearVisualization);            

		JButton exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setBackground(Color.pink);
		buttonPanel.add(exit);

		add(buttonPanel,BorderLayout.WEST);
		DrawGraphJPanel graphPanel= new DrawGraphJPanel(theGraphPanel); 
		add(graphPanel,BorderLayout.CENTER);
	}        

	public void actionPerformed(ActionEvent e)
	{
		String buttonString = e.getActionCommand( );

		if(buttonString.equals("Read and Draw"))
		{
			String[] funcString = new String[SIZE];
			GITFunction[] func = new GITFunction[SIZE]; 
			Scanner inputStream = null;
			try
			{
				inputStream = new Scanner(new FileInputStream("graph.txt"));
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
			dispose();             
			DrawGraphJFrame clearFrame = new DrawGraphJFrame(); 
			DrawGraphJPanel graphPanel = new DrawGraphJPanel(i,func);
			clearFrame.add(graphPanel);
			clearFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			clearFrame.setVisible(true);
		}
		else if(buttonString.equals("Clear"))
		{    
			dispose();               
			DrawGraphJFrame clearFrame = new DrawGraphJFrame(); 
			DrawGraphJPanel graphPanel = new DrawGraphJPanel(0);
			clearFrame.add(graphPanel);
			clearFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			clearFrame.setVisible(true);
		}
		else if(buttonString.equals("Exit"))
		{
			System.exit(0);
		}                   
		else
		{
			System.out.println("Unexpected error.");
		}    
	}
}
