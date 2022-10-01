import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2225_이영준 {

	static int n, k, dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[k+1][n+1];	
		Arrays.fill(dp[1], 1);
		
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				if(j == 0) {
					dp[i][j] = 1;
				}else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
					dp[i][j] %= 1000000000;
				}
			}
		}
		
		System.out.println(dp[k][n]);
	}
}
