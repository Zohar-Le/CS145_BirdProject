import java.util.*;
/** this class is a main class used to run and test the Bird class
 * @authur Zohar Le
 * @version 27/9/2021
 */

public class BirdMainClass {
   /** The main method to start and execute the code.
    * @param args Array of String "options" from the OS
    */
   public static void main (String []args){
      Random rand = new Random();
      int numBird = 6;
      Bird[] bird = new Bird[6];                         // an array holds 6 birds
      bird[0] = new Bird(1,2,9,"Yasuo");                 // create birds
      bird[1] = new Bird(2,3,3,"Yone");
      bird[2] = new Bird(3,4,7,"Viktor");
      bird[3] = new Bird("Random1");
      bird[4] = new Bird("Random2");
      bird[5] = new Bird();
      int fightCounter = 0;                              // create fight counter and round counter
      int roundCounter = 0; 
      System.out.println("*** Beginning of program ***"); 
      
      for (int i = 0; i < 6; i++){                       // print out the starting location and name of each bird
         System.out.println(bird[i]);
      }
      System.out.println("[####################################]");
      while (fightCounter < 5){                          // loop that stops when we have reached 5 fights
         roundCounter++;
         System.out.println("Round " + roundCounter);    
         for (int i = 0; i < 6; i++){                    // move each bird randomly
            bird[i].move();
         }
         for (int i = 0; i < 6; i++){                    // print out the location and name of each bird
            for (int j = 5; j > i; j--){ 
               if (bird[i].touching(bird[j])){
                  System.out.println("FIGHT : " + bird[i].getName() + " vs " + bird[j].getName());
                  fightCounter++;
               }
            }
         }
         for (int i = 0; i < 6; i++){                    // print out the location and name of each bird
            System.out.println(bird[i]);
         }
         System.out.println("[####################################]");
      }
      System.out.println("There was a total of " + roundCounter + " rounds to get to " + fightCounter + " fights");
   }
}