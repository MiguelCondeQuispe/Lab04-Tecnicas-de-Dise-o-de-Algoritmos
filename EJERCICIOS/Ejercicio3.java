package EJERCICIOS;

public class Ejercicio3 {
    public static int costoMinimo(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    C[i][j] = 0;
                } else {
                    C[i][j] = T[i][j];
                    for (int k = i + 1; k < j; k++) {
                        C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                    }
                }
            }
        }
        return C[0][n - 1];
    }
    public static void main(String[] args) {
        int[][] T = {
            {0, 3, 10, 2000},
            {0, 0, 2, 95},
            {0, 0, 0, 6},
            {0, 0, 0, 0}
        };
        System.out.println("Costo minimo del embarcadero 0 al " + (T.length - 1) + ": " + costoMinimo(T)); 
    }
}

