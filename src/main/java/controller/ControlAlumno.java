package controller;

import dao.DaoAlumno;
import org.bson.Document;

import java.util.Scanner;

public class ControlAlumno {
    private final DaoAlumno daoAlumno = new DaoAlumno();
    private final Scanner scanner = new Scanner(System.in);

    public void insertarAlumno() {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Edad: ");
        int age = scanner.nextInt();
        System.out.print("Email: ");
        scanner.nextLine();
        String email = scanner.nextLine();
        System.out.print("Calificación: ");
        int calification = scanner.nextInt();

        Document alumno = new Document()
                .append("name", name)
                .append("age", age)
                .append("email", email)
                .append("calification", calification);

        daoAlumno.insertarAlumno(alumno);
        System.out.println("Alumno insertado correctamente.");
    }

    public void mostrarAlumnos() {
        daoAlumno.mostrarAlumnos();
    }
}
