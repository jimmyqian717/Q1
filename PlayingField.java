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
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


class PlayingField extends JPanel implements ActionListener{
    // Creating grid with a border
    // border + 50 cells + border
    private int SIZE = 52;
    private Patch[][] grid = new Patch[SIZE][SIZE];
    
    private double alpha = 0.5; // defection award factor
    
    private Timer timer;
    
    // random number genrator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random random = new Random( SEED );         

    //Initializing patches with random strategies
    int index;
    char[] strategies = new char[]{'C', 'D'};
    public void reinitialize(){  
        for (int x = 0; x < SIZE; x ++){
            for (int y = 0; y < SIZE; y ++){
                // selecting random strategy to begin with
                index = random.nextInt(2);
                grid[x][y] = new Patch(strategies[index]);
            }
        }
        setBorder();
    }
    
    int yCoord, xCoord;
    boolean[][] currGrid;
    // size of a patch
    int rectSize = 10;
    Color color;
    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g);     // clears the panel
        // paint the grid
        currGrid = getGrid();
        for (int x = 0; x < SIZE; x ++){
            for (int y = 0; y < SIZE; y ++){
                xCoord = x * rectSize;
                yCoord = y * rectSize;
                if (x == 0 || y == 0 || x == 51 || y == 51){
                    color = color.BLACK;                   
                }
               else{
                    if (currGrid[x][y] == true) color = Color.BLUE;
                    else if (currGrid[x][y] == false) color = color.RED;
                }
                g.setColor(color);
                g.fillRect(xCoord, yCoord, rectSize, rectSize);
            }
        }
        
    }
    
    // warp/ connect the edges
    public void setBorder(){
        for (int x = 0; x < SIZE; x ++){
            grid[x][0] = grid[x][SIZE - 2];
        }
        for (int y = 0; y < SIZE; y ++){
            grid[0][y] = grid[SIZE - 2][y];
        }
        grid[0][0] = grid[SIZE - 2][SIZE -2];
        grid[0][SIZE - 1] = grid[SIZE - 2][1];
        grid[SIZE - 1][0] = grid[1][SIZE - 2];
        grid[SIZE - 1][SIZE - 1] = grid[1][1];
    }
    /**
     * calculate and execute one step in the simulation 
     */
    public void step( ) {
        //...
        for (int x = 1; x < SIZE - 1; x ++){
            for (int y = 1; y < SIZE - 1; y ++){
                addNeighbours(x,y);
            }
        }
        calculateScore();
        for (int x = 1; x < SIZE - 1; x ++){
            for (int y = 1; y < SIZE - 1; y ++){
                grid[x][y].changeStrategy();
            }
        }
        revalidate();
        repaint();
    }

    
    public void setAlpha( double alpha ) {
        //...
        this.alpha = alpha;
    }
    
    public double getAlpha( ) {
        //...
        return this.alpha; // CHANGE THIS
    }
    
    // return grid as 2D array of booleans
    // true for cooperators, false for defectors
    // precondition: grid is rectangular, has non-zero size and elements are non-null
    // Converting from stategy either 'C' or 'D' to True or False
    public boolean[][] getGrid() {
        boolean[][] resultGrid = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[0].length; y++ ) {
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
    
    // iterate through near by patches (neighbours)
    //startegy of the current iterating player
    Patch neighbour;
    public void addNeighbours(int x, int y){
        for (int i= x - 1; i < x + 2; i ++){
            for (int j = y - 1; j < y + 2; j ++){
                if (i == x && j == y){
                    continue;
                }
                else{
                    neighbour = grid[i][j];
                    grid[x][y].setNeighbours(neighbour);
                }
            }
        }
    }
    
    // calculate score of the current round for each individual player
    Patch currPlayer;
    public void calculateScore(){
        for (int x = 1; x < SIZE; x ++){
            for (int y = 1; y < SIZE; y ++){
                currPlayer = grid[x][y];
                currPlayer.setScore(currPlayer.isCooperating(),currPlayer.getNeighbours(),getAlpha());
                System.out.println("x: " + x + ", y: " + y + ", Score: " + grid[x][y].getScore());
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Reset":
                System.out.println("Reset");
                reinitialize();
                repaint();
                break;
            case "Go":
                System.out.println("Go");
                step();

                break;
            case "Pause":
                System.out.println("Pause");
                break;
            default:
                break;
        }
        if (ae.getSource() == timer){
            System.out.println("1 s passed");
            
        }
    }
}

