package com.example.Objects;

// example
// Dog.getCountOfDogsMade() <- this was a static method
// rosie.bark() <- this is a non static method
// the only difference is that static is on the class


import java.util.Objects;

public class TicTacToe {

    String name;

    public TicTacToe(String name) {
        this.name = name;
    }

    public char[][] getANewBoard() {
        char[][] mainBoard = new char[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                mainBoard[i][j] = ' ';
            }
        }
        return mainBoard;
    }


    public String checkHorizontals(char[][] board, int rows, int cols) {
        for(int i = 0; i < rows; i++ ) {
            // check x's in board[i] array

            boolean isXwinner = true;
            for(int j = 0; j < cols; j++) {
                if(board[i][j] != 'X') {
                    isXwinner = false;
                }
            }

            boolean isOwinner = true;
            for(int j = 0; j < cols; j++) {
                if(board[i][j] != 'O') {
                    isOwinner = false;
                }
            }

            if(isXwinner) {return "X wins";}
            if(isOwinner) {return "O wins";}


        }

        return "-1";
    }

    public String checkDiagonals(char[][] board){
        if ((board[0][0] == 'X' && board[1][1] == 'X' && board [2][2] =='X') || board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'){

            return "X WINS";
        }
        if ((board[0][0] == 'O' && board[1][1] == 'O' && board [2][2] =='O') || board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'){
            return "O WINS";
        }
        return "-1";
    }

    public String checkVerticals(char[][] board, int rows, int cols) {
        for(int i = 0; i < cols; i++) {

            boolean isXwinner = true;

            for(int j = 0; j < rows; j++) {
                if(board[j][i] != 'X') {
                    isXwinner = false;
                }
            }

            if(isXwinner) {return "X wins";}

            boolean isOwinner = true;
            for(int j = 0; j < rows; j++) {
                if(board[j][i] != 'O') {
                    isOwinner = false;
                }
            }

            if(isOwinner) {return "O wins";}


            // i = 0

            // check does rows 0-2 make X a winner
            // check does rows 0-2 make O a winner

            // i = 1
            // check does rows 0-2 make X a winner
            // check does rows 0-2 make O a winner

            // i = 2
            // check does rows 0-2 make X a winner
            // check does rows 0-2 make O a winner
        }
        return "-1";
    }

    // return 'X' or 'O' or mid-game 'mid-game ' or 'draw'
    public String checkWinner(char[][] board) {


        int rows = board.length;
        int cols = board[0].length;
        String horizontalCheck = checkHorizontals(board, rows, cols);

        if(horizontalCheck == null) {
            return "FAILURE";
        }

        if(!horizontalCheck.equals( "-1")) {
            return horizontalCheck;
        }

        String verticalCheck = checkVerticals(board, rows, cols);

        if(verticalCheck == null) {
            return "FAILURE";
        }

        if(!verticalCheck.equals("-1")) {
            return verticalCheck;
        }


        String diagonalCheck = checkDiagonals(board);

        if(diagonalCheck != "-1"){
            return diagonalCheck;
        }


        // check diagnols if none are winner it is a draw


        if(isThereAnEmptySpot(board)) {
            return "mid-game";
        }


        return "draw";
    }


    public static void main (String[] args){
        TicTacToe ticTacToe = new TicTacToe("Jason");
        char[][] game1 = ticTacToe.getANewBoard();

        ticTacToe.setX(game1, 0, 0);
        ticTacToe.setX(game1, 0, 1);
        ticTacToe.setX(game1, 0, 2);
        ticTacToe.setO(game1, 1,0);
        ticTacToe.setO(game1, 1,1);
        ticTacToe.setO(game1, 1,2);
        ticTacToe.printBoard(game1);

        String winner = ticTacToe.checkWinner(game1);
        System.out.println(winner);
        char[][] game2 = ticTacToe.getANewBoard();


    }
    public void printBoard(char[][] mainBoard){
        System.out.println("-------------");
        for (int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(mainBoard[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    // isEmptyAt(row = 0 , col = 1) ==> board[row][col] ==> board[0][1]
    public boolean isEmptyAt(char[][] mainBoard, int row, int col){
        return mainBoard[row][col] == ' ';
    }



    public boolean isSpotX(char[][] mainBoard, int row, int col){
        return mainBoard[row][col] == 'X';
    }



    public boolean isSpotO(char[][] mainBoard, int row, int col){
        return mainBoard[row][col] == 'O';
    }

    public void setX(char[][] mainBoard, int row, int col){
        if (isEmptyAt (mainBoard, row, col)){
           mainBoard[row][col] = 'X';
        }
    }
    public void setO(char[][] mainBoard, int row, int col){
        if (isEmptyAt (mainBoard, row, col)){
            mainBoard[row][col] = 'O';
        }
    }

    public boolean isThereAnEmptySpot(char[][] mainBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mainBoard[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }
}