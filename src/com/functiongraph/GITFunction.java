package com.functiongraph;

/**
 *
 * @author moguzyildiz
 */

import java.awt.Color;

public class GITFunction {
	private String fName;
	private int fMin;
	private int fMax;
	private Color fColor;

	public GITFunction()
	{
		fName = "";
		fMin = 0;
		fMax = 0;
		fColor = Color.BLACK;
	}        

	public GITFunction(String tName,int tMin,int tMax,String tColor)
	{
		setName(tName);
		setMin(tMin);
		setMax(tMax);
		setColor(tColor);
	}

	public String getName(){return fName;}
	public int getMin(){return fMin;}
	public int getMax(){return fMax;}
	public Color getColor(){return fColor;}

	public void setName(String tName)
	{
		fName = tName;
	}        

	public void setMin(int tMin)
	{
		fMin = tMin;
	} 

	public void setMax(int tMax)
	{
		fMax = tMax;
	} 

	private void setColor(String theColor)
	{                
		if(theColor.equalsIgnoreCase("red"))
			fColor = Color.RED;
		else if(theColor.equalsIgnoreCase("black"))
			fColor = Color.BLACK;
		else if(theColor.equalsIgnoreCase("blue"))
			fColor = Color.BLUE;
		else if(theColor.equalsIgnoreCase("cyan"))
			fColor = Color.CYAN;
		else if(theColor.equalsIgnoreCase("dark_gray"))
			fColor = Color.DARK_GRAY;
		else if(theColor.equalsIgnoreCase("gray"))
			fColor = Color.GRAY; 
		else if(theColor.equalsIgnoreCase("green"))
			fColor = Color.GREEN;
		else if(theColor.equalsIgnoreCase("light_gray"))
			fColor = Color.LIGHT_GRAY;
		else if(theColor.equalsIgnoreCase("magenta"))
			fColor = Color.MAGENTA;
		else if(theColor.equalsIgnoreCase("orange"))
			fColor = Color.ORANGE;
		else if(theColor.equalsIgnoreCase("pink"))
			fColor = Color.PINK;
		else if(theColor.equalsIgnoreCase("red"))
			fColor = Color.RED;
		else if(theColor.equalsIgnoreCase("white"))
			fColor = Color.WHITE;
		else if(theColor.equalsIgnoreCase("yellow"))
			fColor = Color.YELLOW;
		else               
			fColor = Color.BLACK;        
	} 

}
