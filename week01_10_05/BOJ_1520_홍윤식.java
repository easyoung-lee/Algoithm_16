package week01_10_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1520_홍윤식 {
	static private int[][] map;
	static private int[][] ansMap;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		map = new int[N][M];
		ansMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			Arrays.fill(ansMap[i], -1);
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stz.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(ansMap[0][0]);

	}

	static private int dfs(int sx, int sy) {
		if (sx == N - 1 && sy == M - 1) {
			return 1;
		}
		if (ansMap[sx][sy] != -1) {
			return ansMap[sx][sy];
		}
		ansMap[sx][sy] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M &&
					map[nx][ny] < map[sx][sy]) {

				ansMap[sx][sy] += dfs(nx, ny);

			}
		}
		return ansMap[sx][sy];
	}
}
