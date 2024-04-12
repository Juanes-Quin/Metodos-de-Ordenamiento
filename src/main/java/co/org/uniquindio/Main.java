package co.org.uniquindio;

import co.org.uniquindio.metodos.*;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;
import java.util.*;

public class Main {

    private static final int ARRAY_SIZE = 10000;  // Ajusta este tamaño según lo que desees probar
    private static final Random random = new Random();

    public static void main(String[] args) {

        Map<String, Double> executionTimes = new LinkedHashMap<>();

        int[] originalArray = generateRandomArray(ARRAY_SIZE);

        //Pruebas y almacenamiento de reusltados
        // Prueba TimSort
        executionTimes.put("TimSort", testSort(Arrays.copyOf(originalArray, originalArray.length), TimSort::sort));

        // Prueba CombSort
        executionTimes.put("CombSort", testSort(Arrays.copyOf(originalArray, originalArray.length), CombSort::sort));

        // Prueba HeapSort
        executionTimes.put("HeapSort", testSort(Arrays.copyOf(originalArray, originalArray.length), HeapSort::sort));

        // Prueba TreeSort
        executionTimes.put("TreeSort", testSort(Arrays.copyOf(originalArray, originalArray.length), array -> {
            TreeSort treeSort = new TreeSort();
            treeSort.treeSort(array);
        }));

        // Prueba PigeonholeSort
        //executionTimes.put("PigeonholeSort", testSort(Arrays.copyOf(originalArray, originalArray.length), PigeonholeSort::sort));

        // Prueba BitonicSort
        executionTimes.put("BitonicSort", testSort(Arrays.copyOf(originalArray, originalArray.length), array -> BitonicSort.sort(array, true)));

        // Prueba GnomeSort
        executionTimes.put("GnomeSort", testSort(Arrays.copyOf(originalArray, originalArray.length), GnomeSort::sort));

        //Visualizacion de los resultados
        displayChart(executionTimes);
    }

    // Método para generar un array de enteros aleatorios
    private static int[] generateRandomArray(int size) {
        return random.ints(size, 10000000, 100000000).toArray();
    }

    // Método para probar los algoritmos de ordenamiento

    private static double testSort(int[] array, Consumer<int[]> sortMethod) {
        long startTime = System.nanoTime();
        sortMethod.accept(array);
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000.0;
    }

    private static void displayChart(Map<String, Double> executionTimes) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Ordenar de mayor a menor antes de añadir al dataset
        executionTimes.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(e -> dataset.addValue(e.getValue(), "Tiempo de Ejecucion", e.getKey()));

        JFreeChart barChart = ChartFactory.createBarChart(
                "Comparacion Metodos de Ordenamiento",
                "Algoritmo",
                "Tiempo (Milisegundos)",
                dataset);

        ChartPanel chartPanel = new ChartPanel(barChart);
        JFrame frame = new JFrame();
        frame.setContentPane(chartPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
