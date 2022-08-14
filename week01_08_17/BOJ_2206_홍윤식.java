import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ_2206_홍윤식 {
    
    
    static int M,N;
    static int[][][] map;
    
    
    // BFS 탐색
    // 벽을 만나면 현재 노드가 0인 경우에만 이동
    // 이동 가능한 지역이면 현재 노드가 1인 경우 이동 가능 지역의 값을 1로 수정 후 진행
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz= new StringTokenizer(br.readLine());
        M=Integer.parseInt(stz.nextToken());
        N=Integer.parseInt(stz.nextToken());
        map= new int[M][N][2];
        
        for (int i = 0; i<M;i++){
            String[] temp = br.readLine().split("");
            for (int j=0;j<N;j++){
                map[i][j][0]=Integer.parseInt(temp[j]);
                map[i][j][1]=Integer.parseInt(temp[j]);
                
            }
        }
        int[] temp= {0,0,0};
        
        
        System.out.println(bfs(temp)-1);
        
    }
    private static int bfs(int[] pos){
        int[] dx ={-1,1,0,0};
        int[] dy ={0,0,-1,1};
        Queue<int[]> queue = new LinkedList<>();
        boolean isPossible =false;
        int ans=0;

        queue.offer(pos);
        map[pos[0]][pos[1]][0]=2;
        
        while(!queue.isEmpty()){
            
            
            int[] curNode= queue.poll();

            if(curNode[0]==M-1&&curNode[1]==N-1){
                ans=map[M-1][N-1][curNode[2]];
                isPossible=true;
                break;
            }
            for (int i =0;i<4;i++){
                int[] nextNode = {curNode[0]+dx[i],curNode[1]+dy[i],curNode[2]};
               
                if((nextNode[0]<0||nextNode[0]>=M||nextNode[1]<0||nextNode[1]>=N)) continue;
             
                //부순 경험 있음
                if(curNode[2]==1){
                    if(map[nextNode[0]][nextNode[1]][1]>=1) continue;
                    queue.offer(nextNode);
                    
                    map[nextNode[0]][nextNode[1]][1]= map[curNode[0]][curNode[1]][1]+1;
                    
            
                }else{ 
                    
                    if(map[nextNode[0]][nextNode[1]][0]==1){
                       
                        nextNode[2]=1;
                        queue.offer(nextNode);
                        map[nextNode[0]][nextNode[1]][1]= map[curNode[0]][curNode[1]][0]+1;

                    }else if(map[nextNode[0]][nextNode[1]][0]==0){
                        queue.offer(nextNode);
                        map[nextNode[0]][nextNode[1]][0]=map[curNode[0]][curNode[1]][0]+1;
                    }
                }
                
            }
           
        }
        if (!isPossible) ans=0;
        return ans;
    }
}
