/*
 * brute force로 푼경우... 시간초과 발생 / 해설 참고 이후 누적합 방법 이해..
 */
public class PRG_파괴되지않은건물_이영준 {
	public int solution(int[][] board, int[][] skill) {
		int answer = board.length * board[0].length;
		for (int i = 0, end = skill.length; i < end; i++) {
			if (skill[i][0] == 1) { // 적 공격
				for (int j = skill[i][1]; j <= skill[i][3]; j++) {
					for (int k = skill[i][2]; k <= skill[i][4]; k++) {
						int before = board[j][k];
						board[j][k] -= skill[i][5];						
						if(before>0 && board[j][k]<=0) {
							answer--;
						}
					}
				}
			} else { // 아군 스킬
				for (int j = skill[i][1]; j <= skill[i][3]; j++) {
					for (int k = skill[i][2]; k <= skill[i][4]; k++) {
						int before = board[j][k];
						board[j][k] += skill[i][5];						
						if(before<=0 && board[j][k]>0) {
							answer++;
						}
					}
				}
			}
		}
		return answer;
	}
}
