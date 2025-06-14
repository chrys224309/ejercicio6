public class Pelicula {
    // Atributos de la película
    String titulo;      // Título de la película (
    int sala;          // Número de sala (1-4)
    double precioBase; // Precio base de la entrada
    

    public Pelicula(String titulo, int sala, double precioBase) {
        this.titulo = titulo;
        this.sala = sala;
        this.precioBase = precioBase;
    }
    
     // Muestra la información de la película
     
    public void mostrarInfo() {
        System.out.println("Película: " + titulo);
        System.out.println("Sala: " + sala);
        System.out.println("Precio base: $" + precioBase);
    }
}