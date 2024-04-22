package co.org.uniquindio.metodos;

public class NodoEntero {
    NodoEntero(int a) {
        valor = a;
        siguiente = null;
    }
    NodoEntero() {
        siguiente = null;
        valor = 0;
    }

    public int valor;
    public NodoEntero siguiente;
}