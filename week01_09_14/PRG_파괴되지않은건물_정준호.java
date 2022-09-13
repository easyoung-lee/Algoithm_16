import java.util.*;

// 효율성 all fail
class Solution {

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        Arrays.sort(skill,(int[] a, int[] b) -> { 
            if(a[1] == b[1] && a[2] == b[2] && a[4] == b[4])
                return a[3] - b[3];
            else if(a[1] == b[1] && a[2] == b[2])
                return a[4] - b[4];
            else if(a[2] == b[2])
                return a[1] - b[1];
            else
                return a[2] - b[2];
        });

        int r = board.length;
        int c = board[0].length;

        PriorityQueue<int[]>[] pqList = new PriorityQueue[r];
        ArrayList<int[]> skillList = new ArrayList<>();
        int[] sum = new int[r];

        for (int[] s : skill) {
            skillList.add(s);
        }

        // 행 별로 pq 생성
        for (int i = 0; i < r; i++) {
            pqList[i] = new PriorityQueue<>((int[] a, int[] b) -> {
                return a[0] - b[0];	// 끝나는 열 기준 최소 큐
            });
        }

        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                // pq에 넣기
                for (int[] s : skillList) {
                    // 시작 열
                    if(s[2] > j)	break;
                    if(s[2] == j && s[1] <= i && i <= s[3])	{
                        // {끝나는 열, 개수, 타입}
                        pqList[i].add(new int[] {s[4], s[5], s[0]});
                        if(s[0] == 1)	sum[i] += s[5];
                        else			sum[i] -= s[5];
                    }
                }
                // 파괴됐는지 확인
                if(sum[i] < board[i][j])	answer++;

                // pq에서 끝난 열 빼주기
                while(true) {
                    if(pqList[i].isEmpty())				break;
                    else if(pqList[i].peek()[0] != j)	break;
                    else {
                        if(pqList[i].peek()[2] == 1)	sum[i] -= pqList[i].poll()[1];
                        else						 	sum[i] += pqList[i].poll()[1];

                    }
                }
            }
            // 모든 행 순회 후 지난 skill 정리
            while(true) {
                if (skillList.size() == 0)			break;
                else if(skillList.get(0)[2] != j)	break;
                else								skillList.remove(0);
            }
        }

        return answer;
    }
}