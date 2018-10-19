/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 * 
 * @author Jimmy Qian   
 * @author Kevin Tatar
 * assignment group 95
 * 
 * assignment copyright Kees Huizing
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.event.*;
//...

class PrisonersDilemma extends PlayingField {  
    //...
    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JButton resetBtn;
    JButton goBtn;
    JSlider alphaSlider;
    PlayingField field;
    Timer timer;
    JLabel alphaDisplayer;
    GridLayout layout1 = new GridLayout(1, 2);
    GridLayout layout2 = new GridLayout(2, 1);

    boolean[][] currGrid;
    void buildGUI() { 
        SwingUtilities.invokeLater( () -> { 
            //...
            //initializing new grid object
            field = new PlayingField();
            frame = new JFrame("Prisoner's Dilemma");
            frame.add(field, BorderLayout.CENTER);
            
            //buttons
            goBtn = new JButton("Go");
            goBtn.addActionListener(field);
            
            resetBtn = new JButton("Reset");
            resetBtn.addActionListener(field);
            
            //slider
            alphaSlider = new JSlider(JSlider.HORIZONTAL, minAlpha, maxAlpha, initAlpha);
            alphaDisplayer = new JLabel("1.0");
            alphaDisplayer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            
            //creating major ticks with 0.1 spacing
            alphaSlider.setMajorTickSpacing(1);
            alphaSlider.setPaintTicks(true);          
            alphaSlider.addChangeListener(new ChangeListener() { 
                @Override public void stateChanged(ChangeEvent e) { 
                    String alphaText;
                    JSlider src = (JSlider) e.getSource();
                    if (src.getValueIsAdjusting()) {
                        // setting modified alpha values
                        field.setAlpha((double) src.getValue() / 10);
                        alphaText = Double.toString((double) src.getValue() / 10);
                        alphaDisplayer.setText(alphaText);
                    }
                }
            });
            
            //panels
            panel1 = new JPanel();
            panel1.setLayout(layout1);
            panel1.add(goBtn);
            panel1.add(resetBtn);
            frame.add(panel1, BorderLayout.NORTH);
            
            panel2 = new JPanel();
            panel2.setLayout(layout2);
            panel2.add(alphaDisplayer);
            alphaDisplayer.setHorizontalAlignment(JLabel.CENTER);
            panel2.add(alphaSlider, BorderLayout.CENTER);
            frame.add(panel2, BorderLayout.SOUTH);
             
            
            frame.pack();
            field.reinitialize(); // can be done here since painting has a size!
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } );
    }
    
    //...
    
    public static void main( String[] a ) { 
        (new PrisonersDilemma()).buildGUI();
    }
}
