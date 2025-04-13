public class BinarySearch {

    // Método para realizar la búsqueda binaria
    public int binarySearch(int[] arr, int lo, int hi, int x) {
        // Verificar si el rango es válido
        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2; // Calcular el índice medio

            // Si el elemento medio es igual al buscado, devolver el índice
            if (arr[mid] == x) {
                return mid;
            }

            // Si el elemento medio es mayor que el buscado, buscar en la mitad izquierda
            if (arr[mid] > x) {
                return binarySearch(arr, lo, mid - 1, x);
            }

            // Si el elemento medio es menor que el buscado, buscar en la mitad derecha
            return binarySearch(arr, mid + 1, hi, x);
        }

        // Si el elemento no se encuentra, devolver -1
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch searcher = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5}; // Arreglo ordenado
        int x = 4; // Elemento a buscar

        int position = searcher.binarySearch(arr, 0, arr.length - 1, x); // Llamada al método de búsqueda

        // Mostrar el resultado
        if (position == -1) {
            System.out.println("Elemento no encontrado.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + position);
        }
    }
}
