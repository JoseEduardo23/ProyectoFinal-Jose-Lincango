import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public abstract class Main extends FormLogin {
    public static void main(String[] args) {
        Administrador administrador1 = new Administrador("UsuarioPrueba001","Contrasenia001");
        Administrador administrador2 = new Administrador("UsuarioPrueba002","Contrasenia002");

        //Conexion a Mongo DB
        //Insertar datos de Cajero y Administrador
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
        MongoCollection<Document> usuarios = database.getCollection("Admin");

        Document documentAdmin = administrador1.toDocument();
        Document documentAdmin2 = administrador2.toDocument();

        usuarios.insertOne(documentAdmin);
        usuarios.insertOne(documentAdmin2);
    }

    public abstract Document toDocument();
}