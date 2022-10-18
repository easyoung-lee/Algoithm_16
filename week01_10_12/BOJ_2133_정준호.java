package algorithm;

import java.util.Scanner;

public class Main_G4_2133_타일채우기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[31];
		
		dp[0] = 1;
		dp[2] = 3;
		dp[4] = dp[2]*3 + 2;
		
		for (int i = 6; i < dp.length; i+=2) {
			dp[i] = dp[i-2]*3;
			for (int j = 4; j <= i; j+=2) {
				dp[i] += dp[i-j]*2;
			}
		}
		System.out.println(dp[n]);
	}

}
