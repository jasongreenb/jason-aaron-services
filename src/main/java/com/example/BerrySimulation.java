package com.example;
import java.util.Scanner;


public class BerrySimulation {
    String name;
    public BerrySimulation(String name){
        this.name = name;
    }






    public char[][] startSimulation(){
        char[][] mainSimulation = new char[3][3];
            for(int i = 0; i < mainSimulation.length; i++){
                for(int j = 0; j < mainSimulation.length; j++){
                    mainSimulation[i][j] = '0';
                    // help maybe
                }
            }
            return mainSimulation;
    }
    public void printSimulation(char[][]mainSimulation){
        System.out.println("-----------------");
        for(int i = 0; i < mainSimulation.length; i++){
            System.out.print("| ");
            for (int j = 0; j < mainSimulation.length; j++){
                System.out.print(mainSimulation[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-----------------");
        }
    }






    public static void main(String[] args){

    BerrySimulation berrySimulation = new BerrySimulation("Aaron");
    char[][] sim1 = berrySimulation.startSimulation();
    berrySimulation.printSimulation(sim1);
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