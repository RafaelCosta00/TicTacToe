/*
CCSF Class 111B
Student Rafael Ferreira Costa
Created on 07/07/2018

Project
Question 3
Tic-Tac-Toe
 */

package com.company;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //creates tictactoe object
        TicTacToe ticTacToe = new TicTacToe();

        //boolean to quit program
        boolean quit = true;

        //boolean to check user move if valid or move already done
        boolean valid_input = false;

        //count for player turn/move
        int player = 1;

        //do/while to display menu/display game/reset/make a move/and quit
        do{

            System.out.println();
            //displays menu
            menu();
            //collects user input
            System.out.print("Choice: ");
            int input = scanner.nextInt();

            //choice 1 for display game
            if(input == 1){
                ticTacToe.display();
            //choice 2 to make a move
            }else if(input == 2){
                //set symbol for player 1
                char symbol = 'X';
                //checks if player 2 turn
                if(player%2 == 0){
                    //checks if user choice is valid
                    while(!valid_input){
                        System.out.println("Player 2 move.");
                        //collects user choice and return it as valid input to 2D array
                        int[] user_position = position();
                        //set symbol for player 2 'O'
                        symbol = 'O';
                        //if checks if input hasn't been used already. Calls method to make the move.
                        if(ticTacToe.move(user_position[0], user_position[1], symbol)){
                            //count increment so next round is other player
                            player += 1;
                            //if checks for winner
                            if(ticTacToe.winner()){
                                System.out.println("Player 2 won!");
                                System.out.println("Total moves: " + player);
                            }
                            //breaks while if all is right
                            valid_input = true;
                        }
                    }
                //players 1 round
                }else{
                    //while user input isn't valid
                    while(!valid_input){
                        System.out.println("Player 1 move.");
                        //collects user choice and return it as valid input to 2D array
                        int[] user_position = position();
                        //if checks if input hasn't been used already. Calls method to make the move.
                        if(ticTacToe.move(user_position[0], user_position[1], symbol)){
                            //count increment so next round is other player
                            player += 1;
                            //if checks for winner
                            if(ticTacToe.winner()){
                                System.out.println("Player 1 won!");
                                System.out.println("Total moves: " + player);
                            }
                            //breaks while if all is right
                            valid_input = true;
                        }
                    }
                }
            //choice 3 to reset game
            }else if(input == 3){
                ticTacToe.reset();
            //choice 4 to quit game
            }else if(input == 4){
                quit = false;
            //if anything but 1, 2, 3, 4 is typed by user.
            }else{
                System.out.print("Invalid choice try again.");
            }
            //reset condition to check if user input for move is valid.
            valid_input = false;
        }while(quit);

    }
    //method to display menu
    public static void menu(){
        System.out.println("1 - display" +
                "\n2 - add a move (1 to 9)" +
                "\n3 - reset" +
                "\n4 - quit");
    }

    //method to colllect user input from 1 to 9 and convert the value to array so it can be used in the 2D array game
    public static int[] position(){
        //array to store position row and column for 2D array
        int[] position = new int[2];
        //collects position 1 to 9
        System.out.print("Enter position: ");
        //condition while user input is not 1 to 0
        boolean condition = true;
        //convert position 1 to 9 for entrance for 2D array row and column
        while(condition){
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    position[0] = 0;
                    position[1] = 0;
                    condition = false;
                    break;
                case 2:
                    position[0] = 0;
                    position[1] = 1;
                    condition = false;
                    break;
                case 3:
                    position[0] = 0;
                    position[1] = 2;
                    condition = false;
                    break;
                case 4:
                    position[0] = 1;
                    position[1] = 0;
                    condition = false;
                    break;
                case 5:
                    position[0] = 1;
                    position[1] = 1;
                    condition = false;
                    break;
                case 6:
                    position[0] = 1;
                    position[1] = 2;
                    condition = false;
                    break;
                case 7:
                    position[0] = 2;
                    position[1] = 0;
                    condition = false;
                    break;
                case 8:
                    position[0] = 2;
                    position[1] = 1;
                    condition = false;
                    break;
                case 9:
                    position[0] = 2;
                    position[1] = 2;
                    condition = false;
                    break;
                default:
                    System.out.print("Not a valid choice." +
                            "\nTry again: ");
            }

        }
        return position;
    }
}
