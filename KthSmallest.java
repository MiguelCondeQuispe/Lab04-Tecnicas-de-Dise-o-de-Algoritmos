import java.util.Arrays;
import java.util.Random;

public class KthSmallest {

    public static int kthSmallest(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("El valor de k está fuera de rango.");
        }
        return quickSelect(arr, 0, arr.length - 1, k - 1); // k-1 porque los índices son base 0
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Elegir un pivote aleatorio para un mejor rendimiento promedio
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1) + low;
        swap(arr, pivotIndex, high);
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 7, 10, 4, 17, 3};
        int k1 = 3;
        System.out.println("El " + k1 + "-ésimo elemento más pequeño en " + Arrays.toString(arr1) + " es: " + kthSmallest(arr1, k1)); // Salida: 4

        int[] arr2 = {4, 2, 7, 10, 4, 1, 6, 5};
        int k2 = 5;
        System.out.println("El " + k2 + "-ésimo elemento más pequeño en " + Arrays.toString(arr2) + " es: " + kthSmallest(arr2, k2)); // Salida: 4 (o 5, dependiendo de la implementación de la partición para elementos iguales)

        int[] arr3 = {4, 2, 7, 1, 4, 6};
        int k3 = 1;
        System.out.println("El " + k3 + "-ésimo elemento más pequeño en " + Arrays.toString(arr3) + " es: " + kthSmallest(arr3, k3)); // Salida: 1

        int[] arr4 = {9, 2, 7, 1, 7};
        int k4 = 4;
        System.out.println("El " + k4 + "-ésimo elemento más pequeño en " + Arrays.toString(arr4) + " es: " + kthSmallest(arr4, k4)); // Salida: 7
    }
}