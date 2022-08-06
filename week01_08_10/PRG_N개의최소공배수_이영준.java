package hw_0806;

public class PRG_N개의최소공배수_이영준 {

	public static int Uclid(int a, int b) {		// (재귀)유클리드 호제법 GCD(b, a%b) (a%b == 0)? b:GCD(b, a%b)
		if (a % b == 0) {
			return b;
		}

		return Uclid(b, a % b);
	}

	public int solution(int[] arr) {
		int answer = arr[0];
		int n = arr.length;
		if (n != 1) {
			for (int i = 1; i < n; i++) {		// 반복문으로 arr 인덱스 순으로 최대공약수 갱신 -> 최소공배수(answer) 구해주기
				if (answer > arr[i]) {
					answer = answer * arr[i] / Uclid(answer, arr[i]);
				} else {
					answer = answer * arr[i] / Uclid(arr[i], answer);
				}
			}
		}
		return answer;
	}
}
