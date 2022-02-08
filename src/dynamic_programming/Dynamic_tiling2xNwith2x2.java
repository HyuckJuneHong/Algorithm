package dynamic_programming;

import java.io.*;

/**
 *  *문제 11727 - 2x2 타일링 문제
 *  * - 2xN 크기의 직사각형을 1x2, 2x1 타일로 채우는 방법의 수를 구하는 프로그램
 *  * - 입력 : 첫째 줄에 n이 주어진다. (1 <= n <= 1000)
 *  * - 출력 : 첫쨰 줄에 2xN 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 *  * - 점화식 : D[n] = D[n-1] + 2 * D[n-2]
 */
public class Dynamic_tiling2xNwith2x2 {

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
        if(x==2) return 3;
        if(d[x] != 0) return d[x];

        return d[x] = (tilingDp(x-1) + 2*tilingDp(x-2)) % 10007;
    }
}
