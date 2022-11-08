package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G1_16566_카드게임 {

	static boolean[] visited;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] list = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		int max = list[M-1];
		parents = new int[max+1];
		visited = new boolean[max+1];
		for (int i = 0; i < max; i++) {
			parents[i] = i;
		}
		
		
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			if(i == list[idx])	idx++;
			if(idx == M)		break;
			parents[i] = list[idx];
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int k = Integer.parseInt(st.nextToken());
			int result = find(k);
			visited[k] = true;
			System.out.println(result);
		}
		
	}

	private static int find(int k) {
		if(!visited[k])	return parents[k];
		return parents[k] = find(parents[k]);
	}
}
