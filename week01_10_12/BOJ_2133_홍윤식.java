package week01_10_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133_홍윤식 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[30 + 1];
        // 3*0 을 채우는 경우는 무조건 1개 존재
        memo[0] = 1;
        // 3*2를 채우는 경우는 3가지 존재
        memo[2] = 3;
        // 3*n에서 홀수는 채울수 없음
        for (int i = 4; i <= N; i++) {
            // n이 2이상 짝수일때 n-2에 부족한 2만큼 채우는 경우의수 3가지 존재
            memo[i] += memo[i - 2] * 3;
            // 특수한 경우 2가지 + n-4 이하의 짝수부터 n-2x 칸을 특수한 경우 2가지로 채우는 방법은 2x 칸을 채우는 방법 *2
            for (int j = i - 4; j >= 0; j -= 2) {
                memo[i] += memo[j] * 2;
            }
        }
        System.out.println(memo[N]);
    }
}
