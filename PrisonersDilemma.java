/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * main class
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */
package prisonersdilemma;
import java.awt.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
//...

class PrisonersDilemma extends PlayingField{
    //...
    JFrame frame;
    JPanel mainPanel;
    JButton resetBtn;
    JButton goBtn;
    JLabel lbl;
    Color color;
    boolean [][] currGrid;
    void buildGUI() {
        SwingUtilities.invokeLater( () -> {
            //...
            //initializing new grid object
            PlayingField field = new PlayingField();
            field.reinitialize();
            frame = new JFrame("Prisoner's dilemma");
            mainPanel = new JPanel();
            resetBtn = new JButton("Reset");
            goBtn = new JButton("Go");
            // Arranging components in the frame
            frame.add(resetBtn, BorderLayout.NORTH);
            resetBtn.addActionListener(field);
            frame.add(goBtn, BorderLayout.SOUTH);
            goBtn.addActionListener(field);
            frame.add(mainPanel);
            frame.add(field);
            // Size of the window
            frame.setPreferredSize(new Dimension(800, 890));
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } );
    }
    //...
    
    public static void main( String[] a ) {
        (new PrisonersDilemma()).buildGUI();
    }
}
