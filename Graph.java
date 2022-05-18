package Dijkstra;

import java.sql.SQLOutput;

public class Graph {
    private int n;           //노드들의 수
    private int matrix[][];    //노드들간의 가중치 저장할 변수

    public Graph(int n){
        this.n = n;
        matrix = new int[n+1][n+1];

    }
    public void add(int i,int j,int w){
        matrix[i][j] = w;
        matrix[j][i] = w;
    }

    public void dijkstra(int v) {
        int distance[] = new int[n + 1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n + 1];     //해당 노드를 방문했는지 체크할 변수

        //distance값 초기화.
        for (int i = 1; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //시작노드값 초기화.
        distance[v] = 0;
        check[v] = true;

        //연결노드 distance갱신
        for (int i = 1; i < n + 1; i++) {
            if (!check[i] && matrix[v][i] != 0) {
                distance[i] = matrix[v][i];
            }
        }


        for (int i = 0; i < n - 1; i++) {
            // 정석 : 모든 노드가 true일 때까지
            // n개 노드 다익스트라 -> n-1번의 반복 필요

            int min = Integer.MAX_VALUE;
            int min_index = -1;

            //최소값 찾기
            for (int j = 1; j < n + 1; j++) {
                if (!check[j] && distance[j] != Integer.MAX_VALUE) {
                    if (distance[j] < min) {
                        min = distance[j];
                        min_index = j;
                    }
                }
            }

            check[min_index] = true;
            for (int k = 1; k < n + 1; k++) {
                if (!check[k] && matrix[min_index][k] != 0) {
                    if (distance[k] > distance[min_index] + matrix[min_index][k]) {
                        distance[k] = distance[min_index] + matrix[min_index][k];
                    }
                }
            }

        }

        //결과값 출력
        for (int i = 1; i < n + 1; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println("");
    }
}
