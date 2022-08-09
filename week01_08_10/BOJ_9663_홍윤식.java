import java.util.Scanner;

public class BOJ_9663_홍윤식 {
    static int ans =0;
    static int N;
    static boolean[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map=new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[0][i]=true;
            dfs(0,i);
            map[0][i]=false;
        }
        System.out.println(ans);

    }
    static void dfs(int curRow, int curColumn){
        if(!isPossible(curRow,curColumn)) return;
        if(curRow==N-1){
            ans++;
            return;
        }
        for (int i=0;i<N;i++){
            map[curRow+1][i]=true;
            dfs(curRow+1,i);
            map[curRow+1][i]=false;
        }
    }
    static boolean isPossible(int curRow,int curColumn){
        for(int i =0;i<curRow;i++){
            if(map[i][curColumn]) return false;
        }
        int dx =(-1);
        int dy =(-1);
        int ndx= curRow+dx;
        int ndy=curColumn+dy;
        while(ndx>=0&&ndy>=0){
            if(map[ndx][ndy]) return false;
            ndx+=dx;
            ndy+=dy;
        }
        dy=1;
        ndx= curRow+dx;
        ndy=curColumn+dy;
        while(ndx>=0&&ndy<N){
            if(map[ndx][ndy]) return false;
            ndx+=dx;
            ndy+=dy;
        }
        return true;
    }
}
