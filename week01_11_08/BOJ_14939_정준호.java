package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_P5_14939_불끄기 {

	static char[][] origin_map;
	public static void main(String[] args) throws IOException {
		origin_map = new char[11][10];	// 0행은 subset
		int result = Integer.MAX_VALUE;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i < 11; i++) {
			char[] chs = br.readLine().toCharArray();
			for (int j = 0; j < 10; j++) {
				origin_map[i][j] = chs[j];
			}
		}
		
		for (int s = 0; s < (1<<10); s++) {
			int sub_result = 0;
			char[][] map = copy();
			for (int c = 0; c < 10; c++) {
				if((s & (1<<c)) != 0)	map[0][c] = 'O';	
				else					map[0][c] = '#';
			}
			
			for (int i = 10; i < 110; i++) {
				int r = i/10;
				int c = i%10;
				
				if(map[r-1][c] == 'O')	{
					sub_result++;
					convert(map, r, c);
				}
				if(r==10 && c==9 && map[r][c] == 'O') {
					sub_result = Integer.MAX_VALUE;
				}
				
				if(r==10 && c!=0 && map[r][c-1] == 'O') {
					sub_result = Integer.MAX_VALUE;
					break;
				}
			}
			
			
			
			
			result = Math.min(result, sub_result);
		}
		
		System.out.println(result==Integer.MAX_VALUE ? -1 : result);

	}
	
	private static char[][] copy() {
		char[][] map = new char[11][10];
		for (int i = 0; i < 11; i++) {
			map[i] = origin_map[i].clone();
		}
		return map;
	}

	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	private static void convert(char[][] map, int r, int c) {
		// TODO Auto-generated method stub
		if(map[r][c] == 'O')	map[r][c] = '#';
		else					map[r][c] = 'O';
		for (int[] d : dir) {
			int nr = r+d[0];
			int nc = c+d[1];
			if(nr < 0 || nr >= 11 || nc < 0 || nc >= 10)
				continue;
			if(map[nr][nc] == 'O')	map[nr][nc] = '#';
			else					map[nr][nc] = 'O';
		}
	}

}
