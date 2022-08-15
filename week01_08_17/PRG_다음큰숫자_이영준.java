package hw_0811;

public class PRG_다음큰숫자_이영준 {

	public int solution(int n) {
		int answer = 0, count = 0, tmp = 0;

		for (int i = 0; i < 7; i++) {			// 비트마스크로 n의 이진수에 포함된 1의 개수 구하기
			if ((n & 1 << i) != 0) {
				count++;
			}
		}

		for (int i = n + 1; ; i++) {			// n+1을 해가면서 n의 이진수의 포함된 1의 개수와 같은 수 구하기
			for (int j = 0; j < 7; j++) {
				if ((i & 1 << j) != 0) {
					tmp++;
				}
			}
			if(tmp == count) {					// 찾았다면 break & return answer..
				answer = i;
				break;
			}else {
				tmp = 0;
			}
		}

		return answer;
	}
}
