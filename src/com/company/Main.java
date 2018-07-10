package com.company;

import java.util.*;

    // This program takes a list of arrays. From this list it extracts
    // a number from each array and creates all the possible and non repeatable
    // combinations.
    // It works exactly has if all the arrays are in a nested for loop:

//        List<int[]> finalArrays = new ArrayList<>(  );
//        int[] result;
//        for (int i=0; i<ints1.length; i++) {
//            for (int z=0; z<ints2.length; z++) {
//                for (int y=0; y<ints3.length; y++) {
//                    result = new int[3];
//                    result[0] = ints1[i];
//                    result[1] = ints2[z];
//                    result[2] = ints3[y];
//                    finalArrays.add( result );
//                }
//            }
//        }

public class Main {

    public static void main(String[] args) {
        int[] ints1 = new int[2];
        ints1[0] = 1;
        ints1[1] = 2;

        int[] ints2 = new int[3];
        ints2[0] = 3;
        ints2[1] = 4;
        ints2[2] = 5;

        int[] ints3 = new int[2];
        ints3[0] = 6;
        ints3[1] = 7;

        arrayAlgoritm( Arrays.asList(ints1, ints2, ints3) );
    }

    public static void arrayAlgoritm(List<int[]> ints) {

        //Finding the number of possible combinations
        int size=1;
        for (int[] array: ints) {
            size *= array.length;
        }

        // Creating a list of indexes. Every index corresponds
        // to a single array
        List<Index> indexList = new ArrayList<>(  );
        ints.forEach( array -> indexList.add( new Index( array ) ) );

        int[] result;
        List<int[]> finalArrays = new ArrayList<>(  );

        boolean flag = true;

        while (flag) {
            // Creating an array by taking one number from each
            result = new int[ints.size()];
            for (int i=0; i<ints.size(); i++) {
                result[i] = ints.get( i )[indexList.get( i ).getCurrentIndex()];
            }

            finalArrays.add( result );
            incrementIndexes(indexList);

            // If the size has been reached, this means that all
            // the possible combinations have been extracted
            if (finalArrays.size() == size) flag = false;
        }
        System.out.println("Final list size = " + finalArrays.size());
        finalArrays.forEach( array -> {
            for (int i: array) {
                System.out.print(i + ", ");
            }
            System.out.println("==============================");
        } );


    }

    // This method increments the last index in the list that has not reached it's maximum value.
    // If the last index has reached it's maximum value it will first increment the
    // the one on the position i-1 and after it will reset all the others on a higher position to 0
    private static void incrementIndexes(List<Index> indexList) {
        int size = indexList.size();

        for (int i=size-1; i>=0; i--) {
            if (indexList.get( i ).getCurrentIndex() < indexList.get( i ).getMaxIndex()) {
                indexList.get( i ).setCurrentIndex( indexList.get( i ).getCurrentIndex()+1 );

                // If it is not the last index in the list
                if (indexList.indexOf( indexList.get( i ) ) != size-1) {
                    for (int z=i+1; z<indexList.size(); z++) {
                        indexList.get( z ).setCurrentIndex( 0 );
                    }
                }
                break;
            }
        }
    }
}
