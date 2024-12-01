import controller.ControlAlumno;
import controller.ControlProfesor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControlAlumno controlAlumno = new ControlAlumno();
        ControlProfesor controlProfesor = new ControlProfesor();

        int opcion = 0;
        System.out.println("""
                        ╔══════════════════════════════════════════╗
                        ║          MENU PRINCIPAL                  ║
                        ╠══════════════════════════════════════════╣
                        ║ 1. Insertar un alumno                    ║
                        ╠══════════════════════════════════════════╣
                        ║ 2. Mostrar todos los alumnos             ║
                        ╠══════════════════════════════════════════╣
                        ║ 3. Insertar un profesor                  ║
                        ╠══════════════════════════════════════════╣
                        ║ 4. Mostrar todos los profesores          ║
                        ╠══════════════════════════════════════════╣
                        ║ 5. Buscar profesor por rango de edad     ║
                        ╠══════════════════════════════════════════╣
                        ║ 6. Actualizar rating de profesor         ║
                        ╠══════════════════════════════════════════╣
                        ║ 7. Eliminar profesores por calificación  ║
                        ╠══════════════════════════════════════════╣
                        ║ 8. Buscar alumno por mail                ║
                        ╠══════════════════════════════════════════╣
                        ║ 9. Eliminar alumnos por calificación     ║
                        ╠══════════════════════════════════════════╣
                        ║ 0. Salir                                 ║
                        ╚══════════════════════════════════════════╝
                     """);
        while(opcion!=8){
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> controlAlumno.insertarAlumno();
                case 2 -> controlAlumno.mostrarAlumnos();
                case 3 -> controlProfesor.insertarProfesor();
                case 4 -> controlProfesor.mostrarProfesores();
                case 5 -> controlProfesor.buscarProfesorPorRangoEdad();
                case 6 -> controlProfesor.actualizarCalificacionProfesor();
                case 7 -> controlProfesor.eliminarProfesoresPorCalificacion();
                case 8 -> controlAlumno.buscarPorMail();
                case 9 -> controlAlumno.eliminarPorCalificacion();
                case 0 -> System.out.println("Chao!");
                default -> System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
