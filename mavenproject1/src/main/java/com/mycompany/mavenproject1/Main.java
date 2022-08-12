/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Micha
 */
public class Main {
   public static Scanner inputReader = new Scanner(System.in);

   public static void main(String[] args) {
        
       boolean inSession = true;
       int computerWins = 0;
       int userWins = 0;
       int ties = 0;
       int rounds = numRounds();
       
       
       while (inSession = true){
            computerWins = 0;
            userWins = 0;
            ties = 0;
           for (int i = 1; i <= rounds; i++){
               System.out.println("Round: "+ i);
               String result = round();
               switch (result){
                   case "user": 
                       userWins++;
                       System.out.println("User win recieved");
                       break;
                   case "computer":
                       computerWins++;
                                              System.out.println("computer win recieved");

                       break;
                   case "tie":
                       ties++;
                                              System.out.println("tie recieved");

                       break;
                   case "":
                       i--;
                }
            }
           System.out.printf("Results after %d rounds \n%d wins for the user \n%d wins for the computer \n%d ties\n", rounds, userWins, computerWins, ties);
           System.out.println("Would you like to play again y/n?");
           String input = inputReader.nextLine();
           if (input == "y" || input == "n" ){
               if (input == "n"){
                   inSession = false;
                   break;
               }
               else{
                   rounds = numRounds();
               }
           }
           else{
               System.out.println("Error: Invalid input");
               break;
           }
        }
    }
   
   
   
   private static String round(){
       int input = 0;
       String result = "";
               Random rn = new Random();
               System.out.println("1 = Rock: 2 = Paper: 3 = Scissors");
               try {
                    input = Integer.parseInt(inputReader.nextLine());
                    int computerChoice = rn.nextInt(3-1)+1;
                
                     if (input == 1){
                        switch (computerChoice){
                            case 1:
                                System.out.println("Result = Draw");
                                result = "tie";
                                break;
                            case 2:                                                      
                                System.out.println("Result = Computer win");
                                result = "computer";
                                 break;
                            case 3:
                                System.out.println("Result = User win");
                                result = "user";
                                break;
                            }
                        }   
                    else if (input == 2){
                        switch (computerChoice){
                            case 1:
                                System.out.println("Result = User win");
                                result = "user";
                                break;
                            case 2:
                                System.out.println("Result = tie");
                                result = "tie";
                                break;
                            case 3:
                                System.out.println("Result = Computer win");
                                result = "computer";
                                break;
                            }
                        }
                    else if (input == 3){
                        switch (computerChoice){
                            case 1:
                                System.out.println("Result = Computer win");
                                result = "computer";
                                break;
                            case 2:
                                System.out.println("Result = User win");
                                result = "user";
                                break;
                            case 3:
                                System.out.println("Result = Tie");
                                result = "tie";
                                break;
                            }
                        }
                    else{
                        System.out.println("Error: Choice Not Made");
                        
                    }
                }
                catch(NumberFormatException e){
                    System.out.println("Error: Input Not Number");                 
                };
                
                return result;
   }
   private static int numRounds(){
        int rounds = 0;

       // number of game rounds
       System.out.println("How many rounds would you like to play?");
       try {
            rounds = Integer.parseInt(inputReader.nextLine());
       }
        catch(NumberFormatException e){
            System.out.println("Error: Input Not Number");                 
       };
         if (rounds > 10 || rounds <= 0){
               System.out.print("Error: Num must be between 0 and 10");
            }
         else {
             return rounds;
         }
       return 0;
   }
    
}


