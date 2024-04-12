package co.org.uniquindio.metodos;

import java.util.ArrayList;
import java.util.Collections;

public class PigeonholeSort {

    public static void sort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int range, i, j, index;

        // Encuentra los valores mínimo y máximo en el arreglo
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
            if (a < min) {
                min = a;
            }
        }

        // Calcula el rango de valores en el arreglo
        range = max - min + 1;

        // Crea las 'casillas' para cada valor en el rango
        ArrayList<ArrayList<Integer>> holes = new ArrayList<>(range);
        for (i = 0; i < range; i++) {
            holes.add(new ArrayList<>());
        }

        // Coloca cada elemento en su casilla correspondiente
        for (i = 0; i < arr.length; i++) {
            holes.get(arr[i] - min).add(arr[i]);
        }

        index = 0;

        // Recolecta los elementos de cada casilla y colócalos de nuevo en el arreglo original
        for (i = 0; i < range; i++) {
            Collections.sort(holes.get(i));  // Ordena cada lista en caso de colisiones
            for (j = 0; j < holes.get(i).size(); j++) {
                arr[index++] = holes.get(i).get(j);
            }
        }
    }
}

