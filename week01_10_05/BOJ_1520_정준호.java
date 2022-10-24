package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G3_1520_내리막길 {

	static int[][] map;
	static boolean[][] visited, dp;
	static int R, C, result;
	static ArrayDeque<int[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dp = new boolean[R][C];
		visited = new boolean[R][C];
		list = new ArrayDeque<int[]>(R+C);
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][0] = true;
		dfs(0,0,false);
		System.out.println(result);
		
	}

	static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	private static void dfs(int r, int c, boolean prev) {
		
		if(r == R-1 && c == C-1) {
			result++;
			for (int[] point : list) {
				dp[point[0]][point[1]] = true;
			}
			return;
		}
		
		if(dp[r][c] && !prev) {
			result++;
			for (int[] point : list) {
				dp[point[0]][point[1]] = true;
			}
			return;
		}
		
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + d[dir][0];
			int nc = c + d[dir][1];
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc])
				continue;
			
			
			if(map[nr][nc] < map[r][c]) {
				visited[nr][nc] = true;
				list.add(new int[] {nr, nc});
				dfs(nr, nc, dp[r][c]);
				visited[nr][nc] = false;
				list.poll();
			}
		}
	}
}
