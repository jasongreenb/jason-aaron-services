package com.example;
import java.util.HashSet;
import java.util.Scanner;


public class BerrySimulation {
    String name;
    public BerrySimulation(String name){
        this.name = name;
    }


    BerryField field = null;



    public void startSimulation(int rows, int cols, HashSet<BerryField.Bear> bearRecords) {
        if(!checkIsRowColPairValid(rows,cols)) {
            return;
        }

        field = new BerryField(rows,cols, bearRecords);
        field.printField();
        field.grow(); // after grow()
        // we call bearmove()
        // then print bear stats where we loop through bear hash set and print how much
        // each bear has eaten
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


        HashSet<BerryField.Bear> bears = new HashSet<>();
        bears.add(new BerryField.Bear(1,1));



        sim.startSimulation(3,3, bears);

        if(sim.notStarted()) {
            // do something!
        }


    }
}







class BerryField {
    record Bear(int row, int col,int berriesEaten){
        public Bear(int row, int col){
            this(row,col,0);
        }
    }

    int rows;
    int cols;
    char[][] berryField;
    HashSet<Bear> bears;

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


    // bears -> { <0,1> , <1,2>, <2,6>} so in all these spots we put a B to start
    public BerryField(int rows, int cols, HashSet<Bear> bears) {
        this.bears = bears;
        berryField = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(this.bears.contains(new Bear(i,j))) {
                    berryField[i][j] = 'B';
                } else{
                    berryField[i][j] = '0';
                }


            }
        }
    }

    public void grow(){
        for(int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.cols; j++){
                if(this.berryField[i][j] != 'B') {
                    char berryAmount = this.berryField[i][j];
                    int berryAmountNumber = Character.getNumericValue(berryAmount);
                    berryAmountNumber += 1;
                    char newBerryAmount = Character.forDigit(berryAmountNumber, 10);
                    this.berryField[i][j] = newBerryAmount;
                }

            }
        }
    }
    public void makeBearsMove(){
        int[] rowDirection = {-1, 1, 0, 0};
        int[] colDirection = {-1, 1, 0, 0};

        for(Bear bear: this.bears){
            int randomDirection = (int) (Math.random()* 4);

            int newRow = bear.row + rowDirection[randomDirection];
            int newCol = bear.row + colDirection[randomDirection];


            if (newRow >= 0 && newRow < this.rows && newCol >= 0 && newCol < this.cols){

            } else{
                System.out.println("Bear hit the boundary and didnt move");
            }

            char berryChar = this.berryField[newRow][newCol];
            int berriesAtSpot = Character.getNumericValue(berryChar);

            int totalBerriesEaten = bear.berriesEaten + berriesAtSpot;

            this.berryField[bear.row][bear.col] = '0';

            Bear movedBear = new Bear (newRow, newCol, totalBerriesEaten);
            updatedBears.add(movedBear);

        }
    }

}

