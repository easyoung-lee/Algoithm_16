

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16566_홍윤식 {
	static int[] redCards;
	static int[] parents;

	static public void init(int n) {
		parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}
	}

	static public int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static public boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb)
			return false;
		parents[pb] = pa;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		int M = Integer.parseInt(stz.nextToken());
		int K = Integer.parseInt(stz.nextToken());
		redCards = new int[M];
		init(N);
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			redCards[i] = Integer.parseInt(stz.nextToken());
		}
		Arrays.sort(redCards);
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int play = Integer.parseInt(stz.nextToken());
			if (find(play) == play) {
				for (int j = 0, end = redCards.length; j < end; j++) {
					if (redCards[j] > play) {
						union(j, play);
						System.out.println(redCards[j]);
						break;
					}
				}

			} else {
				int j = find(play);
				union(j + 1, play);
				System.out.println(redCards[j + 1]);
			}
		}

	}

}
