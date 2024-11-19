package servicios;

import modelos.Alumno;
import modelos.Materia;
import java.util.List;
import java.util.Map;

public interface AlumnoServicio {
    void crearAlumno(Alumno alumno);
    void agregarMateria(String rutAlumno, Materia materia);
    List<Materia> materiasPorAlumno(String rutAlumno);
    Map<String, Alumno> listarAlumnos();
}

