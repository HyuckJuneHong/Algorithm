package dynamic_programming;

import java.io.*;

/** Dynamic Programming Algorithm
 * - 하나의 문제는 단 한 번만 풀도록하는 알고리즘
 * - 한 번 푼 것을 여러 번 다시 푸는 비효율적인 알고리즘을 개선시키는 방법
 * - 분할 정복 방식과는 다른 형태로 어떤 큰 문제가 작은 문제로 나눠질 때
 *   또 이 큰 문제가 더 큰 문제의 작은 문제일 때, 동시에 해당 값들에 변화가 없을 때 사용
 **
 *분할 정복 기법의 문제점 해결
 * - 일반적으로 상당 수 분할 정복 기법은 동일한 문제를 다시 푼다는 단점이 있다.
 *   -> 분할 정복 기법은 정렬과 같은 몇몇 요소에 대해선 이 단점이 없다.
 *   -> 다만, 대표적 예시로 피보나치 수열을 이 기법으로 풀 시 심각한 비효율성을 낳는다.
 *
 *다이나믹 프로그래밍이 사용될 때의 예시
 * - 가정 1 : 큰 문제를 작은 문제로 나눌 수 있다.
 * - 가정 2 : 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일
 * - 쉽게 말해, 크고 어려운 문제는 잘게 나누어 해결한 뒤 전체 답을 구하는 것.
 *   -> 다만 이 과정에선, 메모제이션(Memoization)이 사용된다는 점에 분할 정복과 다르다.
 *
 *메모제이션
 * - 이미 계산한 결과는 배열에 저장함으로써, 나중에 동일한 계산을 할 땐, 단순히 반환하는 방법.
 *
 *문제 11726 - 2xN 타일링 문제
 * - 2xN 크기의 직사각형을 1x2, 2x1 타일로 채우는 방법의 수를 구하는 프로그램
 * - 입력 : 첫째 줄에 n이 주어진다. (1 <= n <= 1000)
 * - 출력 : 첫쨰 줄에 2xN 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 * - 점화식 : D[n] = D[n-1] + D[n-2]
 */
public class Dynamic_tiling2xN {

    private static int d[];

    public static void main(String[] args) throws IOException {

        d = new int[1001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int x = Integer.parseInt(str);

        bw.write(tilingDp(x) + "");
        bw.flush();
        bw.close();
    }

    private static int tilingDp(int x) {
        if(x==1) return 1;
        if(x==2) return 2;
        if(d[x] != 0) return d[x];

        return d[x] = (tilingDp(x-1) + tilingDp(x-2)) % 10007;
    }
}
