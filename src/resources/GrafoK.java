package resources;

import java.util.*;

public class GrafoK {
    public class Arista implements Comparable<Arista> {
        public int src;
        public int dest;
        public int peso;

        public int compareTo(Arista compararArista) {
            return this.peso - compararArista.peso;
        }
    }

    // Union
    class subset {
        int parent, rank;
    }

    int vertices, aristas;
    public Arista[] arista;

    // Inicializar grafo
    public GrafoK(int v, int a) {
        vertices = v;
        aristas = a;
        arista = new Arista[aristas];
        for (int i = 0; i < a; ++i)
            arista[i] = new Arista();
    }

    int Buscar(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = Buscar(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xraiz = Buscar(subsets, x);
        int yraiz = Buscar(subsets, y);

        if (subsets[xraiz].rank < subsets[yraiz].rank)
            subsets[xraiz].parent = yraiz;
        else if (subsets[xraiz].rank > subsets[yraiz].rank)
            subsets[yraiz].parent = xraiz;
        else {
            subsets[yraiz].parent = xraiz;
            subsets[xraiz].rank++;
        }
    }

    // Kruskal
    public void Kruskal() {
        Arista resultado[] = new Arista[vertices];
        int a = 0;
        int i = 0;
        for (i = 0; i < vertices; ++i)
            resultado[i] = new Arista();

        // Ordenando las aristas
        Arrays.sort(arista);
        subset subsets[] = new subset[vertices];
        for (i = 0; i < vertices; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (a < vertices - 1) {
            Arista sig_arista;
            sig_arista = arista[i++];
            int x = Buscar(subsets, sig_arista.src);
            int y = Buscar(subsets, sig_arista.dest);
            if (x != y) {
                resultado[a++] = sig_arista;
                Union(subsets, x, y);
            }
        }
        for (i = 0; i < a; ++i)
            System.out.println(resultado[i].src + " - " + resultado[i].dest + ": " + resultado[i].peso);
    }
}