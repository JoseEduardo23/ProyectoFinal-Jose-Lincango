import com.mongodb.client.*;
import com.mongodb.client.result.*;
import org.bson.Document;

public abstract class Main extends FormLogin {
    public static void main(String[] args) {
        Administrador administrador1 = new Administrador("UsuarioPrueba001","Contrasenia001");

        //Conexion a Mongo DB
        //Insertar datos de Cajero y Administrador
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        MongoCollection<Document> usuarios = database.getCollection("Admin");
        Document documentAdmin = administrador1.toDocument();

        usuarios.insertOne(documentAdmin);
    }

    public abstract Document toDocument();
}