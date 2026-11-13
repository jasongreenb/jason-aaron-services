package com.example;
import java.util.Scanner;


public class BerrySimulation {
    String name;
    public BerrySimulation(String name){
        this.name = name;
    }


    BerryField field = null;



    public void startSimulation(int rows, int cols) {
        if(!checkIsRowColPairValid(rows,cols)) {
            return;
        }

        field = new BerryField(3,3);
        field.printField();


    }

    public void printSimulation(char[][]mainSimulation){
   //     field.printField();
    }



    public boolean checkIsRowColPairValid(int rows, int cols) {
        if(rows == cols && rows > 2 ) {return true;}

        return false;
    }

    public boolean notStarted() {
        return field == null;
    }


    public static void main(String[] args){
        BerrySimulation sim = new BerrySimulation("jason");




        sim.startSimulation(3,3);

        if(sim.notStarted()) {
            // do something!
        }


    }
}



class Bear{
    int row;
    int col;
    public Bear(int row, int col){
        this.col = 0;
        this.row = 0;
    }
}


class BerryField {
    int rows;
    int cols;
    char[][] berryField;

    public void printField() {
        for(int i = 0; i < rows; i++) {
            String stringToPrint = "";
            for(int j = 0; j < cols; j++) {
                stringToPrint += this.berryField[i][j];

            }

            System.out.println(String.format("%s", stringToPrint));
        }
    }


    public BerryField(int rows, int cols) {

        berryField = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                berryField[i][j] = '0';

            }
        }
    }
}