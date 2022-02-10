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

class Result4 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {

        int pos=0, neg=0, zero=0;
        for(Integer list : arr){
            if (list > 0) {
                pos++;
            }else if(list < 0){
                neg++;
            }else
                zero++;
        }

        System.out.println(pos/(double)arr.size());
        System.out.println(neg/(double)arr.size());
        System.out.println(zero/(double)arr.size());

    }

}

