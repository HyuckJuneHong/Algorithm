package hackerrank.easy;

import java.util.List;

public class CutTheSticks {

    public static int maxDifference(List<Integer> px) {

        int answer=0, maxIndex=0;

        for(int i=0; i<px.size(); i++){
            if(px.get(maxIndex)<=px.get(i)){
                maxIndex = i;
            }
        }

        if(maxIndex==0){
            return -1;
        }

        for(int i=0; i<maxIndex; i++){
            if(answer < px.get(maxIndex) - px.get(i))
                answer = px.get(maxIndex) - px.get(i);
        }

        return answer;
    }

}
