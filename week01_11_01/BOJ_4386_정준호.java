package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G3_4386_별자리만들기 {

	static int N;
	static double[][] star_pos;
	static List<Double[]> dist;
	static double result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new ArrayList<Double[]>(N*N/2);
		star_pos = new double[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			star_pos[i][0] = Double.parseDouble(st.nextToken());
			star_pos[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				double dist_x = star_pos[i][0] - star_pos[j][0];
				double dist_y = star_pos[i][1] - star_pos[j][1];
				double d = Math.sqrt(dist_x*dist_x + dist_y*dist_y);
				dist.add(new Double[] {(double)i, (double)j, d});
			}
		}
		
		dist.sort((Double[] a, Double[] b) -> {return (int)(a[2]*1000) - (int)(b[2]*1000);});
		
		make();
		
		int count = 0;
		int s = dist.size();
		for (int i = 0; i < s; i++) {
			Double[] info = dist.get(i);
			int a = Integer.parseInt(String.valueOf(Math.round(info[0])));
			int b = Integer.parseInt(String.valueOf(Math.round(info[1])));
			if(union(a, b)) {
				count++;
				result += info[2];
				if(count == N-1)	break;
			}
		}
		
		System.out.println(Math.round(result*100)/100.0);
		
		

	}

	static int[] parents;
	private static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a])		return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)	return false;
		parents[aRoot] = bRoot;
		return true;
	}

}
