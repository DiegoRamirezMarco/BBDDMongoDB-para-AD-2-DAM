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

    public void buscarPorMail(){
        System.out.println("Introduce el email por el que buscar");
        String email = scanner.nextLine();
        Document doc = daoAlumno.buscarAlumnoPorEmail(email);
        if (doc == null){
            System.out.println("No se encontro el alumno");
        }else {
            System.out.println(doc.toJson());
        }
    }
    public void eliminarPorCalificacion(){
        System.out.println("Introduce la calificacion para eliminar alumnos");
        int calificacion = scanner.nextInt();
        daoAlumno.eliminarPorCalificacion(calificacion);
        System.out.println("Alumno eliminado");
    }
}
