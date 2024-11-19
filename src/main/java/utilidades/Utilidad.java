package utilidades;

import java.util.Scanner;

public class Utilidad {

    // Metodo para limpiar la pantalla (funciona en consola, dependiendo del sistema operativo)
    public static void limpiarPantalla() {
        try {
            // Limpia la pantalla de la consola, esto puede variar entre sistemas operativos.
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); // Secuencia ANSI para limpiar en UNIX
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla.");
        }
    }

    // Metodo para mostrar un mensaje
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Metodo para leer la entrada de un número entero
    public static int leerEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    // Metodo para leer la entrada de un String
    public static String leerCadena(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // Metodo para pausar y esperar una tecla para continuar
    public static void pausar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine();
    }
}

