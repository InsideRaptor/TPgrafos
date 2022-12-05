package run;

import resources.Grafo;

public class Prim {
    public static void main(String[] args) {
        Grafo g = new Grafo(5);

        // Número vertices en grafo
        int V = 5;

        // Array 2d de 5x5 para matriz de adyacencia para representar gráfico
        int[][] G = {{0, 9, 75, 0, 0},
                    {9, 0, 95, 19, 42},
                    {75, 95, 0, 51, 66},
                    {0, 19, 51, 0, 31},
                    {0, 42, 66, 31, 0}};

        g.Prim(G, V);

    }
}

