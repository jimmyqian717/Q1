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

class Patch {
    //...
    private char strat;
    private int score;
    
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
    
    // return score of this patch in current round
    double getScore() {
        //...
        return 0.0; // CHANGE THIS
    }
}
