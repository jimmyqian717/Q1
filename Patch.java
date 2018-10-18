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
    private double score = 0.0;
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
    
    double maxScore;
    // List of neighbours who have the highest score
    ArrayList<Patch> maxNeighbours = new ArrayList<>();
    // random number for a random element from maxNeighbours
    // in case of multiple neighbours with a tied high score
    Random n = new Random();
    int index;
    void changeStrategy(){
        maxScore = 0;
        for (Patch neighbour : this.neighbours){
            if (neighbour.score == maxScore){
                maxScore = neighbour.score;
                maxNeighbours.add(neighbour);
            }
            else if (neighbour.score > maxScore){
                maxScore = neighbour.score;
                // Not max in tie, therefore erase list
                // add the new neighbour to maxNeighbour
                maxNeighbours.clear();
                maxNeighbours.add(neighbour);
            }
            
        }
        // Check if its own score is higher than the max score in the neighbourhood
        // if they are equal, add itself to maxNeighbours
        if (maxScore < this.score) maxScore = this.score;
        else if (maxScore == this.score) maxNeighbours.add(this);
        index = n.nextInt(maxNeighbours.size());
        this.setStrat(maxNeighbours.get(index).getStrat());
    }
    
    void setScore(boolean isC, double score, double alpha){
        if (isC == true) this.score = score;
        else this.score = score * alpha;
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
            //System.out.println(neighbour.strat);
            if (neighbour.strat == 'C') counter ++;
        }
        return counter;
    }
    
    void setStrat(char strat){
        this.strat = strat;
    }
    // show this patch's current strat
    char getStrat(){
        return this.strat;
    }
}
