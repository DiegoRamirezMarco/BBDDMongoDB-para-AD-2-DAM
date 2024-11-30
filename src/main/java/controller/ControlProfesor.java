package controller;

import dao.DaoProfesor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControlProfesor {
    private final DaoProfesor daoProfesor = new DaoProfesor();
    private final Scanner scanner = new Scanner(System.in);

    public void insertarProfesor() {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Edad: ");
        int age = scanner.nextInt();
        System.out.print("Email: ");
        scanner.nextLine();
        String email = scanner.nextLine();
        System.out.print("Título: ");
        String title = scanner.nextLine();
        System.out.print("Número de asignaturas: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine();

        List<String> subjects = new ArrayList<>();
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Asignatura " + (i + 1) + ": ");
            String asignatura = scanner.nextLine();
            subjects.add(asignatura);
        }

        System.out.print("Rating: ");
        double rating = scanner.nextDouble();

        Document profesor = new Document()
                .append("name", name)
                .append("age", age)
                .append("email", email)
                .append("title", title)
                .append("subjects", subjects)
                .append("rating", rating);

        daoProfesor.insertarProfesor(profesor);
        System.out.println("Profesor insertado correctamente.");
    }

    public void mostrarProfesores() {
        daoProfesor.mostrarProfesores();
    }

    public void buscarProfesorPorRangoEdad() {
        System.out.print("Edad mínima: ");
        int edadMinima = scanner.nextInt();

        System.out.print("Edad máxima: ");
        int edadMaxima = scanner.nextInt();

        List<Document> profesores = daoProfesor.buscarPorRangoEdad(edadMinima, edadMaxima);
        if (profesores.isEmpty()) {
            System.out.println("No se encontraron profesores en este rango de edad.");
        } else {
            for (Document profesor : profesores) {
                System.out.println(profesor.toJson());
            }
        }
    }

    public void actualizarCalificacionProfesor() {
        System.out.print("Email del profesor: ");
        scanner.nextLine(); // Consumir el salto de línea
        String email = scanner.nextLine();

        System.out.print("Nuevo rating: ");
        double nuevoRating = scanner.nextDouble();

        daoProfesor.actualizarCalificacionProfesor(email, nuevoRating);
        System.out.println("Rating del profesor actualizado correctamente.");
    }

    public void eliminarProfesoresPorCalificacion() {
        System.out.print("Calificación mínima: ");
        double calificacionMin = scanner.nextDouble();

        System.out.print("Calificación máxima: ");
        double calificacionMax = scanner.nextDouble();

        daoProfesor.eliminarProfesoresPorCalificacion(calificacionMin, calificacionMax);
        System.out.println("Profesores eliminados correctamente.");
    }
}
