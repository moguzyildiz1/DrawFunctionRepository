/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
