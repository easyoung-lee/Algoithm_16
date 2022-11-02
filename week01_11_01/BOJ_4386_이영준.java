import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_4386_이영준 {

	static class Pair {
		double x, y;
		int n;

		public Pair(double x, double y, int n) {
			super();
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from, to;
		double w;

		public Edge(int from, int to, double w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (w < o.w) {
				return -1;
			}
			return 1;
		}
	}

	static int V, E;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(bf.readLine());
		Pair[] pairs = new Pair[V];
		
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			pairs[i] = new Pair(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()), i);
		}

		ArrayList<Edge> edgeList = new ArrayList<>();
		
		for (int i = 0; i < V-1; i++) {
			for (int j = i+1; j < V; j++) {
				edgeList.add(new Edge(i, j, Math.sqrt(Math.pow(pairs[i].x - pairs[j].x, 2) + Math.pow(pairs[i].y - pairs[j].y, 2))));
			}
		}

		make();
		Collections.sort(edgeList);

		double result = 0;
		int count = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.w;
				if (++count == V - 1)
					break;
			}
		}
		System.out.println(result);
	}

	static void make() { // 크기가 1인 서로 소 집합 생성

		parents = new int[V];
		for (int i = 0; i < V; i++) { // 모든 노드가 자신을 부모로하는(대표자) 집합으로 만듦
			parents[i] = i;
		}
	}

	static int find(int a) { // a의 대표자 찾기
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]); // 우리의 대표자를 나의 부모로.. : path compression
	}

	static boolean union(int a, int b) { // 리턴값 : true ==> union 성공
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

}