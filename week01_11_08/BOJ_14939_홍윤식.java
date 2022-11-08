package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14939_홍윤식 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = {  0, 0,-1, 1 };
	static String[][] map = new String[10][10];
	static int[][] binMap = new int[10][10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			String[] temp = br.readLine().split("");
			map[i] = temp;

		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int bin =0;
				
				if (map[i][j].equals("O")) bin=0b10000;
				int mask = 0b1000;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10) {
						if (map[nx][ny].equals("O")) bin=bin|mask;
						
					}
					mask=mask>>1;
				}
			binMap[i][j]=bin;
			System.out.printf("%05d ",Integer.parseInt(Integer.toBinaryString(binMap[i][j])) );
			
			}
			System.out.println();
			
			
		}
		
		
	}
}