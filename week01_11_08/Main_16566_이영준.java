import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16566_이영준 {

	static int n, m, k, arr[], parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[m];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		make();
		Arrays.sort(arr);
		st = new StringTokenizer(bf.readLine());
		int idx, t;
		for (int i = 0; i < k; i++) {
			t = Integer.parseInt(st.nextToken());
			idx = find(check(t));
			sb.append(arr[idx]).append("\n");
			union(idx, idx+1);
		}
		System.out.println(sb);

	}

	static void make() { // 크기가 1인 서로 소 집합 생성
		parents = new int[n];
		for (int i = 0; i < m; i++) { // 모든 노드가 자신을 부모로하는(대표자) 집합으로 만듦
			parents[i] = i;
		}
	}

	/*
	 * 2. findSet - root 노드를 찾는 기능
	 */
	static int find(int a) { // a의 대표자 찾기
		if (parents[a] == a)
			return a; // 초기 설정과 같으므로 내가 root인 경우

//		return find(parents[a]); //root를  찾아 리턴 ===> 편향 트리인 경우 속도가 느림 

		/*
		 * path compression : 우리의 대표자를 나의 부모로.. ==> find()를 호출하면 해당 depth에 있는 모든 노드의 부모가
		 * root로 변경됨 ==> rank가 1이 됨.
		 */
		return parents[a] = find(parents[a]); //
	}

	/*
	 * 3. unionSet 두 그룹을 합치는 기능 ->각 노드의 root를 찾아 같은 그룹이 아니면 join시킨다.
	 */
	static boolean union(int a, int b) { // 리턴값 : true ==> union 성공
		int aRoot = find(a);
		int bRoot = find(b);

//		두 노드의 root가 같으므로 같은 group  ==>같은 group의 두 노드를 연결하면 cycle이 됨. ==> 두 노드를 연결하면 안됨.  
		if (b >= m)
			return false;

		parents[aRoot] = bRoot;
		return true;
	}

	static int check(int x) {
		int s = 0;
		int e = m;
		while (s < e) {
			int mid = (s + e) / 2;
			if (arr[mid] > x) {
				e = mid;
			} else {
				s = mid + 1;
			}

		}
		return e;

	}
}
