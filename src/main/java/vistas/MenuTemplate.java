package vistas;

import utilidades.Utilidad;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    public abstract void exportarDatos();
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();

    public void iniciarMenu() {
        boolean continuar = true;
        while (continuar) {
            Utilidad.limpiarPantalla();
            Utilidad.mostrarMensaje("=== MENÚ PRINCIPAL ===");
            Utilidad.mostrarMensaje("1. Crear Alumnos");
            Utilidad.mostrarMensaje("2. Listar Alumnos");
            Utilidad.mostrarMensaje("3. Agregar Materias");
            Utilidad.mostrarMensaje("4. Agregar Notas");
            Utilidad.mostrarMensaje("5. Exportar Datos");
            Utilidad.mostrarMensaje("6. Salir");
            Utilidad.mostrarMensaje("Elige una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        crearAlumno();
                        break;
                    case 2:
                        listarAlumnos();
                        break;
                    case 3:
                        agregarMateria();
                        break;
                    case 4:
                        agregarNotaPasoUno();
                        break;
                    case 5:
                        exportarDatos();
                        break;
                    case 6:
                        terminarPrograma();
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
            }
        }
