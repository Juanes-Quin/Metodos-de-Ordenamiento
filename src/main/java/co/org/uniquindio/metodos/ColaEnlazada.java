package co.org.uniquindio.metodos;

public class ColaEnlazada {
    private NodoEntero inicio;
    private NodoEntero fin;
    private int tamano;
    ColaEnlazada() {
        inicio = null;
        fin = null;
        tamano = 0;
    }
    public void encolar(int num) {
        tamano++;
        NodoEntero temp = new NodoEntero(num);
        if (inicio == null) {
            inicio = temp;
            fin = inicio;
        }
        else {
            fin.siguiente = temp;
            fin = temp;
        }
        temp = null;
    }
    public int decolar() {
        tamano--;
        int temp = inicio.valor;
        NodoEntero nodoTemp;
        nodoTemp = inicio;
        inicio = inicio.siguiente;
        nodoTemp = null;
        return temp;
    }
    public boolean estaVacia() {
        return (tamano == 0);
    }
}