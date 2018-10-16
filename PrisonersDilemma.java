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
            frame = new JFrame("Prisoner's dilemma");
            mainPanel = new JPanel();
            resetBtn = new JButton("Reset");
            goBtn = new JButton("Go");
            resetBtn.addActionListener(new PlayingField());
            goBtn.addActionListener(new PlayingField());
            mainPanel.setLayout(new GridLayout(52,52));
            //Initializing original grid
            initialization();
            // Storing boolean values of each grid element
            currGrid = getGrid();
            // CHANGE TO METHOD PAINT
            // Creating blocks of patches and assign colors depending on their strat
            for (int x = 0; x < currGrid.length; x ++){
                for (int y = 0; y < currGrid[0].length; y ++ ){                    
                    lbl = new JLabel();
                    if (currGrid[x][y] == true) color = Color.BLUE;
                    else color = Color.RED;;
                    lbl.setBackground(color);
                    mainPanel.add(lbl);
                    lbl.setOpaque(true);
                    lbl.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
                }
            }
            // Arranging components in the frame
            frame.add(resetBtn, BorderLayout.NORTH);
            frame.add(goBtn, BorderLayout.SOUTH);
            frame.add(mainPanel);
            // Size of the window
            frame.setPreferredSize(new Dimension(1500, 1000));
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
