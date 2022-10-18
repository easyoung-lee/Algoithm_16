package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_2293_동전2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k+1];
		int[] arr = new int[n];
		
		for (int i = 0; i <= k; i++) {
			dp[i] = 1231231231;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] <= k)	dp[arr[i]] = 1;
		}
		
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {	// j번 동전
				if(i >= arr[j])
				dp[i] = Math.min(dp[i], dp[i-arr[j]] + 1);
			}
		}
		
		System.out.println(dp[k]==1231231231 ? -1 : dp[k]);
			
	}
}
