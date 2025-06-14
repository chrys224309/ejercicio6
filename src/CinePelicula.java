/* Programa para llevar inventario de productos
   Hecho por: Chrystian VIera 31.418.023
   Materia: Programación II UBA */


import java.util.Scanner;

/**
 * Clase principal con el método main para interactuar con el usuario
 */
public class CinePelicula {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Cine cine = new Cine();
            
            System.out.println("BIENVENIDO AL CINE");
            System.out.println("==================");
            
            // Mostrar cartelera
            cine.mostrarCartelera();
            
            // Seleccionar película
            System.out.print("\nSeleccione una película (1-4): ");
            int pelicula = sc.nextInt() - 1; // Convertir a índice 0-3
            
            // Seleccionar horario
            System.out.println("\nHorarios disponibles:");
            System.out.println("1. Matinee (10% descuento)");
            System.out.println("2. Tarde");
            System.out.println("3. Noche (15% descuento)");
            System.out.print("Seleccione horario (1-3): ");
            int horario = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            
            // Tipo de usuario
            System.out.print("\nTipo de usuario (niño/adulto/adulto mayor): ");
            String tipoUsuario = sc.nextLine();
            
            // Cantidad de entradas
            System.out.print("Cantidad de entradas: ");
            int cantidad = sc.nextInt();
            
            // Generar factura
            cine.generarFactura(pelicula, horario, tipoUsuario, cantidad);
            
            System.out.println("\n¡Disfrute de la película!");
        }
    }

}