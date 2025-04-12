public class Hanoi {
    public static void main(String[] args) {
        torresHanoi(5, 1, 2, 3); // Llamada al método con 3 discos
    }

    // Creando el método recursivo para la solución de las torres de Hanoi
    public static void torresHanoi(int discos, int torre1, int torre2, int torre3) {
        // Caso base
        if (discos == 1) {
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
        } else {
            // Mover discos - 1 a la torre auxiliar
            torresHanoi(discos - 1, torre1, torre3, torre2);
            // Mover el disco restante a la torre de destino
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
            // Mover los discos de la torre auxiliar a la torre de destino
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }
}