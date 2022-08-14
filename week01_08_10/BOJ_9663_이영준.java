package lec_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_이영준 {
	static int n, result;
//	static boolean graph[][];
	static int graph[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
//		graph = new boolean[n][n];
		graph = new int[n];
//		result = 0;		
//		Combination(num-1, num-2, num-1, num-1, num);
		Combination(0);
		
		System.out.println(result);
	}


//	private static void Combination(int new_n, int new_r, int now_n, int now_r, int flag) {
//		if(flag==0) {
//			result += 1;
//			return;
//		}
//		
//		if(new_n < 0 && new_r < 0) {
//			return;
//		}
//		
//		if(now_n != new_n && now_r != new_r && Math.abs(new_n - now_n) != Math.abs(new_r - now_r) {
//			graph[new_n][new_r] = true;
//			if(new_r==0) {
//				Combination(new_n-1, new_r+num-1, new_n, new_r, flag-1);		// 퀸 좌표 선택시
//				Combination(new_n-1, new_r+num-1, new_n, new_r, flag);		// 퀸 좌표 미선택시
//			}else {
//				Combination(new_n, new_r-1, new_n, new_r, flag-1);			// 퀸 좌표 선택시				
//				Combination(new_n, new_r-1, new_n, new_r, flag);				// 퀸 좌표 미 선택시
//			}
//		}
//	}

	private static void Combination(int cnt) {
		if(cnt == n) {
			result += 1;
			return;
		}
		for (int i = 0; i < n; i++) {
			boolean check = true;
			graph[cnt] = i;
			if(cnt == 0 ) {
				Combination(cnt+1);		
			}else {
				for (int j = 0; j < cnt; j++) {
					if(graph[cnt] == graph[j]){
						check = false;
						break;						
					}else if(Math.abs(graph[cnt]-graph[j]) == Math.abs(cnt-j)) {
						check = false;
						break;
					}
				}				
				if(check) {
					Combination(cnt+1);
				}
			}
		}
	}
}
