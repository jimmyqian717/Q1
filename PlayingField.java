/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part PlayingField
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */
package prisonersdilemma;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;


class PlayingField extends JPanel implements ActionListener{
    // Creating grid with a border
    private Patch[][] grid = new Patch[52][52];
    
    private double alpha; // defection award factor
    
    private Timer timer;
    
    // random number genrator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random random = new Random( SEED );         
    
    //...
    int index;
    // random strat
    char[] strategies = new char[]{'C', 'D'};
    public void initialization(){  
        for (int x = 1; x < 51; x ++){
            for (int y = 1; y < 51; y ++){
                index = random.nextInt(2);
                //System.out.println(index);
                grid[x][y] = new Patch(strategies[index]);
                System.out.println(strategies[index]);
            }
        }
    }
    
    /**
     * calculate and execute one step in the simulation 
     */
    public void step( ) {
        //...
    }
    
    public void setAlpha( double alpha ) {
        //...
    }
    
    public double getAlpha( ) {
        //...
        return 0.0; // CHANGE THIS
    }
    
    // return grid as 2D array of booleans
    // true for cooperators, false for defectors
    // precondition: grid is rectangular, has non-zero size and elements are non-null
    public boolean[][] getGrid() {
        boolean[][] resultGrid = new boolean[grid.length][grid[0].length];
        for (int x = 1; x < grid.length - 1; x++ ) {
            for (int y = 1; y < grid[0].length - 1; y++ ) {
                resultGrid[x][y] = grid[x][y].isCooperating();
            }
        }
        
        return resultGrid; 
    }
    
    // sets grid according to parameter inGrid
    // a patch should become cooperating if the corresponding
    // item in inGrid is true
    public void setGrid( boolean[][] inGrid) {
        // ...
        // setCooperating()
        for (int x = 0; x < inGrid.length; x ++){
            for (int y = 0; y < inGrid[0].length; y ++){
                grid[x][y].setCooperating(inGrid[x][y]);
            }
        }
    }   
    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g);     // clears the panel
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Reset")){
            initialization();
        }
        else if (ae.getActionCommand().equals("Go")){
            
        }
        else if (ae.getActionCommand().equals("Pause")){
            
        }
    }
}

