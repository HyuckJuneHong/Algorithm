package greedy;

import java.io.*;

/**Greedy Algorithm (그리디 알고리즘, 갈망법, 탐욕적 기법)
 * - 당장 눈 앞에 보이는 최적의 상황만을 쫓는 알고리즘
 * - 가장 단순한 알고리즘으로, 항상 최적의 결과를 도출하는 것은 아니지만,
 *   어느 정도 최적 해에 근사한 값을 빠르게 구할 수 있다는 장점이 있다.
 *   -> 때문에 특정 상황에선 그리디 알고리즘이 최적의 해를 보장할 수 있다.
 *
 *대표 적인 예
 * - 거스름 돈 문제
 *   -> 이 경우 무조건 더 큰 화폐 단위부터 거슬러준다는 조건만 지키면 최적의 해를 보장
 * - 이처럼, 무조건 큰 경우, 무조건 작은 경우, 긴 경우, 짧은 경우 등으로 접근한다는 점에서
 *   정렬 기법과 함께 사용되는 경우가 많음.
 *   -> 대표적인 예로 크루스칼 알고리즘이 있다.
 *
 *문제점
 * - 그리디는 최적의 해를 보장하지 못하는 경우가 더 많기 때문에, 다이나믹 프로그래밍 등의
 *   기타 알고리즘 기법을 적용해야 하기도 한다.
 */
public class Greedy {

    public static void main(String[] args) throws IOException {
        int money, result=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        money = Integer.parseInt(br.readLine());

        result += money/500;
        money %= 500;

        result += money/100;
        money %= 100;

        result += money/50;
        money %= 50;

        result += money/10;
        money %= 10;

        bw.write("동전 갯수: " +result);
        bw.flush();
        bw.close();

    }
}
