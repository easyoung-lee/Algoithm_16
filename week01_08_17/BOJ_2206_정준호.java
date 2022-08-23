
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

// bfs 두번 : 시간 초과 
public class Main_G4_2206_정준호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][] map = new int[row][col];
		int[][] visited = new int[row][col];
		int[][] new_visited;
		
		visited[row-1][col-1] = -1;
		int result = 1231231231;
		
		for(int i=0; i<row; i++) {
			String[] s = br.readLine().split("");
			for(int j=0; j<col; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		int count = 1;

		int[] drow = {-1, 1, 0, 0};
		int[] dcol = {0, 0, -1, 1};
		Deque<int[]> BFS_Q = new ArrayDeque<>();
		Deque<int[]> new_BFS_Q = new ArrayDeque<>();
		
		BFS_Q.add(new int[] {0,0});
		visited[0][0] = 1;	// 방문체크
		
		while(!BFS_Q.isEmpty()) {
			int[] node = BFS_Q.pollFirst();
			for(int dir=0; dir<4; dir++) {
				boolean flag = true;
				boolean clear = false;
				int[] next_node = new int[] {node[0]+drow[dir], node[1]+dcol[dir]};
				// 경계 체크
				if(next_node[0] < 0 || next_node[0] >= row || next_node[1] < 0 || next_node[1] >= col) {
					continue;	
				}
				
				// 방문 했다면 continue
				if(visited[next_node[0]][next_node[1]] >= 1)	continue;
				
				
				if (map[next_node[0]][next_node[1]] == 0) {
					// 길 만났을 때
					BFS_Q.add(next_node);
					visited[next_node[0]][next_node[1]] = visited[node[0]][node[1]] + 1;
				} else if (map[next_node[0]][next_node[1]] == 1) {
					// 벽을 만났을 때
					if(!flag)	continue;
					flag = false;
					new_visited = new int[row][col];
					new_BFS_Q.add(next_node);
					new_visited[next_node[0]][next_node[1]] = visited[node[0]][node[1]] + 1;
					new_visited[node[0]][node[1]] = visited[node[0]][node[1]];
					
					while(!new_BFS_Q.isEmpty()) {
						int[] new_node = new_BFS_Q.pollFirst();
						for(int new_dir=0; new_dir<4; new_dir++) {
							int[] new_next_node = new int[] {new_node[0]+drow[new_dir], new_node[1]+dcol[new_dir]};
							// 경계 체크
							if(new_next_node[0] < 0 || new_next_node[0] >= row || new_next_node[1] < 0 || new_next_node[1] >= col) {
								continue;	
							}
							if(new_visited[new_next_node[0]][new_next_node[1]] >= 1)	continue;
							
							if (map[new_next_node[0]][new_next_node[1]] == 0) {
								// 길 만났을 때
								new_BFS_Q.add(new_next_node);
								new_visited[new_next_node[0]][new_next_node[1]] = new_visited[new_node[0]][new_node[1]] + 1;
								if(new_next_node[0] == row-1 && new_next_node[1] == col-1) {
									result = Math.min(result, new_visited[row-1][col-1]);
									if(result != 0) {
										System.out.println(result);
										return;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(-1);
	}	
	
}
