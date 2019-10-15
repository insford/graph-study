package graphstudy.dmgkeke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wedding {
    public static void main(String[] args) {
        FastScanner scan = new FastScanner();
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] graph = new int[n+1][n+1];
        int[] f = new int[n+1];
        int result = 0;

        for (int i = 0 ; i < m ; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int i = 2 ; i <= n ; i++) {
            if( graph[1][i] == 1 ) {
                f[i] = 1;
                for (int j = 2 ; j <= n ; j++) {
                    if( graph[i][j] == 1 ) {
                        f[j] = 1;
                    }
                }
            }
        }

        for (int i = 2; i <= n ; i++) {
            result += f[i];
        }

        System.out.println(result);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            if( st == null || !st.hasMoreTokens() ) {
                st = new StringTokenizer(readLine());
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        String readLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return str;
        }

    }
}

