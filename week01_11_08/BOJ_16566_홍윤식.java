
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16566_홍윤식 {
	static int[] redCards;
	static int[] parents;
	static int M;

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

	static public int binarySearch(int target) {
		int s = 0;
		int e = M;
		while (s < e) {
			int mid = (s + e) / 2;
			if (redCards[mid] > target)
				e = mid;
			else
				s = mid + 1;
		}
		return e;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		int K = Integer.parseInt(stz.nextToken());
		redCards = new int[M];
		init(M);
		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			redCards[i] = Integer.parseInt(stz.nextToken());
		}
		Arrays.sort(redCards);

		stz = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int play = Integer.parseInt(stz.nextToken());
			int j = binarySearch(play);

			System.out.println(redCards[find(j)]);
			int p = find(j);
			union(p + 1, p);

		}

	}

}
