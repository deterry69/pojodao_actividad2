import dao.PeliculaDAO;
import dao.ActorDAO;
import pojo.Pelicula;
import pojo.Actor;

public class Main {
    public static void main(String[] args) {
        // Inicializamos los DOS Daos por separado
        PeliculaDAO peliculaDao = new PeliculaDAO();
        ActorDAO actorDao = new ActorDAO();

        System.out.println("=== PRUEBAS PELÍCULAS (CRUD) ===");
        Pelicula p = new Pelicula("Peli Nueva", "Terror", 120, 1000000);
        peliculaDao.insertar(p);
        p.setTitulo("Peli MODIFICADA");
        peliculaDao.actualizar(p, 11);
        peliculaDao.borrar(11);
        System.out.println("CRUD Películas terminado.\n");

        System.out.println("=== CONSULTAS PELÍCULAS ===");
        System.out.println("Películas con su conteo de actores:");
        peliculaDao.obtenerConTotalActores();

        System.out.println("\nTop 3 Presupuesto:");
        for (Pelicula pel : peliculaDao.obtenerTop3Presupuesto()) {
            System.out.println(pel);
        }

        System.out.println("\n=== PRUEBAS ACTORES ===");
        Actor a = new Actor("Actor Test", "España", 30);
        actorDao.insertar(a);

        System.out.println("Asignando actor a película...");
        actorDao.asignarAPelicula(1, 1, "Protagonista");

        System.out.println("\nNúmero de actores por nacionalidad:");
        actorDao.obtenerConteoNacionalidad();

        System.out.println("\nEdad media de los actores: " + actorDao.obtenerEdadMedia());
    }
}