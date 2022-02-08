package dynamic_programming;

import java.io.*;

/**
 *  *문제 14852 - 2x2 타일링 문제
 *  * - 2xN 크기의 직사각형을 1x2, 2x1, 1x1 타일로 채우는 방법의 수를 구하는 프로그램
 *  * - 입력 : 첫째 줄에 n이 주어진다. (1 <= n <= 1,000,000)
 *  * - 출력 : 첫쨰 줄에 2xN 크기의 직사각형을 채우는 방법의 수를 1,000,000,007로 나눈 나머지를 출력한다.
 *  * - 점화식 : D[n] = 2*D[n-1] + 3*D[n-2] + (2*D[n-3] + 2*D[n-4] + ... + 2*D[0])
 */
public class Dynamic_tiling2xNwith1x1 {
    private static int[][] d;
    private static int[] p;

    public static void main(String[] args) throws IOException {

        d = new int[1000001][2];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int x = Integer.parseInt(str);

        bw.write(dp(x) + "\n");
        bw.flush();
        bw.close();

    }

    private static int dp(int x) {

        // 0 2 7
        //     1
        d[0][0] = 0;
        d[1][0] = 2;
        d[2][0] = 7;
        d[2][1] = 1;

        for(int i=3; i<=x; i++) {
            d[i][1] = (d[i-3][0] + d[i-1][1]) % 1000000007;
            d[i][0] = (3 * d[i-2][0] + 2 * d[i-1][0] + 2 * d[i][1]) % 1000000007;
        }

        return d[x][0];
    }
}
