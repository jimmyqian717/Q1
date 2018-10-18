/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * 
 * @author FILL IN
 * @author FILL IN
 * assignment group FILL IN
 * 
 * assignment copyright Kees Huizing
 */
package prisonersdilemma;

import java.util.*;
class Patch {
    //...
    private char strat;
    private int score = 0;
    ArrayList<Patch> neighbours = new ArrayList<>();
    Patch(char strat){
        this.strat = strat;
    }

    // returns true if and only if patch is cooperating
    boolean isCooperating() {
        //...
        if (this.strat == 'C') return true;
        return false; // CHANGE THIS
    }
    
    // set strategy to C if isC is true and to D if false
    void setCooperating(boolean isC) {
        //...
        if (isC == true) this.strat = 'C';
        else this.strat = 'D';
    }
    
    // change strategy from C to D and vice versa
    void toggleStrategy() {
        // ...
    }
    
    void setScore(int score){
        this.score = score;
    }
    // return score of this patch in current round
    double getScore() {
        //...
        
        return this.score;
    }
    
    // add neighbours'strats to arraylist
    void setNeighbours(Patch neighbour){
        this.neighbours.add(neighbour);
    }
    
    // show neighbours'strats
    int counter = 0;
    int getNeighbours(){
        for (Patch neighbour: neighbours){
            System.out.println(neighbour.strat);
            if (neighbour.strat == 'C') counter ++;
        }
        return counter;
    }
    
    // show this patch's current strat
    char getStrat(){
        return this.strat;
    }
}
