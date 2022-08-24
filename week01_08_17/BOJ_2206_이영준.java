import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * map[n][m], visited[n][m] -> dfs를 사용해서 좌표가 n,m이 될때까지 cnt+1을 해가며 구해간다. 현재위치의 값이 1이고 1번도 안부셨을때 부시고 들어간다고 가정하였다.
 * 결과 : 시간초과 // test_case 1개씩 돌리면 돌아감
 */
public class BOJ_2206_이영준_시간초과 {

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, result, endX, endY;
	static char map[][];
	static boolean smash, visited[][];
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우하좌상

	public static void main(String[] args) throws IOException { 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		endX = n - 1;
		endY = m - 1;
		map = new char[n][m];
		visited = new boolean[n][m];
		result = Integer.MAX_VALUE;
		String str;
		for (int i = 0; i < n; i++) {
			str = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		dfs(new Pair(0, 0), 1);

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

	private static void dfs(Pair pair, int cnt) {
		if (pair.x == endX && pair.y == endY) {
			result = Math.min(result, cnt);
			return;
		}
		for (int i = 0, end = dir.length; i < end; i++) {
			int nx = pair.x + dir[i][0];
			int ny = pair.y + dir[i][1];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}
			if (!visited[nx][ny]) {
				if (map[nx][ny] == '0') {
					visited[nx][ny] = true;
					dfs(new Pair(nx, ny), cnt + 1);
					visited[nx][ny] = false;
				} else {
					if (!smash) {
						visited[nx][ny] = true;
						smash = true;
						map[nx][ny] = '0';
						dfs(new Pair(nx, ny), cnt + 1);
						visited[nx][ny] = false;
						smash = false;
					}
				}
			} 
		}
	}
}
