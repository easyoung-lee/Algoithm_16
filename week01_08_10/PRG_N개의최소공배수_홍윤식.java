class PRG_N개의최소공배수_홍윤식{
   
    public int solution(int[] arr) {
        int ans =0;
        int arrSize = arr.length;
        Arrays.sort(arr);
        ans=lcm(arr[0],arr[1]);
        for(int i=1;i<arr.length;i++){
           ans=lcm(ans,arr[i]);
        }
        return ans;
    }
    //어떤 n개의 수의 최대공배수는 n-1개의 수의 최대공배수와 n번째 수의 최대 공배수
    int lcm(int x,  int y){
      return x*y/gcd(x,y);
    }

    int gcd(int x,int y){
        if(x%y==0){
            return y;
        }
        return gcd(y,x%y);
    }
}