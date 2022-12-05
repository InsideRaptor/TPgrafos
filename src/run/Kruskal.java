package run;

import resources.GrafoK;

public class Kruskal {
    public static void main(String[] args) {
        int vertices = 6; // Cantidad vertices
        int aristas = 8; // Cantidad aristas
        GrafoK G = new GrafoK(vertices, aristas);

        G.arista[0].src = 0;
        G.arista[0].dest = 1;
        G.arista[0].peso = 4;

        G.arista[1].src = 0;
        G.arista[1].dest = 2;
        G.arista[1].peso = 4;

        G.arista[2].src = 1;
        G.arista[2].dest = 2;
        G.arista[2].peso = 2;

        G.arista[3].src = 2;
        G.arista[3].dest = 3;
        G.arista[3].peso = 3;

        G.arista[4].src = 2;
        G.arista[4].dest = 5;
        G.arista[4].peso = 2;

        G.arista[5].src = 2;
        G.arista[5].dest = 4;
        G.arista[5].peso = 4;

        G.arista[6].src = 3;
        G.arista[6].dest = 4;
        G.arista[6].peso = 3;

        G.arista[7].src = 5;
        G.arista[7].dest = 4;
        G.arista[7].peso = 3;

        G.Kruskal();

    }
}