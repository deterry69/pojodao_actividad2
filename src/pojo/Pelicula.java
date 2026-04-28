package pojo;

public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private int duracion;
    private double presupuesto;

    public Pelicula() {}
    public Pelicula(String titulo, String genero, int duracion, double presupuesto) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.presupuesto = presupuesto;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(double presupuesto) { this.presupuesto = presupuesto; }

    @Override
    public String toString() {
        return "ID: " + id + " | " + titulo + " (" + genero + ") | " + duracion + "min | " + presupuesto + "€";
    }
}
