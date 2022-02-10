package hackerrank.easy;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;

public class ArraySum {
    public static int simpleArraySum(List<Integer> ar) {

        int result = 0;
        for(Integer num: ar){
            result += num;
        }

        return result;
    }
}
