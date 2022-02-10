package hackerrank.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ClimingTheLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        List<Integer> newRanked = ranked.parallelStream().distinct().collect(Collectors.toList());;
        Collections.sort(newRanked, Collections.reverseOrder());

        Collections.sort(player);

        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<player.size(); i++){
            answer.add(binarySearch(player.get(i), newRanked, 0, newRanked.size()));
        }

        return answer;
    }

    public static Integer binarySearch(int key, List<Integer> rank, int low, int high){

        int mid = (low + high)/2;

        if(low >= rank.size()) return rank.size()+1;
        if(low > high) return low+1;
        if(key > rank.get(mid))
            return binarySearch(key, rank, low, mid-1);
        else if(key < rank.get(mid))
            return binarySearch(key, rank, mid+1, high);
        else
            return mid+1;

    }
}
