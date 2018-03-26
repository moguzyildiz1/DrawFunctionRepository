/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functiongraph;

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
