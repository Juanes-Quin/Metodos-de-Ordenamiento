package co.org.uniquindio.metodos;

public class RadixSort2 {

    private ColaEnlazada[] Q = {
            new ColaEnlazada(),
            new ColaEnlazada(),
            new ColaEnlazada(),
            new ColaEnlazada(),
            new ColaEnlazada(),
            new ColaEnlazada(),
            new ColaEnlazada(),
            new ColaEnlazada(),
            new ColaEnlazada(),
            new ColaEnlazada()};

    void sort(int[] a, int numeroDigitos) {
        int posArreglo;
        for (int i = 1; i< numeroDigitos; i++){
            posArreglo = 0;
            for (int j = 0; j < a.length; j++) {
                Q[obtenerRadical(a[j], i)].
                        encolar(a[j]);

            }
            for (int j = 0; j < Q.length; j++) {
                while (!Q[j].estaVacia()) {
                    a[posArreglo] = Q[j].decolar();
                    posArreglo++;
                }
            }
        }
    }

    void sort(int[] a) {
        int max = 0, maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                maxIndex = i;
            }
        }
        Integer maximo = Integer.valueOf(max);

        String cadena = String.valueOf(maximo);
        int numeroDigitos = cadena.length();
        sort(a, numeroDigitos);
    }
    int obtenerRadical(int numero,int radical){
        return (int)
                (numero/Math.pow(10, radical-1)) % 10;
    }
}



