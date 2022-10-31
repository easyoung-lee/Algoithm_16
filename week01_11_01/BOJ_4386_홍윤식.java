package week01_11_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_홍윤식 {

    public static class Edge implements Comparable<Edge> {
        int node;
        double dis;

        public Edge(int node, double dis) {
            this.node = node;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dis, o.dis);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double ans = 0;
        int cnt = 0;
        double[][] data = new double[N][2];
        StringTokenizer stz;
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            data[i][0] = Double.parseDouble(stz.nextToken());
            data[i][1] = Double.parseDouble(stz.nextToken());
        }
        PriorityQueue<Edge> pqueue = new PriorityQueue<>();
        boolean[] visit = new boolean[N];

        pqueue.add(new Edge(0, 0));
        while (!pqueue.isEmpty()) {
            Edge edge = pqueue.poll();
            if (visit[edge.node])
                continue;
            visit[edge.node] = true;
            ans += edge.dis;
            for (int i = 0; i < N; i++) {
                if (i == edge.node)
                    continue;
                pqueue.add(new Edge(i, Math.sqrt(
                        Math.pow(data[edge.node][0] - data[i][0], 2) + Math.pow(data[edge.node][1] - data[i][1], 2))));

            }
            if (++cnt == N)
                break;
        }
        System.out.printf("%.2f", ans);
    }
}
