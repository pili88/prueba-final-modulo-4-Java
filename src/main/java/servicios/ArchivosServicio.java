package servicios;

import modelos.Alumno;
import modelos.Materia;
import java.io.*;
import java.util.Map;

public class ArchivosServicio {
    private PromedioServicioImp promedioServicioImp;

    public ArchivosServicio() {
        promedioServicioImp = new PromedioServicioImp();
    }


public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta + "/promedios.txt"))) {
        for (Alumno alumno : alumnos.values()) {
            writer.write("Alumno : " + alumno.getRut() + " - " + alumno.getNombre() + "\n");
            for (Materia materia : alumno.getMaterias()) {
                double promedio = promedioServicioImp.calcularPromedio(materia.getNotas());
                writer.write("Materia: " + materia.getNombre() + " - Promedio: " + promedio + "\n");
            }
        }
        writer.flush();
        System.out.println("Datos exportados correctamente.");
    } catch (IOException e) {
        System.out.println("Error al exportar los datos: " + e.getMessage());
    }
}
}