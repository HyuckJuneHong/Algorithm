package hackerrank.medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//Forming a Magic Square
class MagicSquare {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {

        int totalCost = Integer.MAX_VALUE;
        int[][][] magicSquare = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        for(int i=0; i<magicSquare.length; i++){

            int cost=0;

            for(int j=0; j<magicSquare[i].length; j++){
                for(int k=0; k<magicSquare[i][j].length; k++){
                    if(s.get(j).get(k) != magicSquare[i][j][k]){
                        cost += Math.abs(s.get(j).get(k) - magicSquare[i][j][k]);
                    }
                }
            }
            totalCost = Math.min(totalCost, cost);
        }

        return totalCost;

    }

}

