class Solution {
    public int solution(int n) {
        int answer = n+1;// 정답은 n보다 큰수
        int nCnt=0;//1의 갯수
      
		//n을 2진수로 바꿨을 때 1의 갯수 세기
		for (int i = 0; i < 19; i++) {	
			if ((n & 1 << i) != 0) {
				nCnt++;
			}
		}
        while(true){
            int temp =answer;
            int tempCnt=0;
			for (int i = 0; i < 19; i++) {	
				if ((temp & 1 << i) != 0) {
					tempCnt++;
				}
			}
            
            if(tempCnt==nCnt){
                return answer;
            }
            answer++;
        }
        
    }
}