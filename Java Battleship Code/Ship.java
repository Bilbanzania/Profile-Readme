//*******************************************************************************************
//    Programmer: Mitchell Laypath        CSC110AB Programming Assignment 7
//    Date: May, 5th, 2020
//    Description:This creates the ship for the game to be used and determines the size.
//    Input:input is in int and boolean creating the ship.
//    Output: Output tells the main class what the size of the ship is and where it is 
//    located. 
//*******************************************************************************************
import java.util.*;

public class Ship
{
   private int sizeOfShip;
   private boolean location;
   
   //This creates the size of the ship.
   public Ship()
   {  
      int sizeNum;
      Random random = new Random();
      location = random.nextBoolean();
      sizeNum = random.nextInt(100);
      if(sizeNum > 0 && sizeNum < 21)
      {
         this.sizeOfShip = 2;
      }
      else if(sizeNum > 21 && sizeNum < 51)
      {
         this.sizeOfShip = 3;
      }
      else
      {
         sizeOfShip = 4;
      }
   }
   //This gets the point of the ship on the array.
   public int[] getExactLocation()
   {
      Random random = new Random();
      int[] exactLocation = new int[2];
      int c = random.nextInt(5) + 1;
      int r = random.nextInt(5) + 1;
      exactLocation[1] = c;
      exactLocation[0] = r;
      return exactLocation;
   }
   public boolean getLocationOfShip()
   {
      return location;
   }   
   public int getSize()
   {
      return sizeOfShip;
   }
}

      