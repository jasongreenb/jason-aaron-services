package com.example;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class BerrySimulation {
    String name;
    public BerrySimulation(String name){
        this.name = name;
    }


    BerryField field = null;



    public void doTurn(int times) {
        for(int i = 0; i < times; i++) {
            System.out.println(String.format("----------------\nTurn: %d\n----------------", i + 1));
            field.printField();
            field.printBears();
            field.makeBearsMove();
            field.grow();
        }
    }




    public void startSimulation(int rows, int cols, HashSet<BerryField.Bear> bearRecords) {
        if(!checkIsRowColPairValid(rows,cols)) {
            return;
        }

        field = new BerryField(rows,cols, bearRecords);
        field.grow();




    }

    public void printSimulation(){
        if(this.field != null) {field.printField();};
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
        bears.add(new BerryField.Bear(2,2));


        sim.startSimulation(5,5, bears);
        sim.doTurn(5);





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
    char[][] data;
    HashSet<Bear> bears;


    public BerryField(int rows, int cols) {

        data = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                data[i][j] = '0';

                

            }
        }
    }

    // bears -> { <0,1> , <1,2>, <2,6>} so in all these spots we put a B to start
    public BerryField(int rows, int cols, HashSet<Bear> bears) {
        this.bears = bears;
        data = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(this.bears.contains(new Bear(i,j))) {
                    data[i][j] = 'B';
                } else{
                    data[i][j] = '0';
                }


            }
        }
    }

    public void grow(){
        for(int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.cols; j++){
                if(this.data[i][j] != 'B') {
                    char berryAmount = this.data[i][j];
                    int berryAmountNumber = Character.getNumericValue(berryAmount);
                    berryAmountNumber += 1;
                    char newBerryAmount = Character.forDigit(berryAmountNumber, 10);
                    this.data[i][j] = newBerryAmount;
                }

            }
        }
    }

    public void printBears() {
        System.out.println("*******************");
        for(Bear bear: bears) {

            System.out.println(String.format("rxc = (%d,%d) and the total berries eaten: %d\n", bear.row, bear.col, bear.berriesEaten));
        }
        System.out.println("*******************");

    }

    public void makeBearsMove() {

        int[] rowDirection = {-1, 1, 0, 0};
        int[] colDirection = {-1, 1, 0, 0};
        HashSet<Bear> updatedBears = new HashSet<>();

        for(Bear bear: this.bears){
            // Math.random() -> 0->1
            // 0->1 for ex: .67
            // .67 * 4 -> 3.001
            // int(3.001) = 3


            int randomDirectionRow = (int) (Math.random()* 4);
            int randomDirectionCol = (int) (Math.random()* 4);


            // newRow = bear.Row + rowDirection[0->3]
            // newCol = bear.Col + colDirection[0->3]
            int newRow = bear.row + rowDirection[randomDirectionRow];
            int newCol = bear.col + colDirection[randomDirectionCol];


            // Check boundaries
            if (newRow < 0 || newRow >= this.rows ||
                    newCol < 0 || newCol >= this.cols) {

                updatedBears.add(bear);
                continue;
            }

            // Check whether another bear occupies the destination
            if (this.data[newRow][newCol] == 'B') {
                updatedBears.add(bear);
                continue;
            }



            char berryChar = this.data[newRow][newCol];
            int berriesAtSpot = Character.getNumericValue(berryChar);

            int totalBerriesEaten = bear.berriesEaten + berriesAtSpot;
            this.data[bear.row][bear.col] = '0';
            this.data[newRow][newCol] = 'B';
            Bear updatedBear = new Bear (newRow, newCol, totalBerriesEaten);

            updatedBears.add(updatedBear);



        }

        this.bears = updatedBears;
    }

    public void printField() {
        for(int i = 0; i < rows; i++) {
            String stringToPrint = "";
            for(int j = 0; j < cols; j++) {


                stringToPrint += this.data[i][j];

            }

            System.out.println(String.format("%s", stringToPrint));
        }
        System.out.println("------------------------");
    }

}

