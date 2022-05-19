package dijkstra;

public class Main {
    public static void main(String[] args) {

        // case 1. 노드 여섯 개, 시작노드 1
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
        System.out.println();

        // case 2. 노드 8개, 시작노드 1
        Graph g2 = new Graph(8);
        g2.add(1, 2, 3);
        g2.add(1, 5, 4);
        g2.add(1, 4, 4);
        g2.add(2, 3, 2);
        g2.add(3, 4, 1);
        g2.add(4, 5, 2);
        g2.add(5, 6, 4);
        g2.add(4, 7, 6);
        g2.add(7, 6, 3);
        g2.add(3, 8, 3);
        g2.add(6, 8, 2);
        g2.dijkstra(1);
        System.out.println();

        // case 2. 노드 8개, 시작노드 4
        Graph g3 = new Graph(8);
        g3.add(1, 2, 3);
        g3.add(1, 5, 4);
        g3.add(1, 4, 4);
        g3.add(2, 3, 2);
        g3.add(3, 4, 1);
        g3.add(4, 5, 2);
        g3.add(5, 6, 4);
        g3.add(4, 7, 6);
        g3.add(7, 6, 3);
        g3.add(3, 8, 3);
        g3.add(6, 8, 2);
        g3.dijkstra(4);

    }
}
