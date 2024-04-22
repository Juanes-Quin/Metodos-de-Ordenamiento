package co.org.uniquindio.metodos;

import java.util.ArrayList;

/*
* Algoritmo basado de https://www.geeksforgeeks.org/tree-sort/?ref=header_search
 */

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int item) {
        value = item;
        left = right = null;
    }
}

public class TreeSort {

    private TreeNode root;

    // Constructor
    public TreeSort() {
        root = null;
    }

    // Función para insertar un nuevo nodo con una clave dada en el árbol de búsqueda binario
    private TreeNode insertRec(TreeNode root, int key) {
        // Si el árbol está vacío, retorna un nuevo nodo
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        // De lo contrario, recorre hacia abajo el árbol
        if (key < root.value) {
            root.left = insertRec(root.left, key);
        } else if (key > root.value) {
            root.right = insertRec(root.right, key);
        }

        // retorna el puntero del nodo (sin cambios)
        return root;
    }

    // Método para insertar un valor
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Una función para hacer recorrido inorden del árbol de búsqueda binario
    private void inorderRec(TreeNode root, ArrayList<Integer> res) {
        if (root != null) {
            inorderRec(root.left, res);
            res.add(root.value);
            inorderRec(root.right, res);
        }
    }

    // Método que retorna la lista ordenada de elementos
    public ArrayList<Integer> treeSort(int[] arr) {
        for (int x : arr) {
            insert(x);
        }
        ArrayList<Integer> sorted = new ArrayList<>();
        inorderRec(root, sorted);
        return sorted;
    }
}
