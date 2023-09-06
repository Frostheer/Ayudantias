import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String [][] salaCine;

        salaCine = generarSalaCine(5,5);

        mostrarAsientosCine(salaCine);

        elegirOpcionMenu(salaCine);

    }
    public static String[][] generarSalaCine(int filas, int columnas) {
        String[][] matriz = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (j + 1) + Character.toString((char) ('a' + i));
            }
        }

        return matriz;
    }

    public static void mostrarAsientosCine(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("|" + matriz[i][j] + "|");
            }
            System.out.println();
        }
    }
    public static void mostrarMenu(){
        System.out.println("---- Menú ----");
        System.out.println("1. Ver asientos disponibles");
        System.out.println("2. Comprar/Reservar asiento");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void elegirOpcionMenu(String[][] salaCine){

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> mostrarAsientosCine(salaCine);
                case 2 -> comprarReservarAsiento(sc, salaCine);
                case 3 -> {
                    cierreCine(salaCine);
                    System.out.println("Cerrando el programa. Adiós.");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (opcion != 3);
    }
    private static void comprarReservarAsiento(Scanner scanner, String[][] salaCine) {

        System.out.print("Ingrese el número de fila (1-5): ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese la letra de la columna (a-e): ");
        char letraColumna = scanner.next().charAt(0);

        if (fila >= 1 && fila <= 5 && letraColumna >= 'a' && letraColumna <= 'e') {

            // Convierte la letra de la columna en un número (1-5)
            int columna = letraColumna - 'a' + 1;

            if (!Objects.equals(salaCine[fila - 1][columna - 1], "X")) {
                salaCine[fila - 1][columna - 1] = "X";
                System.out.println("Asiento " + fila + letraColumna + " comprado/reservado con éxito.");
            } else {
                System.out.println("Lo siento, el asiento " + fila + letraColumna + " ya está ocupado.");
            }
        } else {
            System.out.println("Fila o columna fuera de rango.");
        }
    }

    public static void cierreCine(String[][] salaCine){

        salaCine = generarSalaCine(5,5);

        mostrarAsientosCine(salaCine);

    }




}
