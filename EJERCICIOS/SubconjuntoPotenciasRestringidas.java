import java.util.ArrayList;
import java.util.List;

public class SubconjuntoPotenciasRestringidas {

    public static boolean verificarSubconjunto(int[] arr, int objetivo) {
        List<Integer> obligatorios = new ArrayList<>();
        List<Integer> permitidosMultiplosDe5 = new ArrayList<>();
        List<Integer> otros = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i];
            if ((num > 0) && ((num & (num - 1)) == 0)) { // Verificar si es potencia de 2
                obligatorios.add(num);
            } else if (num % 5 == 0) {
                // Verificar la restricción del múltiplo de 5
                if (i + 1 < arr.length - 1 && arr[i + 1] % 2 == 0) {
                    // Si es múltiplo de 5 y el siguiente no es impar, no se incluye
                } else {
                    permitidosMultiplosDe5.add(num);
                }
            } else {
                otros.add(num);
            }
        }

        int ultimoNumero = arr[arr.length - 1];

        // Intentar formar la suma objetivo incluyendo los números obligatorios
        List<Integer> conjuntoActual = new ArrayList<>(obligatorios);
        int sumaActual = 0;
        for (int num : conjuntoActual) {
            sumaActual += num;
        }

        // Función recursiva para encontrar el subconjunto
        return encontrarSubconjuntoRecursivo(otros, permitidosMultiplosDe5, ultimoNumero, objetivo, conjuntoActual, sumaActual);
    }

    private static boolean encontrarSubconjuntoRecursivo(List<Integer> otros, List<Integer> permitidosMultiplosDe5, int ultimoNumero, int objetivo, List<Integer> conjuntoActual, int sumaActual) {
        // Caso base: se alcanzó el objetivo
        if (sumaActual == objetivo) {
            return true;
        }

        // Caso base: no se puede alcanzar el objetivo con los números restantes
        if (sumaActual > objetivo) {
            return false;
        }

        // Probar incluyendo el último número si aún no está en el conjunto
        if (!conjuntoActual.contains(ultimoNumero)) {
            conjuntoActual.add(ultimoNumero);
            if (encontrarSubconjuntoRecursivo(new ArrayList<>(otros), new ArrayList<>(permitidosMultiplosDe5), ultimoNumero, objetivo, conjuntoActual, sumaActual + ultimoNumero)) {
                return true;
            }
            conjuntoActual.remove(conjuntoActual.size() - 1); // Backtrack
        }

        // Probar incluyendo otros números
        for (int i = 0; i < otros.size(); i++) {
            int num = otros.get(i);
            if (!conjuntoActual.contains(num)) {
                conjuntoActual.add(num);
                List<Integer> restantesOtros = new ArrayList<>(otros);
                restantesOtros.remove(i);
                if (encontrarSubconjuntoRecursivo(restantesOtros, new ArrayList<>(permitidosMultiplosDe5), ultimoNumero, objetivo, conjuntoActual, sumaActual + num)) {
                    return true;
                }
                conjuntoActual.remove(conjuntoActual.size() - 1); // Backtrack
            }
        }

        // Probar incluyendo múltiplos de 5 permitidos
        for (int i = 0; i < permitidosMultiplosDe5.size(); i++) {
            int num = permitidosMultiplosDe5.get(i);
            if (!conjuntoActual.contains(num)) {
                conjuntoActual.add(num);
                List<Integer> restantesMultiplosDe5 = new ArrayList<>(permitidosMultiplosDe5);
                restantesMultiplosDe5.remove(i);
                if (encontrarSubconjuntoRecursivo(new ArrayList<>(otros), restantesMultiplosDe5, ultimoNumero, objetivo, conjuntoActual, sumaActual + num)) {
                    return true;
                }
                conjuntoActual.remove(conjuntoActual.size() - 1); // Backtrack
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Casos de prueba
        int[][] entradas = {
                {5, 4, 8, 10, 3, 6, 27}, // Modificado para el nuevo caso
                {6, 2, 16, 5, 7, 10, 33},
                {6, 2, 16, 5, 3, 10, 33},
                {4, 2, 5, 1, 6, 13}
        };
        int[] objetivos = {27, 33, 33, 13};

        for (int i = 0; i < entradas.length; i++) {
            System.out.println("Entrada: " + java.util.Arrays.toString(entradas[i]) + ", Salida: " + verificarSubconjunto(entradas[i], objetivos[i]));
        }

        // Caso de prueba adicional de la imagen
        int[] entradaExtra1 = {5, 4, 8, 10, 3, 6, 27};
        int objetivoExtra1 = 27;
        System.out.println("Entrada: " + java.util.Arrays.toString(entradaExtra1) + ", Salida: " + verificarSubconjunto(entradaExtra1, objetivoExtra1));

        int[] entradaExtra2 = {6, 2, 16, 5, 7, 10, 33};
        int objetivoExtra2 = 33;
        System.out.println("Entrada: " + java.util.Arrays.toString(entradaExtra2) + ", Salida: " + verificarSubconjunto(entradaExtra2, objetivoExtra2));

        int[] entradaExtra3 = {6, 2, 16, 5, 3, 10, 33};
        int objetivoExtra3 = 33;
        System.out.println("Entrada: " + java.util.Arrays.toString(entradaExtra3) + ", Salida: " + verificarSubconjunto(entradaExtra3, objetivoExtra3));
    }
}