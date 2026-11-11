package com.example.Objects;

public class TicTacToe {



    public static void main (String[] args){
        char[][] mainBoard = new char[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                mainBoard[i][j] = ' ';
            }
        }
        printBoard(mainBoard);

    }
    public static void printBoard(char[][] mainBoard){
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

    public boolean isBoardEmpty(char[][] mainBoard) {
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