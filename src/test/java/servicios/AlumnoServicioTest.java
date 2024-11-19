package servicios;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AlumnoServicioTest {

    // Atributos
    private AlumnoServicioImp alumnoServicio;
    private AlumnoServicioImp alumnoServicioMock;
    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;


    // Metodo de Setup
    @BeforeEach
    public void setup() {
        // Inicializando las instancias
        alumnoServicio = new AlumnoServicioImp();
        alumnoServicioMock = mock(AlumnoServicioImp.class);
        MockitoAnnotations.openMocks(this);

//Inicializamos los objetos
        mapu = new Alumno("12345678", "Mapu");
        matematicas = new Materia(MateriaEnum.MATEMATICAS, Arrays.asList(7.0, 6.5, 5.0));
        lenguaje = new Materia(MateriaEnum.LENGUAJE, Arrays.asList(6.0, 7.5, 6.8));

    }
    // Prueba para el metodo crearAlumno
    @Test
    public void crearAlumnoTest() {
        alumnoServicio.crearAlumno(mapu);

        // Verifica que el alumno haya sido agregado correctamente al servicio
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertNotNull(alumnos);
        assertEquals(1, alumnos.size());
        assertTrue(alumnos.containsKey(mapu.getRut()));
        assertEquals(mapu, alumnos.get(mapu.getRut()));
    }

    // Prueba para el metodo agregarMateria
    @Test
    public void agregarMateriaTest() {
        alumnoServicio.crearAlumno(mapu);  // Primero creamos al alumno

        alumnoServicio.agregarMateria(mapu.getRut(), matematicas);  // Agregamos la materia

        List<Materia> materias = alumnoServicio.materiasPorAlumno(mapu.getRut());
        assertNotNull(materias);
        assertEquals(1, materias.size());
        assertEquals(matematicas, materias.get(0));
    }
    @Test
    public void materiasPorAlumnoTest() {
        // Mockeamos el comportamiento de materiasPorAlumno en el servicio
        when(alumnoServicioMock.materiasPorAlumno(mapu.getRut())).thenReturn(new ArrayList<>(List.of(matematicas, lenguaje)));


        // Llamamos al metodo que estamos probando
        List<Materia> materias = alumnoServicioMock.materiasPorAlumno(mapu.getRut());

        // Verificamos que el resultado no sea nulo
        assertNotNull(materias);

        // Verificamos que se hayan devuelto las materias correctas
        assertEquals(2, materias.size()); // Deben ser 2 materias
        assertTrue(materias.contains(matematicas)); // Verificamos que contenga Matemáticas
        assertTrue(materias.contains(lenguaje)); // Verificamos que contenga Lenguaje

        // Verificamos que el mock haya sido llamado con el rut del alumno
        verify(alumnoServicioMock).materiasPorAlumno(mapu.getRut());
    }


    // Prueba para el metodo listarAlumnos
    @Test
    public void listarAlumnosTest() {
        // Creamos los alumnos
        alumnoServicio.crearAlumno(mapu);
        Alumno alumno2 = new Alumno("12345678", "Mapu");
        alumnoServicio.crearAlumno(alumno2);

        //Obtener la lista de alumnos
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();

        // Verifica que se haya agregado correctamente
        assertNotNull(alumnos);
        assertEquals(1, alumnos.size());
        assertTrue(alumnos.containsKey(alumno2.getRut()));
    }
}






