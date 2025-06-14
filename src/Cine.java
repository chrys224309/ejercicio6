import java.util.ArrayList;

public class Cine {
    // Lista de películas disponibles
    ArrayList<Pelicula> cartelera = new ArrayList<>();

    public Cine() {
        // Añadimos las películas disponibles
        cartelera.add(new Pelicula("Lilo y Stitch", 1, 5.50));
        cartelera.add(new Pelicula("Bambi", 2, 5.00));
        cartelera.add(new Pelicula("Cómo entrenar a tu Dragón", 3, 6.00));
        cartelera.add(new Pelicula("Misión: Imposible", 4, 7.50));
    }

    public void mostrarCartelera() {
        System.out.println("\n--- CARTELERA ---");
        for(int i = 0; i < cartelera.size(); i++) {
            System.out.print((i+1) + ". ");
            cartelera.get(i).mostrarInfo();
            System.out.println("------------");
        }
    }
    
    public double calcularPrecio(int indicePelicula, int horario, String tipoUsuario, int cantidad) {
        double precio = cartelera.get(indicePelicula).precioBase;
        double descuento = 0;
        
        // Descuento por tipo de usuario
        switch(tipoUsuario.toLowerCase()) {
            case "niño" -> descuento += 0.30; // 30% descuento
            case "adulto mayor" -> descuento += 0.50;
        }
        
        // Descuento por horario
        switch(horario) {
            case 1 -> // Matinee
                descuento += 0.10; // 10% adicional
            case 3 -> // Noche
                descuento += 0.15;

        }
        // Aplicar descuentos
        double precioConDescuento = precio * (1 - descuento) * cantidad;
        
        // Agregar IVA (16%)
        return precioConDescuento * 1.16;
    }

    public void generarFactura(int indicePelicula, int horario, String tipoUsuario, int cantidad) {
        
        Pelicula pelicula = cartelera.get(indicePelicula);
        double total = calcularPrecio(indicePelicula, horario, tipoUsuario, cantidad);
        
        System.out.println("\n=== FACTURA ===");
        System.out.println("Película: " + pelicula.titulo);
        System.out.println("Sala: " + pelicula.sala);
        System.out.println("Horario: " + obtenerHorario(horario));
        System.out.println("Tipo de usuario: " + tipoUsuario);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("TOTAL: $" + String.format("%.2f", total));
        System.out.println("===============");
    }
    private String obtenerHorario(int horario) {
        return switch (horario) {
            case 1 -> "Matinee (10%)";
            case 2 -> "Tarde";
            case 3 -> "Noche (15%)";
            default -> "Desconocido";
        };
    }
}