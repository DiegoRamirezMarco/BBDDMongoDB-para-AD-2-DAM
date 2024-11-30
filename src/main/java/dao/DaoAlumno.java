package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.ConexionDB;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class DaoAlumno {
    private final MongoCollection<Document> alumnos;

    public DaoAlumno() {
        MongoDatabase db = ConexionDB.getDatabase();
        this.alumnos = db.getCollection("alumnos");
    }

    public void insertarAlumno(Document alumno) {
        alumnos.insertOne(alumno);
    }

    public void mostrarAlumnos() {
        for (Document doc : alumnos.find()) {
            System.out.println(doc.toJson());
        }
    }

    public Document buscarAlumnoPorEmail(String email) {
        return alumnos.find(eq("email", email)).first();
    }

    public void eliminarPorCalificacion(int calificacion) {
        alumnos.deleteMany(new Document("calification", new Document("$gte", calificacion)));
    }
}
