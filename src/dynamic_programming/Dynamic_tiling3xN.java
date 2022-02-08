package dynamic_programming;


import java.io.*;

/** 문제 2133 - 3xN 타일링 문제
 * - 3xN 크기의 벽을 1x2, 2x1 타일로 채우는 경우의 수를 구하는 프로그램
 * - 입력 : 첫째 줄에 n(1 <= N <= 30) 이 주어진다.
 * - 첫째 줄에 경우의 수를 출력한다.
 * - 점화식 : D[n] = 3 * D[n-2] + (2*D[n-4] + 2*D[n-6] + ... + 2*D[0])
 */
public class Dynamic_tiling3xN {

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

        if(x==0) return 1;
        if(x==1) return 0;
        if(x==2) return 3;
        if(d[x] != 0) return d[x];

        int result = 3*tilingDp(x-2);

        for(int i=3; i<=x; i++){
            if(i%2 == 0)
                result += 2 * tilingDp(x-i);
        }

        return d[x] = result%10007;

    }
}
