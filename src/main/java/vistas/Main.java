package vistas;

import servicios.AlumnoServicioImp;
import servicios.ArchivosServicio;
import servicios.PromedioServicioImp;

public class Main {
    public static void main(String[] args) {
        // Instanciar los servicios
        AlumnoServicioImp alumnoServicio = new AlumnoServicioImp();
        PromedioServicioImp promedioServicioImp = new PromedioServicioImp();
        ArchivosServicio archivosServicio = new ArchivosServicio();

        // Crear instancia del menú
        Menu menu = new Menu(alumnoServicio, archivosServicio);

        // Iniciar el menú
        menu.iniciarMenu();
    }
}
