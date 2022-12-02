package resources.impl;

import resources.apis.GrafoTDA;

//Grafo Lista Adyacente

public class GrafoLA implements GrafoTDA {
    NodoGrafo origen;

    public GrafoLA() {
    }

    public void inicializarGrafo() {
        this.origen = null;
    }

    public void agregarVertice(int v) {
        NodoGrafo aux = new NodoGrafo();
        aux.nodo = v;
        aux.arista = null;
        aux.sigNodo = this.origen;
        this.origen = aux;
    }

    public void agregarArista(int v1, int v2, int peso) {
        NodoGrafo n1 = this.Vert2Nodo(v1);
        NodoGrafo n2 = this.Vert2Nodo(v2);
        NodoArista aux = new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    private NodoGrafo Vert2Nodo(int v) {
        NodoGrafo aux;
        for(aux = this.origen; aux != null && aux.nodo != v; aux = aux.sigNodo) {
        }

        return aux;
    }

    public void eliminarVertice(int v) {
        if (this.origen.nodo == v) {
            this.origen = this.origen.sigNodo;
        }

        for(NodoGrafo aux = this.origen; aux != null; aux = aux.sigNodo) {
            this.EliminarAristaNodo(aux, v);
            if (aux.sigNodo != null && aux.sigNodo.nodo == v) {
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
        }

    }

    private void EliminarAristaNodo(NodoGrafo nodo, int v) {
        NodoArista aux = nodo.arista;
        if (aux != null) {
            if (aux.nodoDestino.nodo == v) {
                nodo.arista = aux.sigArista;
            } else {
                while(aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v) {
                    aux = aux.sigArista;
                }

                if (aux.sigArista != null) {
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }

    }

    public void eliminarArista(int v1, int v2) {
        NodoGrafo n1 = this.Vert2Nodo(v1);
        this.EliminarAristaNodo(n1, v2);
    }

    public boolean existeArista(int v1, int v2) {
        NodoGrafo n1 = this.Vert2Nodo(v1);

        NodoArista aux;
        for(aux = n1.arista; aux != null && aux.nodoDestino.nodo != v2; aux = aux.sigArista) {
        }

        return aux != null;
    }

    public int pesoArista(int v1, int v2) {
        NodoGrafo n1 = this.Vert2Nodo(v1);

        NodoArista aux;
        for(aux = n1.arista; aux.nodoDestino.nodo != v2; aux = aux.sigArista) {
        }

        return aux.etiqueta;
    }

    class NodoArista {
        int etiqueta;
        NodoGrafo nodoDestino;
        NodoArista sigArista;

        NodoArista() {
        }
    }

    class NodoGrafo {
        int nodo;
        NodoArista arista;
        NodoGrafo sigNodo;

        NodoGrafo() {
        }
    }
}
