package hackerrank.ictCodingTest;

//001110101
public class Ex2 {

    public static int getSubstringCount(String s) {

        int zeroCount = 0, oneCount = 0;
        int answer = 0, index=0;

        while(index < s.length()){
            if(s.charAt(index) == '0'){
                while(index < s.length() && s.charAt(index) == '0'){
                    index++;
                    zeroCount++;
                }
                answer += Math.min(zeroCount, oneCount);
                oneCount = 0;
            }
            else{
                while(index < s.length() && s.charAt(index) == '1'){
                    index++;
                    oneCount++;
                }
                answer += Math.min(zeroCount, oneCount);
                zeroCount = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        getSubstringCount("001101");
    }
}

