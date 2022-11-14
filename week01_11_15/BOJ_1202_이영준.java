import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_이영준 {

	static class Pair implements Comparable<Pair> {
		int w, v;

		public Pair(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Pair o) {
			if(w == o.w) {
				return Integer.compare(o.v, v);
			}
			return Integer.compare(w, o.w);
		}

	}

	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		long result = 0;
		PriorityQueue<Pair> queue_1 = new PriorityQueue<>(); // 종류별 보석의 정보 관리 (무게, 가치)
		PriorityQueue<Integer> queue_2 = new PriorityQueue<>(); // 가방에 담을 수 있는 보석의 최대무게 관리
		PriorityQueue<Integer> queue_3 = new PriorityQueue<>(Collections.reverseOrder()); // 현재 가방에 넣을 수 있는 보석의 가치 관리 

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			queue_1.offer(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for (int i = 0; i < k; i++) {
			queue_2.offer(Integer.parseInt(bf.readLine()));
		}

		int tar = 0;
		while (!queue_2.isEmpty()) {
			tar = queue_2.poll();
			while (!queue_1.isEmpty()) {
				Pair curPair = queue_1.poll();
				if (tar < curPair.w) {
					queue_1.offer(curPair);
					break;
				} else {
					queue_3.offer(curPair.v);
				}
			}
			if(!queue_3.isEmpty()) {
				result += queue_3.poll();				
			}
		}

		System.out.println(result);
	}
}
