package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G1_13460_구슬탈출2 {

	static int R, C, Hr, Hc, MAX_STEP = 10, result = 100;
	static int[] select = new int[MAX_STEP];
	static int[][][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		
		dp = new int[R][C][R][C];	// [rr][rc][br][bc]

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int i2 = 0; i2 < R; i2++) {
					for (int j2 = 0; j2 < C; j2++) {
						dp[i][j][i2][j2] = 100;
					}
				}
			}
		}
		
		
		int Rr=0, Rc=0, Br=0, Bc=0;
		for (int i = 0; i < R; i++) {
			char[] chs = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = chs[j];
				if(map[i][j] == 'R') {
					Rr = i;
					Rc = j;
				} else if(map[i][j] == 'B') {
					Br = i;
					Bc = j;
				} else if(map[i][j] == 'O') {
					Hr = i;
					Hc = j;
				}
			}
		}
		
		dp[Rr][Rc][Br][Bc] = 0;
		
		dfs(map, 0, Rr, Rc, Br, Bc);
		
		
		System.out.println(result==100 ? -1 : result);
	}
	
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	private static void dfs(char[][] map, int cnt, int rr, int rc, int br, int bc) {
		// TODO Auto-generated method stub
		
		if(cnt == MAX_STEP) {	// 10번 구름
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			select[cnt] = d;	// 갈 방향 선택
			char[][] temp_map = copy(map);
			
			// 이동 r, b, r
			int[] red_pos = move(temp_map, rr, rc, d);
			int[] blue_pos = move(temp_map, br, bc, d);
			if(red_pos != null)
				red_pos = move(temp_map, red_pos[0], red_pos[1], d);
			
			if(red_pos == null || blue_pos == null) {	
				// 원하는 결과
				if(blue_pos != null) {
					result = Math.min(result, cnt+1);
					return;	// 빨간공만 들어감 -> 종료
				}
				continue;	// 파란공 들어감 -> 패스
			}
			
			if(dp[red_pos[0]][red_pos[1]][blue_pos[0]][blue_pos[1]] <= cnt)
				continue;
			
			dp[red_pos[0]][red_pos[1]][blue_pos[0]][blue_pos[1]] = cnt;
			
			dfs(temp_map, cnt+1, red_pos[0], red_pos[1], blue_pos[0], blue_pos[1]);
		}
	}

	// 무한 전진
	private static int[] move(char[][] temp_map, int r, int c, int d) {
		
		if(temp_map[r][c] == 'O')	return null;	// 들어갔다는 시그널
		
		while(true) {
			int next_r = r+dir[d][0];
			int next_c = c+dir[d][1];
			
			if(temp_map[next_r][next_c] == 'O') {
				temp_map[r][c] = '.';	// 들어감 처리
				return null;	// 들어갔다는 시그널
			}
			if(temp_map[next_r][next_c] == '#' || temp_map[next_r][next_c] == 'R' || temp_map[next_r][next_c] == 'B')	
				return new int[] {r, c};	// 멈춘 좌표
			
			temp_map[next_r][next_c] = temp_map[r][c];			
			temp_map[r][c] = '.';
			
			r = next_r;
			c = next_c;	// 다음 스텝
		}
	}

	private static char[][] copy(char[][] real_map) {
		char[][] new_map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			new_map[i] = Arrays.copyOf(real_map[i], C);
		}
		return new_map;
	}

}
