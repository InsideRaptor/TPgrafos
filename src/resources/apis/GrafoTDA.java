//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package resources.apis;

public interface GrafoTDA {
    void inicializarGrafo();

    void agregarVertice(int var1);

    void eliminarVertice(int var1);

    void agregarArista(int var1, int var2, int var3);

    void eliminarArista(int var1, int var2);

    boolean existeArista(int var1, int var2);

    int pesoArista(int var1, int var2);
}
