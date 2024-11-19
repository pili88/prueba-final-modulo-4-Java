package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AlumnoServicioImp implements AlumnoServicio {
    private Map<String, Alumno> listaAlumnos = new HashMap<>();

    @Override
    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);
    }

    @Override
    public void agregarMateria(String rutAlumno, Materia materia) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            if (alumno.getMaterias() == null) {
                alumno.setMaterias(new ArrayList<>());  // Inicializar la lista si es null
            }
            alumno.getMaterias().add(materia);
        }
    }

    @Override
    public List<Materia> materiasPorAlumno(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        return alumno != null ? alumno.getMaterias() : null;
    }

    @Override
    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }
}