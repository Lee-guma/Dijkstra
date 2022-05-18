package Dijkstra;

public class Main {
    public static void main(String[] args) {
        Graph g1 = new Graph(6);

        g1.add(1, 2, 5);
        g1.add(1, 4, 2);
        g1.add(1, 5, 4);
        g1.add(2, 3, 3);
        g1.add(2, 4, 3);
        g1.add(3, 4, 3);
        g1.add(3, 5, 4);
        g1.add(3, 6, 2);
        g1.add(4, 5, 1);
        g1.add(5, 6, 2);

        g1.dijkstra(1); // 시작노드는 1로 설정
    }
}
