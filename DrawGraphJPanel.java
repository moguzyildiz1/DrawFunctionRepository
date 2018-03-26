/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functiongraph;

/**
 *
 * @author moguzyildiz
 */
import java.awt.*;
import javax.swing.JPanel;

public class DrawGraphJPanel extends JPanel{    
    
    public static final int A = 10;
    public static final int B = 50;
    public static final double C = .001;

    private GITFunction[] graphFunc;
    private int fNumber = 0;
    
    public DrawGraphJPanel(int tNumber)
    {
        graphFunc = new GITFunction[tNumber];
    }        
    
    public DrawGraphJPanel(int tNumber,GITFunction[] tFunc)
    {    
        graphFunc = tFunc;
        fNumber = tNumber;
    }
    
    public DrawGraphJPanel(DrawGraphJPanel otherPanel)
    {
        this.graphFunc = otherPanel.graphFunc;
    }        
    
    public GITFunction[] getFunction()
    {
        return graphFunc;
    }        
             
    public void paint(Graphics g)
    {
        super.paint(g);
        
        g.setColor(Color.BLACK);
        g.drawLine(getWidth()/2,0 ,getWidth()/2,getHeight());
        g.drawLine(getWidth()/2+1,0 ,getWidth()/2+1,getHeight());
        
        g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        g.drawLine(0, getHeight()/2+1, getWidth(), getHeight()/2+1);
        
        
        g.setColor(Color.CYAN);
        for(int i = 0 ; i <= getWidth(); i = i + A )
        {    
            g.drawLine(i,0,i, getHeight());
            if(i%50 == 0)
            {
                g.drawLine(i+1,0,i+1, getHeight());
            }
             
            g.drawLine(0, i, getWidth(),i );
            if(i%50 == 0)
            {
                g.drawLine(0, i+1, getWidth(),i+1 );
            } 
         }
        
        for(int i  = 0; i < fNumber; ++i)
        {     
            String name = graphFunc[i].getName();
            int min = graphFunc[i].getMin();
            int max = graphFunc[i].getMax();
            g.setColor(graphFunc[i].getColor());
            
            if(name.equalsIgnoreCase("sin(x)"))
            {  
               for(double a  = min; a <= max; a = a + C)
               {
                     g.drawLine((int)(getWidth ()/2 + B*a),
                                (int)(getHeight()/2 - B*Math.sin(a)),
                                (int) (getWidth()/2 + B*(a+C)),
                                (int)(getHeight()/2 - B*Math.sin(a+C)));
               }    
            }   

            else if(name.equalsIgnoreCase("x"))
            {    
               for(double a  = min; a <= max; a = a + C)
               {
                    g.drawLine((int)(getWidth()/2 + B*a),
                               (int)(getHeight()/2 - B*a),
                               (int)(getWidth()/2 + B*(a+C)),
                               (int)(getHeight()/2 - B*(a+C)));
               }   
            }

            else if(name.equalsIgnoreCase("log(x)"))
            {               
               for(double a  = min; a <= max; a = a + C)
               {
                    g.drawLine((int)(getWidth ()/2 + B*a),
                               (int)(getHeight()/2 - B*Math.log(a)),
                               (int)(getWidth()/2 + B*(a+C)),
                               (int)(getHeight()/2 - B*Math.log(a+C)));
               }
            } 

            else if(name.equalsIgnoreCase("x^(1/2)"))
            {
                for(double a  = min; a <= max; a = a + C)
               {
                    g.drawLine((int)(getWidth ()/2 + B*a),
                               (int)(getHeight()/2 - B*Math.sqrt(a)),
                               (int)(getWidth()/2 + B*(a+C)),
                               (int)(getHeight()/2 - B*Math.sqrt(a+C)));
               }
            }    

            else if(name.equalsIgnoreCase("x^2"))
            {
                for(double a  = min; a <= max; a = a + C)
               {
                   g.drawLine((int)(getWidth ()/2 + B*a),
                               (int)(getHeight()/2 - B*Math.pow(a, 2)),
                               (int)(getWidth()/2 + B*(a+C)),
                               (int)(getHeight()/2 - B*Math.pow(a+C,2)));
               }
            }

            else if(name.equalsIgnoreCase("cos(x)"))
            {
                for(double a  = min; a <= max; a = a + C)
               {
                   g.drawLine((int)(getWidth ()/2 + B*a),
                               (int)(getHeight()/2 - B*Math.cos(a)),
                               (int)(getWidth()/2 + B*(a+C)),
                               (int)(getHeight()/2 - B*Math.cos(a+C)));
               }
            }

            else if(name.equalsIgnoreCase("tan(x)"))
            {
               for(double a  = min; a <= max; a = a + C)
               {
                   g.drawLine((int)(getWidth ()/2 + B*a),
                               (int)(getHeight()/2 - B*Math.tan(a)),
                               (int)(getWidth()/2 + B*(a+C)),
                               (int)(getHeight()/2 - B*Math.tan(a+C)));
               }
            }    

            else if(name.equalsIgnoreCase("cot(x)"))
            {
               for(double a  = min; a <= max; a = a + C)
               {
                   g.drawLine((int)(getWidth ()/2 + B*a),
                               (int)(getHeight()/2 - B*(Math.cos(a)/Math.sin(a))),
                               (int)(getWidth()/2 + B*(a+C)),
                               (int)(getHeight()/2 - B*Math.cos(a+C)/Math.sin(a+C)));
               }
            } 
        }  
    }
}
