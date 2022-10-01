import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_이영준_DFS {

	static int n, m, map[][], result;
	static boolean visited[][];
	static int dir[][] = {{1, 0}, {0, 1}, {0, -1}}; // 하 우 좌
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0][0] = true;
		dfs(0, 0);
		System.out.println(result);
	}
	private static void dfs(int x, int y) {
		if(x == n-1 && y == m-1) {
			result += 1;
			return;
		}
		
		int nx, ny;
		if(x == n-1) {
			nx = x + dir[1][0];
			ny = y + dir[1][1];
			
			if(map[x][y] > map[nx][ny]) {
				dfs(nx, ny);
			}
		}else {
			for (int i = 0; i < 3; i++) {
				nx = x + dir[i][0];
				ny = y + dir[i][1];
				
				if(nx<0 || nx>=n || ny<0 || ny>=m) {
					continue;
				}
				
				if(!visited[nx][ny]) {
					if(map[x][y] > map[nx][ny]) {
						visited[nx][ny] = true;
						dfs(nx, ny);
						visited[nx][ny] = false;
					}					
				}
			}
		}
	}

}
