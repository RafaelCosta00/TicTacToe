package com.company;

public class TicTacToe {
    private char[][] ticTacToe;

    //initialize 2D array and give values 1 to 9 that will be reference to user input
    public TicTacToe() {
        ticTacToe = new char[][]
                {
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'}
                };
    }
    //method move to add position row and column(x , y) and mark as player 1 'O' or player 2 'X'
    public boolean move(int x, int y, char mark){
        //if checks if position was already used
        if(ticTacToe[x][y] == 'X' || ticTacToe[x][y] == 'O'){
            System.out.println("Invalid position");
            return false;
        //if valid add mark to 2D array
        }else{
            ticTacToe[x][y] = mark;
            return true;
        }
    }
    //method to check for winner based on tictactoe rules
    public boolean winner(){
        //variables to check for 3 sequence
        char tempChar1 = 'a';
        char tempChar2 = 'b';
        char tempChar3 = 'c';

        //checks for same row. Assign each value of the columns to variables
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(col == 0) {
                    tempChar1 = ticTacToe[row][col];
                }else if(col == 1){
                    tempChar2 = ticTacToe[row][col];
                }else if(col == 2){
                    tempChar3 = ticTacToe[row][col];
                }
                //checks if the 3 variables of the columns are the same if so return for winner
                if(tempChar1 == tempChar2 && tempChar2 == tempChar3){
                    System.out.println("WINNER!!");
                    return true;
                }
            }
        }

        //check for same column. Assign each value of the rows to variables
        for(int col = 0; col < 3; col++){
            for(int row = 0; row < 3; row++){
                if(row == 0) {
                    tempChar1 = ticTacToe[row][col];
                }else if(row == 1){
                    tempChar2 = ticTacToe[row][col];
                }else if(row == 2){
                    tempChar3 = ticTacToe[row][col];
                }
                //checks if the 3 variables of each row are the same
                if(tempChar1 == tempChar2 && tempChar2 == tempChar3){
                    System.out.println("WINNER!!");
                    return true;
                }
            }
        }
            //check for values in 2D array diagonal starting at 0,0
            if(ticTacToe[0][0] == ticTacToe[1][1] && ticTacToe[1][1] == ticTacToe[2][2]){
                System.out.println("WINNER!!");
                return true;
                //check for values in 2D array diagonal starting at 0, 2
            }else if(ticTacToe[0][2] == ticTacToe[1][1] && ticTacToe[1][1] == ticTacToe[2][0]){
                System.out.println("WINNER!!");
                return true;
            }
            //if no winner return false
            return false;
        }
    //method to display 2D array
    public void display(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                System.out.print(ticTacToe[row][col] + "\t");
            }
            System.out.println();
        }
    }
    //method to reset 2D array to 1 to 9 values
    public void reset(){
        this.ticTacToe = new char[][]
                {
                        {'1','2','3'},
                        {'4','5','6'},
                        {'7','8','9'}
                };
        System.out.println("Game reset.");
    }
}
