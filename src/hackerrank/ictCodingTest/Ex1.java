package hackerrank.ictCodingTest;

import java.util.Arrays;
import java.util.List;

public class Ex1 {

    public static int maxDifference(List<Integer> px) {

        int answer=-1;

        int min = px.get(0);
        for(int i=1; i<px.size(); i++){
            if(px.get(i-1) < px.get(i)){
                answer = Math.max(answer, px.get(i) - min);
            }

            if(px.get(i-1) > px.get(i)) {
                if(i+1 != px.size() && px.get(i) < px.get(i+1)) {
                    answer = Math.max(answer, px.get(i-1) - min);
                }
            }
            min = Math.min(min, px.get(i));
        }

        return answer;
    }

    public static void main(String[] args) {
        maxDifference(Arrays.asList(3, 9, 1, 8, 3, 2));
    }

}
