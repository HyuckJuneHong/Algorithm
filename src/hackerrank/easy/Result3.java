package hackerrank.easy;

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

class Result3 {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */


    public static int diagonalDifference(List<List<Integer>> arr) {

        Integer primary = 0;
        Integer secondary = 0;

        for(int i=0; i<arr.size(); i++){
            List<Integer> list = arr.get(i);
            for(int j=0; j<list.size(); j++){
                if(i==j){
                    primary += list.get(j);
                }
                if((i+j) == list.size()-1){
                    secondary += list.get(j);
                }
            }
        }

        return Math.abs(primary-secondary);

    }

}

