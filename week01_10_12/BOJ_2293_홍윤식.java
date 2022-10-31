package week01_10_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_홍윤식 {
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
        //메모를 위한 배열 생성
        int[] dp = new int[k + 1];
        //0원을 만드는 경우의 수는 항상 1
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            for (int j = coins[i]; j <= k; j++) {
                //i번 째 코인으로 j의 가치를 만드는 경우의 수는
            	// (j-i)만큼을 만드는 경우의 수에 i번째 코인만 더하면 되므로 dp[j-coins[i]]만큼 dp에 더해주면 된다. 
            	dp[j] += dp[j - coins[i]];

            }
            

        System.out.println(dp[k]);
    }

}