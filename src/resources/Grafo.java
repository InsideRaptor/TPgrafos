package resources;

import java.util.*;

public class Grafo {
    private int V;
    private LinkedList<Integer> adyacentes[];

    // Inicializar grafo
    public Grafo(int v) {
        V = v;
        adyacentes = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adyacentes[i] = new LinkedList();
    }


    // Agregar aristas al grafo
    public void agregarArista(int v, int w) {
        adyacentes[v].add(w);
    }

    // BFS
    public void BFS(int vert) {

        boolean visitados[] = new boolean[V];

        LinkedList<Integer> cola = new LinkedList();

        visitados[vert] = true;
        cola.add(vert);

        while (cola.size() != 0) {
            vert = cola.poll();
            System.out.print(vert + " ");

            Iterator<Integer> i = adyacentes[vert].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visitados[n]) {
                    visitados[n] = true;
                    cola.add(n);
                }
            }
        }
    }

    // Prim
    public void Prim(int G[][], int V) {

        int INF = 9999999;

        int cant_aristas;

        // inicializar un array para seguir
        // los vertices seleccionados
        // cuando se seleccionan se convierten en true
        boolean[] seleccionado = new boolean[V];

        // set seleccionados a falso
        Arrays.fill(seleccionado, false);

        cant_aristas = 0;

        // La cantidad de aristas en un ARMC siempre será
        // menos que (n -1), n siendo el número de vertices en el grafo

        // seleccionar vertice 0 y hacerlo true
        seleccionado[0] = true;

        System.out.println("Arista : Peso");

        while (cant_aristas < V - 1) {
            // Para cada arista en el set S, encontrar todos los vertices
            // adyacentes, calcular la distancia desde el vertice seleccionado.
            // Si el vertice ya está en el set S, descartarlo. Si no, elegir otro
            // vertice cercano al seleccionado.

            int min = INF;
            int x = 0; // numero fila
            int y = 0; // numero columna

            for (int i = 0; i < V; i++) {
                if (seleccionado[i] == true) {
                    for (int j = 0; j < V; j++) {
                        // no en seleccionados y tiene arista
                        if (!seleccionado[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + G[x][y]);
            seleccionado[y] = true;
            cant_aristas++;
        }
    }
}