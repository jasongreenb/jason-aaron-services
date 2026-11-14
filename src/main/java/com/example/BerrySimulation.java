package com.example;
import java.util.HashSet;
import java.util.Scanner;

// make a function
// that moves the bears after we call grow()
// and it eats the spot it goes to and the spot it left becomes a 0
// make the functionality work with just one bear
// think about boudns if you are on a edge you cant go out of the map
// add a field in the bear record to store how many berries this bear has eaten



// so function called makeBearMoves();
// after this function we can check how much that singular bear has eaten on this one move

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

        field = new BerryField(3,3, bearRecords);
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
    record Bear(int row, int col){}

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


}

