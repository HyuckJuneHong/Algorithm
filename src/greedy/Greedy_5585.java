package greedy;

import java.io.*;

public class Greedy_5585 {

    public static void main(String[] args) throws IOException {

        int money, result=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        money = 1000 - Integer.parseInt(br.readLine());

        result += money/500;
        money %= 500;

        result += money/100;
        money %= 100;

        result += money/50;
        money %= 50;

        result += money/10;
        money %= 10;

        result += money/5;
        money %= 5;

        result += money/1;
        money %= 1;

        bw.write(result + "");
        bw.flush();
        bw.close();

    }
}
