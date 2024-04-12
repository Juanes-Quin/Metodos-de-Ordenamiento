package co.org.uniquindio.metodos;

public class HeapSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        // Construir heap (reorganizar el array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extraer elementos uno por uno del heap
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // llamar a max heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }

    // Para heapificar un subárbol enraizado en el índice i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Inicializar el más grande como raíz
        int left = 2 * i + 1; // hijo izquierdo
        int right = 2 * i + 2; // hijo derecho

        // Si el hijo izquierdo es más grande que la raíz
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Si el hijo derecho es más grande que el mayor hasta ahora
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Si el más grande no es la raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Heapify recursivamente el subárbol afectado
            heapify(arr, n, largest);
        }
    }
}
