package week01_11_15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_홍윤식 {
    static int N, K;

    static class Jewel implements Comparable<Jewel> {
        int M;
        int V;

        Jewel(int M, int V) {
            this.M = M;
            this.V = V;
        }

        @Override
        public int compareTo(Jewel o) {
            if (this.M == o.M)
                return o.V - this.V;
            return this.M - o.M;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        long ans = 0;
        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        PriorityQueue<Jewel> Jewels = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stz.nextToken());
            int V = Integer.parseInt(stz.nextToken());
            Jewels.add(new Jewel(M, V));
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < K; i++) {
            for (int j = 0, end = Jewels.size(); j < end; j++) {
                Jewel jewel = Jewels.poll();
                if (jewel.M <= bags[i]) {
                    pQueue.offer(jewel.V);
                } else {
                    Jewels.offer(jewel);
                    break;
                }
            }
            if (!pQueue.isEmpty()) {
                ans += pQueue.poll();
            }
        }
        System.out.println(ans);
    }
}
