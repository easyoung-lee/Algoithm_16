import java.util.Arrays;
	
class Solution {
    public int solution(int n) {
        int[] arr = new int[20];
        int result = 0;
        for(int i=0; i<20; i++) {
            arr[i] = (n & (1<<i))>>i;
        }
        int count = 0;
        for(int i=0; i<19; i++) {
            if(arr[i] == 1)	
                count++;
            if(arr[i] > arr[i+1]) {	// ~~10~~ -> ~~01~~	
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                for(int j=0; j<i; j++) {
                    if(j<count-1)		arr[j] = 1;
                    else			arr[j] = 0;
                }
                break;
            }
        }

        for(int i=0; i<20; i++) {
            result += arr[i]<<i;
        }

        return result;
    }
}