package run;

import resources.Grafo;

public class BFS {
    public static void main(String args[]) {
        Grafo g = new Grafo(4);

        g.agregarArista(0, 1);
        g.agregarArista(0, 2);
        g.agregarArista(1, 2);
        g.agregarArista(2, 0);
        g.agregarArista(2, 3);
        g.agregarArista(3, 3);

        System.out.println("BFS desde nodo 0");

        g.BFS(0);
    }
}