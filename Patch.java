/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * 
 * @author Jimmy Qian   
 * @author Kevin Tatar
 * assignment group 95
 * 
 * assignment copyright Kees Huizing
 */

import java.util.*;
class Patch { 
    //...
    private char strat;
    private double score = 0.0;
    ArrayList<Patch> neighbours = new ArrayList<>();
    Patch(char strat) {  
        this.strat = strat;
    }

    // returns true if and only if patch is cooperating
    boolean isCooperating() { 
        //...
        if (this.strat == 'C') { 
            return true;
        } else { 
            return false;
        }
    }
    
    // set strategy to C if isC is true and to D if false
    void setCooperating(boolean isC) { 
        if (isC == true) { 
            this.strat = 'C';
        } else { 
            this.strat = 'D';
        }
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
    void changeStrategy() {  
        for (Patch neighbour: this.neighbours) { 
            if (neighbour.score > maxScore) { 
                maxScore = neighbour.score;
                maxNeighbours.add(neighbour);
            } else if (neighbour.score == maxScore) { 
                maxNeighbours.add(neighbour);
            }
            if (this.score > maxScore) { 
                maxScore = this.score;
            } else if (this.score == maxScore) { 
                maxNeighbours.add(this);
            }
            index = n.nextInt(maxNeighbours.size());
            this.strat = maxNeighbours.get(index).getStrat();
        }
    }
    
    void setScore( double score) { 
        this.score = score;
    }
    
    // return score of this patch in current round
    double getScore() { 
        return this.score;
    }
    
    // add neighbours'strats to arraylist
    void setNeighbours(Patch neighbour) { 
        this.neighbours.add(neighbour);
    }
    
    // show neighbours'strats
    int counter = 0;
    int getNeighbours() { 
        for (Patch neighbour: neighbours) { 
            //System.out.println(neighbour.strat);
            if (neighbour.strat == 'C') { 
                counter++;
            }
        }
        //System.out.println("Cooperating neighbours: " + counter);
        return counter;
    }
    
    void setStrat(char strat) { 
        this.strat = strat;
    }
    
    // show this patch's current strat
    char getStrat() { 
        return this.strat;
    }
}
