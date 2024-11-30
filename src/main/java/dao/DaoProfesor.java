package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.ConexionDB;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class DaoProfesor {
    private final MongoCollection<Document> profesores;

    public DaoProfesor() {
        MongoDatabase db = ConexionDB.getDatabase();
        this.profesores = db.getCollection("profesores");
    }

    public void insertarProfesor(Document profesor) {
        profesores.insertOne(profesor);
    }

    public void mostrarProfesores() {
        for (Document doc : profesores.find()) {
            System.out.println(doc.toJson());
        }
    }

    public List<Document> buscarPorRangoEdad(int edadMinima, int edadMaxima) {
        List<Document> listabuscar = new ArrayList<>();
        profesores.find(and(gte("age", edadMinima), lte("age", edadMaxima))).into(listabuscar);
        return listabuscar;
    }

    public void actualizarCalificacionProfesor(String email, double nuevoRating) {
        Bson f = eq("email", email);
        Bson actualizdo = new Document("$set", new Document("rating", nuevoRating));
        profesores.updateOne(f, actualizdo);
    }

    public void eliminarProfesoresPorCalificacion(double califMin, double califMax) {
        Bson filtro = and(gte("rating", califMin), lte("rating", califMax));
        profesores.deleteMany(filtro);
    }
}
