package vistas;

import servicios.AlumnoServicioImp;
import servicios.ArchivosServicio;
import servicios.PromedioServicioImp;
import modelos.*;

public class Menu extends MenuTemplate {
    private AlumnoServicioImp alumnoServicio;
    private ArchivosServicio archivoServicio;
    private PromedioServicioImp promedioServicioImp;

    public Menu(AlumnoServicioImp alumnoServicio, ArchivosServicio archivoServicio) {
        this.alumnoServicio = alumnoServicio;
        this.archivoServicio = archivoServicio;
        this.promedioServicioImp = new PromedioServicioImp();
    }

    @Override
    public void exportarDatos() {
        System.out.print("Ingresa la ruta donde se exportarán los datos: ");
        String ruta = scanner.nextLine();
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
    }

    @Override
    public void crearAlumno() {
        System.out.println("--- Crear Alumno ---");
        System.out.print("Ingresa RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = scanner.nextLine();

        Alumno alumno = new Alumno(rut, nombre, apellido, direccion);
        alumnoServicio.crearAlumno(alumno);

        System.out.println("--- ¡Alumno agregado! ---");
    }

    @Override
    public void agregarMateria() {
        System.out.println("--- Agregar Materia ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rutAlumno = scanner.nextLine().trim();

        // Verificar si el RUT ingresado existe en el sistema de alumnos
        if (!alumnoServicio.listarAlumnos().containsKey(rutAlumno)) {
            // Si no se encuentra el RUT, mostrar un mensaje de error
            System.out.println("El RUT ingresado no corresponde a ningún alumno registrado.");
            return;  // Termina la ejecución del metodo si el RUT es incorrecto
        }

        System.out.println("Selecciona una Materia: ");
        for (int i = 0; i < MateriaEnum.values().length; i++) {
            System.out.println((i + 1) + ". " + MateriaEnum.values()[i]);
        }
        int opcionMateria = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Buscar el alumno en el servicio de alumnos
        Alumno alumno = alumnoServicio.listarAlumnos().get(rutAlumno);
        if (alumno != null) {
            // Crear la nueva materia y agregarla al alumno
            Materia materia = new Materia(MateriaEnum.values()[opcionMateria - 1]);
            alumno.getMaterias().add(materia);  // Añadir la materia a la lista de materias
            System.out.println("--- ¡Materia agregada! ---");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }


    @Override
    public void agregarNotaPasoUno() {
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rutAlumno = scanner.nextLine();

        // Verificamos si el alumno existe
        Alumno alumno = alumnoServicio.listarAlumnos().get(rutAlumno);
        if (alumno != null) {
            // Mostrar las materias del alumno
            System.out.println("Alumno tiene las siguientes materias agregadas:");
            for (int i = 0; i < alumno.getMaterias().size(); i++) {
                System.out.println((i + 1) + ". " + alumno.getMaterias().get(i).getNombre());
            }

            // Validar la opción de materia
            int materiaSeleccionada = -1;
            while (materiaSeleccionada < 1 || materiaSeleccionada > alumno.getMaterias().size()) {
                System.out.print("Seleccionar materia (1-" + alumno.getMaterias().size() + "): ");
                // Validar la entrada para evitar excepciones por un valor incorrecto
                if (scanner.hasNextInt()) {
                    materiaSeleccionada = scanner.nextInt();
                    if (materiaSeleccionada < 1 || materiaSeleccionada > alumno.getMaterias().size()) {
                        System.out.println("Por favor, selecciona una materia válida.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor ingresa un número entero.");
                    scanner.next(); // Limpiar el buffer en caso de que la entrada no sea un número
                }
            }

            // Limpiar el buffer después de usar nextInt()
            scanner.nextLine();

            // Seleccionamos la materia y pedimos la nota
            Materia materia = alumno.getMaterias().get(materiaSeleccionada - 1);
            double nota = -1;
            while (nota < 1 || nota > 7) { // Nota debe estar entre 1 y 7
                System.out.print("Ingresar nota para " + materia.getNombre() + " (1-7): ");
                if (scanner.hasNextDouble()) {
                    nota = scanner.nextDouble();
                    if (nota < 0 || nota > 7) {
                        System.out.println("Por favor, ingresa una nota entre 1 y 7.");
                    }
                } else {
                    System.out.println("Entrada no válida. Por favor ingresa un número decimal.");
                    scanner.next(); // Limpiar el buffer
                }
            }

            // Limpiar el buffer después de usar nextDouble()
            scanner.nextLine();

            // Agregar la nota a la materia
            materia.getNotas().add(nota);
            System.out.println("--- ¡Nota agregada a " + materia.getNombre() + "! ---");

        } else {
            System.out.println("Alumno no encontrado.");
        }
    }


    @Override
    public void listarAlumnos() {
        System.out.println("--- Listar Alumnos ---");
        for (Alumno alumno : alumnoServicio.listarAlumnos().values()) {
            System.out.println("Datos Alumno");
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            System.out.println("Materias");
            for (Materia materia : alumno.getMaterias()) {
                System.out.println(materia.getNombre());
                System.out.println("Notas: " + materia.getNotas());
            }
        }
    }

    @Override
    public void terminarPrograma() {
        System.out.println("¡Programa terminado!");
    }
}
