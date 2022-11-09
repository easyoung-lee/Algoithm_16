package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G2_1202_보석도둑 {

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long result = 0;
		
		int[][] jewel_list = new int[N][2];
		int[] bag_list = new int[K];
		PriorityQueue<Integer> bag = new PriorityQueue<>(N, (Integer a, Integer b)->{return b-a;});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewel_list[i][0] = Integer.parseInt(st.nextToken());
			jewel_list[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < K; i++) {
			bag_list[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bag_list);	// 작은 것부터
		Arrays.sort(jewel_list, (int[] a, int[] b) -> {	// 무게 가벼운것 부터, 가치 큰 것부터
			return (a[0]==b[0]) ? b[1]-a[1] : a[0]-b[0];
		});
		
		int idx = 0;
		for (int[] jewel : jewel_list) {
			while(true) {
				if(bag_list[idx] < jewel[0]) {	// 못 넣는다 -> 다음 가방으로
					if(!bag.isEmpty())
						result += bag.poll();		// 꺼내고 결과값 누적
					idx++;
					if(idx==K) {	// 모든 가방에 다 넣었다 -> 끝
						System.out.println(result);
						return;
					}
				} else {	// 넣을 수 있는 상황이면 무한루프 탈출하고 가방에 넣으러
					break;
				}
			}
			bag.add(jewel[1]);
		}
		
		while(idx++ < K) {	// 가방 탐색이 안끝난 경우... pq가 비거나 가방 탐색이 끝날때까지 더해주기
			if(bag.isEmpty())	break;
			result += bag.poll();
		}
		System.out.println(result);
	}
	
}
