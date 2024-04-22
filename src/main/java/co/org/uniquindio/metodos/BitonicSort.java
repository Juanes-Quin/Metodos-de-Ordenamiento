package co.org.uniquindio.metodos;

/*
* Algoritmo basado de https://www.geeksforgeeks.org/bitonic-sort/?ref=header_search
 */

public class BitonicSort {

    // Método para intercambiar elementos
    private static void compAndSwap(int[] arr, int i, int j, int dir) {
        if ((arr[i] > arr[j] && dir == 1) || (arr[i] < arr[j] && dir == 0)) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Método recursivo para realizar el sort bitónico
    private static void bitonicMerge(int[] arr, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                compAndSwap(arr, i, i + k, dir);
            }
            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low + k, k, dir);
        }
    }

    // Función que primero produce un bitonic y luego lo ordena
    public static void bitonicSort(int[] arr, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;

            // Ordenar en orden ascendente, dir=1
            bitonicSort(arr, low, k, 1);

            // Ordenar en orden descendente, dir=0
            bitonicSort(arr, low + k, k, 0);

            // Fusionar la secuencia bitónica entera en orden ascendente o descendente
            bitonicMerge(arr, low, cnt, dir);
        }
    }

    // Método de utilidad para manejar el sort bitónico para un array de tamaño n
    public static void sort(int[] arr, boolean up) {
        bitonicSort(arr, 0, arr.length, up ? 1 : 0);
    }
}
