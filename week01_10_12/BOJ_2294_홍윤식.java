package week01_10_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2294_홍윤식 {
    static int[] coins;
    static boolean[] check;
    static int n, k, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        coins = new int[n];
        check = new boolean[n];
        int[][] dp = new int[k + 1][2];
        dp[0][0] = 1;
        for (int i = 0; i <= k; i++) {
            dp[i][1] = 10001;
        }
        dp[0][1] = 0;
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            for (int j = coins[i]; j <= k; j++) {
                dp[j][0] += dp[j - coins[i]][0];
                dp[j][1] = Math.min(dp[j][1], dp[j - coins[i]][1] + 1);

            }
            // for (int j = 0; j <= k; j++) {
            // System.out.print(dp[j][1] + " ");

            // }
            // System.out.println();
        }

        System.out.println(dp[k][1] != 10001 ? dp[k][1] : -1);
    }

}
