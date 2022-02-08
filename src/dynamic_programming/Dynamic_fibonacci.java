package dynamic_programming;

public class Dynamic_fibonacci {

    public static int arr[]; // 메모이제이션 기법, O(N)의 시간 복잡도.

    public static int fibo_dp(int x) { // O(2^N)의 시간 복잡도를 가짐.

        if(x==1) return 1;
        if(x==2) return 1;
        if(arr[x] !=0) return arr[x]; // 연산을 수행하다 이미 메모되어 있는 값이 있을 경우 반환하고

        return arr[x] =fibo_dp(x-1) + fibo_dp(x-2);  // 메모되어있지 않으면 메모 후 반환.
    }
    public static void main(String[] args) {
        arr = new int[100];

        System.out.println(fibo_dp(30));
    }
}
