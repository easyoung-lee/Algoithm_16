
import java.util.Arrays;
import java.util.Scanner;

public class Main_G4_9663_NQueen {
	
	static int N;
	static int[] queen;
	static boolean[] check;
	static int count=0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queen = new int[N];
		check = new boolean[N];
		perm(0);
		System.out.println(count);
	}
	
	public static void perm(int cnt) {
		if(cnt==N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			boolean flag = false;
			if(check[i]==true)	continue;	// 같은 열 체크
			for(int q=cnt-1, k=1; q>=0; q--, k++) {		// 직전 행 퀸 배치까지 검열
				if(cnt==0)	break;
				if(queen[q] == i-k) {	// 대각선 체크1
					flag = true;
					break;
				}
				if(queen[q] == i+k) {	// 대각선 체크2
					flag = true;
					break;
				}
			}	
			if(flag) continue;
			
			// cnt행 i열 -> 퀸 배치
			queen[cnt] = i;
			check[i] = true;
			perm(cnt+1);
			check[i] = false;
			
		}
	}
}
