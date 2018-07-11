package com.gui;

import com.functiongraph.DGUserInterface;
import com.functiongraph.DrawGraphJFrame;

/**
 * @author moguzyildiz
 */
public class DGGUI implements DGUserInterface {
	public void processCommands()
	{
		DrawGraphJFrame gui = new DrawGraphJFrame();
		gui.setVisible(true);
	}
}
