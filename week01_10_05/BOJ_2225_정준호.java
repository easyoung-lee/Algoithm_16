package algorithm;

import java.util.Scanner;

public class Main_G5_2225_합분해 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		long[][] dp = new long[N+1][K+1];
		// 행 : 개수, 열 : 합
		
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}
		for (int j = 0; j <= K; j++) {
			dp[0][j] = 1;
		}
		
			for (int j = 2; j <= K; j++) {
				for (int i = 1; i <= N; i++) {
				// j개를 더해서 i
				for (int k = 0; k <= i; k++) {
					dp[i][j] += dp[i-k][j-1] % 1000000000;
				}
				dp[i][j] %= 1000000000;
			}
		}
		System.out.println(dp[N][K]);
	}

}
