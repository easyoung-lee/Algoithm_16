class Solution {
    // 유클리드 호제법 
    public int solution(int[] arr) {
        int size = arr.length;
        int answer = 1;
        for (int i=0; i<size; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    public int gcd(int i, int j) {
        if(j==0)	return i;
        else return gcd(j, i%j);
    }
    
    public int lcm(int i, int j) {
        return i*j / gcd(i, j);
    }
}