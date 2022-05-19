package dijkstra;

public class Graph {
    private int n;           //노드들의 수
    private int matrix[][];    //노드들간의 가중치 저장할 변수

    public Graph(int n){
        this.n = n;
        matrix = new int[n+1][n+1];

    }
    public void add(int i,int j,int w){ // 간선(가중치) 추가
        matrix[i][j] = w;
        matrix[j][i] = w;
    }

    public void dijkstra(int v) {
        int distance[] = new int[n + 1];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n + 1];     //해당 노드를 방문했는지 체크할 변수

        // distance 값 초기화 : 최소 값으로 비교해 나갈꺼니까 초기 값은 무한대로 잡는다!
        for (int i = 1; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //시작노드값 초기화.
        distance[v] = 0;    // 자기 자신까지는 거리가 0
        check[v] = true;    // 자기 자신은 방문한 것

        // 시작 노드와 연결되어 있는 노드들의 distance 갱신
        for (int i = 1; i < n + 1; i++) {
            if (!check[i] && matrix[v][i] != 0) {   // 방문한적이 없고, 자기 자신(노드)이 아니면
                distance[i] = matrix[v][i];         // matrix 값 가져다가 저장, v행 -> 시작 노드와의 관계
            }
        }


        for (int i = 0; i < n - 1; i++) {
            // 정석 : 모든 노드가 true일 때까지
            // n개 노드 다익스트라 -> n-1번의 반복 필요

            int min = Integer.MAX_VALUE;    // 최소 비용을 저장할 변수
            int min_index = -1;             // 최소 비용을 가진 연결된 노드번호 저장할 변수

            //최소값 찾기
            for (int j = 1; j < n + 1; j++) {
                if (!check[j] && distance[j] != Integer.MAX_VALUE) {    // 방문한적이 없고 연결되어 있는 노드라면
                    if (distance[j] < min) {    // 비용이 최소비용보다 작으면 최소비용 변경
                        min = distance[j];
                        min_index = j;
                    }
                }
            }

            check[min_index] = true;        // 최소비용을 가진 노드는 선택해서 방문 했으니 true로 변경

            for (int k = 1; k < n + 1; k++) {
                if (!check[k] && matrix[min_index][k] != 0) {   // 방문한적이 없고 방금 연결한 노드(자기자신)가 아니면
                    // 방금 연결한 노드와 연결되어 있는 노드들 초기화
                    // 이전노드와 현재노드를 거쳐 다음노드로 갈 때의 비용이 이전노드에서 다음노드로 바로 갈때의 비용보다 적으면 갱신
                    if (distance[k] > distance[min_index] + matrix[min_index][k]) {
                        distance[k] = distance[min_index] + matrix[min_index][k];
                    }
                }
            }

        }

        //결과값 출력
        System.out.printf("------------------시작노드 %d에서 n노드까지의 최단경로------------------\n", v);
        for (int i = 1; i < n + 1; i++) {
            System.out.printf("~노드%d: ", i);
            System.out.print(distance[i] + ", ");
        }
        System.out.println("");
    }
}
