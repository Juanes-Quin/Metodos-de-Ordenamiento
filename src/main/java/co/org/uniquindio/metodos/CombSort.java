package co.org.uniquindio.metodos;

/*
 * Algoritmo basado de https://www.geeksforgeeks.org/comb-sort/?ref=header_search
 * This code is contributed by Rajat Mishra
 */

public class CombSort {

    // Función para encontrar el nuevo gap entre los elementos
    private static int getNextGap(int gap) {
        // Reducción del gap por el factor de contracción
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }

    // Función principal para ordenar el array utilizando Comb Sort
    public static void sort(int[] arr) {
        int n = arr.length;
        int gap = n;

        // Inicializar swapped como true para asegurar que el bucle comienza
        boolean swapped = true;

        // Continuar ejecutando mientras el gap es mayor que 1 y se haya intercambiado al menos un elemento
        while (gap != 1 || swapped) {
            // Encuentra el próximo gap
            gap = getNextGap(gap);

            swapped = false;

            // Comparar todos los elementos con el gap actual
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Intercambiar arr[i] y arr[i + gap]
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    // Establecer swapped
                    swapped = true;
                }
            }
        }
    }
}

