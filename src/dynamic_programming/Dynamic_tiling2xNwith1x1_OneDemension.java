package dynamic_programming;

import java.io.*;

public class Dynamic_tiling2xNwith1x1_OneDemension {

    private static int d[];

    public static void main(String[] args) throws IOException {

        d = new int[1000001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int x = Integer.parseInt(str);

        bw.write(oneDemension(x) + "\n");
        bw.flush();
        bw.close();

    }

    private static int oneDemension(int x) {

        if(x == 0) return 1;
        if(x == 1) return 2;
        if(x == 2) return 7;
        if(d[x] != 0) return d[x];

        int result = 3 * oneDemension(x-2) + 2 * oneDemension(x-1);

        for(int i=3; i<=x; i++) {
            result += (2 * oneDemension(x-i)) % 1000000007;
        }

        return d[x] = result % 1000000007;
    }
}
