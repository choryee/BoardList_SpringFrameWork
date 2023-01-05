package com.chori.springStudy.model;

public class ArrayTest {


    public static void main(String[] args) {

        for(int i=1; i<2; i++){
            for(int j=1; j<13; j++){
                if(j%4==0) System.out.println(j);
                else System.out.print(j);
            }//- -j
        }//--i
        System.out.println("--------------");

        // int array[][]=new int[3][4];
        int array[][]={{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++) {
                System.out.print(array[i][j]+"   ");
            }
            System.out.println();
        }

        System.out.println("--------------");

        int arrayT[][]={{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++) {
                System.out.print(array[j][i]+"   ");
            }
            System.out.println();
        }


    }
}