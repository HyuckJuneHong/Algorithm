package hackerrank.ictCodingTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {

    public static int calculateCost(List<Integer> arr, int threshold) {

        int answer = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<threshold; i++) {
            for(int j=i; j<arr.size(); j+=threshold) {
                if(j+threshold < arr.size()) {
                    List<Integer> subList = arr.subList(j, j+threshold);
                    sum += Collections.max(subList);
                }
                else {
                    List<Integer> subList = arr.subList(j, arr.size());
                    sum += Collections.max(subList);
                }
            }
            if(i != 0) {
                List<Integer> subList = arr.subList(0, i);
                sum += Collections.max(subList);
            }
            answer = Math.min(answer, sum);
            sum = 0;
        }

        return answer;
    }
}
