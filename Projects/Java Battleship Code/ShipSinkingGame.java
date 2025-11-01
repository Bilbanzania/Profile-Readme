//*******************************************************************************************
//    Programmer: Mitchell Laypath        CSC110AB Programming Assignment 7
//    Date: May, 5th, 2020
//    Description: This is a game of battle ships where you face the computer at sea.
//    it will start by welcoming and asking the user what kind of game they want to play.
//    They can also quit at the menu as well if they change their mind.
//    Input: Input will require the user to enter string which is converted so the array can 
//    tell where they placed their strike.
//    Output: Game will let user know if they hit or miss. It will also let them know if the
//    ship was destroyed or not. input/output is string, char and int. 
//*******************************************************************************************
import java.util.*;

public class ShipSinkingGame
{
   final static int amountOfShips = 8;
   // Main. Starts with a welcome message and starts the game by calling on startBattle or cheaterGame. You can quit as well.
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.println("Welcome to the Ship Sinking Game");
      System.out.print("Do you want play mode? (N = cheat mode): ");
      char userResponse = kb.next().charAt(0);
      if (userResponse == 'y')
      {
         System.out.println("OK - We're in PLAY mode. Enjoy...");
         System.out.println("===========================================================");
         startBattle();
      }
      else if (userResponse == 'Y')
      {
         System.out.println("OK - We're in PLAY mode. Enjoy...");
         System.out.println("===========================================================");
         startBattle();
      }
      else if (userResponse == 'n')
      {
         System.out.println("OK - We're in CHEAT mode. Enjoy...");
         System.out.println("===========================================================");
         cheaterGame();
      }
      else if (userResponse == 'N')
      {
         System.out.println("OK - We're in CHEAT mode. Enjoy...");
         System.out.println("===========================================================");
         cheaterGame();
      }
      if (userResponse == 'q')
      {
         System.out.println("===========================================================");
         System.out.println("Quitting early! 0 shots were used. "); 
      }
      else if (userResponse == 'Q')
      {
         System.out.println("===========================================================");
         System.out.println("Quitting early! 0 shots were used. "); 
      }
   }
   
   public static void printSea(String[][] seaPrint)
   {
      for (int r = 0; r < 10; r++)
      {
         for (int c = 0; c < 10; c++)
         {
            System.out.print(seaPrint[r][c]);
         }
         System.out.println(" ");
      }
   }
   public static String[][] startBattleGrid()
   {
      String[][] string = new String[11][11];
      for (int r = 0; r < 11; r++)
      {
         for (int c = 0; c < 11; c++)
         {
            if (r == 0)
            {
               string[r][c] = Integer.toString(c);
            }
            else if (c == 0)
            {
               string[r][c] = Integer.toString(r);
            }
            else
            {
               string[r][c] = ".";
            }
         }
      }
      return string;
   }
   // regular game.
   public static void startBattle()
   {
      Ship[] battleShips = new Ship[amountOfShips];
      for (int p = 0; p < amountOfShips; p++)
      {
         battleShips[p] = new Ship();
      }
      Sea seaArray = new Sea();
      seaArray.addBattleShip(battleShips);
      String userGuess;
      int c = 0;
      int r = 0;
      int shotMiss = 0;
      int shotConfirmed = 0;
      int sizeOfShip;
      int shotTotal = (shotConfirmed + shotMiss);
      sizeOfShip = seaArray.getSize();
      Scanner kb = new Scanner(System.in);
      String[][] shipArray = seaArray.getSeaArray();
      String[][] gameArray = startBattleGrid();
      
      while (true)
      {
         printSea(gameArray);
         System.out.print("Enter a coordinate(0..9) for target: ");
         userGuess = kb.next();
             
         if (Integer.parseInt(userGuess) < 0)
         {
            System.out.print("Again: Enter a coordinate(0..9) for target: ");
            userGuess = kb.next();
         }
         else if (Integer.parseInt(userGuess) > 9)
         { 
            System.out.print("Again: Enter a coordinate(0..9) for target: ");
            userGuess = kb.next();
         }      
         else if (userGuess.charAt(0) == 'q')
         {
            System.out.println("Quitting early! " + shotTotal + " shots were used. "); 
            break;
         }     
         else if (userGuess.charAt(0) == 'Q')
         {
            System.out.println("Quitting early! " + shotTotal + " shots were used. "); 
            break;
         }
         else
         {
            r = Integer.parseInt(userGuess);
         }
         
         System.out.print("Enter a coordinate(0..9) for target: ");
         userGuess = kb.next();
         if (Integer.parseInt(userGuess) < 0)
         {
            System.out.print("Again: Enter a coordinate(0..9) for target: ");
            userGuess = kb.next();
         }
         else if (Integer.parseInt(userGuess) > 9)
         { 
            System.out.print("Again: Enter a coordinate(0..9) for target: ");
            userGuess = kb.next();
         }
         else if (userGuess.charAt(0) == 'q')
         {
            System.out.println("Quitting early! " + shotTotal + " shots were used. "); 
            break;
         }     
         else if (userGuess.charAt(0) == 'Q')
         {
            System.out.println("Quitting early! " + shotTotal + " shots were used. "); 
            break;
         }
         else
         {
            c = Integer.parseInt(userGuess);
         }

         if (shipArray[r][c] != ".")
         {
            shotConfirmed++;
            System.out.println("===> Ship B hit " + shotConfirmed + " times.");
            System.out.println("     Good shot! A ship was hit.");
            sizeOfShip--;
            gameArray[r][c] = "*";
         }
         else
         {
            System.out.println("     No ships were hit.");
            shotMiss++;
            gameArray[r][c] = "X";
         }
         if (sizeOfShip <= 0)
         {
            System.out.println("Congrats! A ship was destroyed ");
         }
         if (shotMiss >= 12)
         {
            System.out.println("Sorry, you have accumulated 12 misses out of " + (shotConfirmed + shotMiss) + " shots: You lost!");
            break;
         }
      }
   }
   
      
   public static void cheaterGame()
   {
      Ship[] battleShips = new Ship[amountOfShips];
      for (int p = 0; p < amountOfShips; p++)
      {
         battleShips[p] = new Ship();
      }
      Sea seaArray = new Sea();
      seaArray.addBattleShip(battleShips);
      String userGuess;
      int c = 0;
      int r = 0;
      int shotMiss = 0;
      int shotConfirmed = 0;
      int sizeOfShip; 
      int shotTotal = (shotConfirmed + shotMiss);
      sizeOfShip = seaArray.getSize();
      Scanner kb = new Scanner(System.in);
      String[][] shipArray = seaArray.getSeaArray();
      String[][] gameArray = startBattleGrid();
      
      while (true)
      {
         printSea(shipArray);
         System.out.print("Enter a coordinate(0..9) for target: ");
         userGuess = kb.next();
                 
         if (Integer.parseInt(userGuess) < 0)
         {
            System.out.print("Again: Enter a coordinate(0..9) for target: ");
            userGuess = kb.next();
         }
         else if (Integer.parseInt(userGuess) > 9)
         { 
            System.out.print("Again: Enter a coordinate(0..9) for target: ");
            userGuess = kb.next();
         }      
         else if (userGuess.charAt(0) == 'q')
         {
            System.out.println("Quitting early! " + shotTotal + " shots were used. "); 
            break;
         }     
         else if (userGuess.charAt(0) == 'Q')
         {
            System.out.println("Quitting early! " + shotTotal + " shots were used. "); 
            break;
         }
         else
         {
            r = Integer.parseInt(userGuess);
         }
         
         System.out.print("Enter a coordinate(0..9) for target: ");
         userGuess = kb.next();
         
         if (Integer.parseInt(userGuess) < 0)
         {
            System.out.print("Again: Enter a coordinate(0..9) for target: ");
            userGuess = kb.next();
         }
         else if (Integer.parseInt(userGuess) > 9)
         { 
            System.out.print("Again: Enter a coordinate(0..9) for target: ");
            userGuess = kb.next();
         }
         else if (userGuess.charAt(0) == 'q')
         {
            System.out.println("Quitting early! " + shotTotal + " shots were used. "); 
            break;
         }     
         else if (userGuess.charAt(0) == 'Q')
         {
            System.out.println("Quitting early! " + shotTotal + " shots were used. "); 
            break;
         }
         else
         {
            c = Integer.parseInt(userGuess);
         }

         if (shipArray[r][c] != ".")
         {
            shotConfirmed++;
            sizeOfShip--;
            System.out.println("===> Ship C hit " + shotConfirmed + " times.");
            System.out.println("     Good shot! A ship was hit.");
            gameArray[r][c] = "*";
         }
         else
         {
            shotMiss++;
            System.out.println("     No ships were hit.");
            gameArray[r][c] = "X";
         }
         if (sizeOfShip <= 0)
         {
            System.out.println("Congrats! A ship was destroyed ");
         }
         if (shotMiss >= 12)
         {
            System.out.println("Sorry, you have accumulated 12 misses out of " + (shotConfirmed + shotMiss) + " shots: You lost!");
            break;
         }
      }
   }
}