package co.org.uniquindio.metodos;

/* Algoritmo basado de https://www.geeksforgeeks.org/timsort/?ref=header_search
* This code has been contributed by 29AjayKumar
*/
public class TimSort {

    private static final int RUN = 32; // tamaño óptimo para subarrays

    // Utiliza insertion sort para ordenar arr[l..r]
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Función para fusionar los subarrays arr[l..m] y arr[m+1..r]
    private static void merge(int[] arr, int l, int m, int r) {
        // Tamaños de los subarrays a fusionar
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];

        System.arraycopy(arr, l, left, 0, len1);
        System.arraycopy(arr, m + 1, right, 0, len2);

        int i = 0, j = 0, k = l;

        // Fusionar los subarrays temporalmente en arr[l..r]
        while (i < len1 && j < len2) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }

        // Copiar los elementos restantes de left[], si hay
        while (i < len1) {
            arr[k++] = left[i++];
        }

        // Copiar los elementos restantes de right[], si hay
        while (j < len2) {
            arr[k++] = right[j++];
        }
    }

    public static void sort(int[] arr) {
        int n = arr.length;

        // Ordenar subarrays individuales de tamaño RUN
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));
        }

        // Comenzar a fusionar desde el tamaño RUN (o 32). Doblaremos el tamaño para cada iteración
        for (int size = RUN; size < n; size = 2 * size) {
            // Elegir el punto de partida de los subarrays izquierdo y derecho
            for (int left = 0; left < n; left += 2 * size) {
                // Encontrar el punto final del subarray izquierdo
                // El punto de partida del subarray derecho es mid+1
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                // Fusionar el subarray arr[left..mid] y arr[mid+1..right]
                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }
}

