//*******************************************************************************************
//    Programmer: Mitchell Laypath        CSC110AB Programming Assignment 7
//    Date: May, 5th, 2020
//    Description:This class creates the grid for the game to be played on. 
//    Input: Is mostly int and some char/string. 
//    Output: Creates the grid for the game as an array. 
//*******************************************************************************************
import java.util.*;

public class Sea
{
   private int sizeOfSea = 0;
   private String[][] seaArray = new String[11][11];
   
   public Sea()
   {
      for (int c = 0; c < 11; c++)
      {
         for (int r = 0; r < 11; r++)
         {
            if (r == 0)
            {
               this.seaArray[r][c] = Integer.toString(c);
            }
            else if (c == 0)
            {
               this.seaArray[r][c] = Integer.toString(r);
            }
            else
            {
               this.seaArray[r][c] = ".";
            }
         }
      }
   }
   // Returns the array.
   public String[][] getSeaArray()
   {
      return seaArray;
   }
   // Returns the size for the array.
   public int getSize()
   {
      return sizeOfSea;
   }
   public void addBattleShip(Ship[] b)
   {
      char[] shipName = "ABCDEFGH".toCharArray();
      for (int q = 1; q < b.length; q++)
      {
         boolean putTogether = false;
         loop_while:
         while (!putTogether)
         {
            int[] exactLocation = b[q - 1].getExactLocation();
            int l = b[q - 1].getSize();
            boolean location = b[q - 1].getLocationOfShip();
            int r = exactLocation[0];
            int c = exactLocation[1];
            // This creates the horizontal portion of the sea.
            if (location == true)
            {
               for (int p = r; p < r + l; p++)
               {
                  if (seaArray[p][c] != ".")
                  {
                     continue loop_while;
                  }
               }
               for (int p = r; p < r + l; p++)
               {
                  seaArray[p][c] = Character.toString(shipName[q - 1]);
               }
            }
            // This creates the veritcal portion of the sea.
            else
            {
               for (int p = c; p < c + l; p++)
               {
                  if (seaArray[r][p] != ".")
                  {
                     continue loop_while;
                  }
               }
               for (int p = c; p < c + l; p++)
               {
                  seaArray[r][p] = Character.toString(shipName[q - 1]);
               }
            }
            putTogether = true;
         }
      }
   }
}