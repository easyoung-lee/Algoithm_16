import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BOJ_2225_홍윤식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int K = Integer.parseInt(stz.nextToken());

        int[][] memo = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                memo[i][j] = (memo[i][j - 1] + memo[i - 1][j]) % 1000000000;
            }
        }

        System.out.println(memo[K][N]);
    }
}
