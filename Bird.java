import java.util.*;

/** A Bird class that creates and deals with locations of different objects  
 * inside a cubic box
 * @auburn Zohar Le
 * @version 9/26/2021
 */   

public class Bird {
   private int x;
   private int y;
   private int z;
   private String name;
   
   private static Random rand = new Random();
   
   /** 
    * Construct an "unknown" default bird with location (1,1,1) 
    */
   public Bird () {
      this(1,1,1,"Unknown Bird");
   }
   /** Construct a bird with specific location and given name
    * @param x location of the bird in the x axis
    * @param y location of the bird in the y axis
    * @param z location of the bird in the z axis
    * @param name name of the bird
    */ 
   public Bird (int x, int y, int z, String name){
      this.x = x;
      this.y = y;
      this.z = z;
      this.name = name;
      if (this.x < 0){
         this.x += -this.x;      // if its negative add to its absolute value to get 0
      } else if (this.x > 10){
         this.x = this.x - ( this.x - 10); // if it is more than 10 then subject (x-10) to get 10
      }
      if (this.y < 0){
         this.y += -this.y;      // if its negative add to its absolute value to get 0
      } else if (this.y > 10){
         this.y = y - ( y - 10); // if it is more than 10 then subject (x-10) to get 10
      }
      if (this.z < 0){
         this.z += -this.z;      // if its negative add to its absolute value to get 0
      } else if (this.z > 10){
         this.z = this.z - ( this.z - 10); // if it is more than 10 then subject (x-10) to get 10
      }
      
   }
   /** Contruct a bird with a given name and random location
    * @param name given name of the bird
    */
   public Bird (String name){
      this.name = name;
      this.x = rand.nextInt(11);
      this.y = rand.nextInt(11);
      this.z = rand.nextInt(11);
         
   }
   /**
    * methhod get and return x location of the bird
    * @return the location of the bird in the x axis
   */
   public int getX(){
      return this.x;
   }
   /**
    * methhod get and return y location of the bird
    * @return the location of the bird in the y axis
   */

   public int getY(){
      return y;
   }
   /**
    * methhod get and return z location of the bird
    * @return the location of the bird in the z axis
   */

   public int getZ(){
      return z;
   }
   /** method get and return a String of the bird's name
    * @return the name of the bird as string
    */
   public String getName(){
      return name;
   }
   @Override
   public String toString(){
      return name + " is at " + x + ", " + y + ", " + z;
   }
   /** method compares the location of the birds and return a boolean
    * @param other a Bird object that is used to compare
    * @return return true if the location are identical, else return false
    */ 
   public boolean touching (Bird other){
      if (this.x == other.x && this.y == other.y && this.z == other.z) {
         return true;
      }
      else {
         return false;
      }
   } 
   /**
    * a method that moves the location of the bird in a random direction with 1 or 2 steps 
    */
   public void move () {        // create random object
      int dir = rand.nextInt(2);          // random a direction of an axis
      int axes = rand.nextInt(3);         // random an axes that get move
      int step = rand.nextInt(2) + 1;     // create a random number 1 or 2 to step in a random axis
      if (axes == 0){                     // if x axes
         if (dir == 0){                         // if positive direction
            this.x = this.x + step;
            if (this.x > 10){     // if out of range then undo move
               this.x = this.x - step;
               this.move();
            } 
         } else {                               // else negative direction
            this.x = this.x - step;
            if (this.x < 0){
               this.x = this.x + step;
               this.move();
            }
         }    
      } else if ( axes == 1) {            // if y axes
         if (dir == 0){                         // if positive direction
            this.y = this.y + step;   
            if (this.y > 10){
               this.y = this.y - step;
               this.move();
            }          
         } else {                               // else negative direction
            this.y = this.y - step;
            if (this.y < 0){
               this.y = this.y + step;
               move();
            }
         }
      } else {                            // if z axes
         if (dir == 0){                         // if positive direction
            this.z = this.z + step; 
            if ( this.z > 10){     
               this.z = this.z - step;
               move();
            }            
         } else {                               // else negative direction          
            this.z = this.z - step;
            if (this.z < 0){
               this.z = this.z + step;
               move();
            }                                  
         }
      } 
   }      
}