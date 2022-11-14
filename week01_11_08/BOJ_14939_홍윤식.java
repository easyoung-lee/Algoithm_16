
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14939_홍윤식 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map = new char[10][10];
	static char[][] tempMap = new char[10][10];

	public static void main(String[] args) throws IOException {
		int ans = Integer.MAX_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {

			map[i] = br.readLine().toCharArray();

		}
		for (int i = 0; i < (1 << 10); i++) {
			int tempAns = 0;
			copyMap(tempMap, map);
			tempAns = simulation(i);
			if (isAllOff()) {
				ans = Math.min(ans, tempAns);
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	public static boolean isAllOff() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (tempMap[i][j] == 'O')
					return false;
			}
		}
		return true;
	}

	public static int simulation(int start) {
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			if ((start & (1 << i)) != 0) {
				turnSwitches(0, i);
				cnt++;
			}
		}
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (tempMap[i - 1][j] == 'O') {
					turnSwitches(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void turnSwitches(int posX, int posY) {
		tempMap[posX][posY] = turnSwitch(posX, posY);
		for (int i = 0; i < 4; i++) {
			int nx = posX + dx[i];
			int ny = posY + dy[i];
			if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10)
				tempMap[nx][ny] = turnSwitch(nx, ny);
		}
	}

	public static char turnSwitch(int posX, int posY) {
		if (tempMap[posX][posY] == '#')
			return 'O';
		else
			return '#';
	}

	public static void copyMap(char[][] target, char[][] origin) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				target[i][j] = origin[i][j];
			}
		}
	}
}