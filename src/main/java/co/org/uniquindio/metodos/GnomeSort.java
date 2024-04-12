package co.org.uniquindio.metodos;

public class GnomeSort {

    public static void sort(int[] arr) {
        int index = 0;

        while (index < arr.length) {
            if (index == 0 || arr[index] >= arr[index - 1]) {
                index++; // Avanza si el elemento actual es mayor que el anterior
            } else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--; // Retrocede si el elemento actual es menor que el anterior
            }
        }
    }
}
