import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225_홍윤식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int K = Integer.parseInt(stz.nextToken());

        6
        1   :   6
        2   :   0,6 6,0 1,5 5,1 2,4 4,2 3,3
        3   :   0,0,6 0,6,0 6,0,0 0,1,5 1,0,5 1,5,0 0,5,1 5,0,1 5,1,0 2  
    }
}
