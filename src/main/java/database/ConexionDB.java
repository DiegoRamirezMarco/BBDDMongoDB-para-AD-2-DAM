package database;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class ConexionDB {
    private static final String conexion = "mongodb://localhost:27017";
    private static final String BBDD_NAME = "centro_estudios";
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(conexion);
            database = mongoClient.getDatabase(BBDD_NAME);
        }
        return database;
    }
    }

