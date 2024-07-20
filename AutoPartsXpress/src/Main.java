import com.mongodb.client.*;
import com.mongodb.client.result.*;
import org.bson.Document;

public abstract class Main extends FormLogin {
    public static void main(String[] args) {
        Cajero cajero1 = new Cajero("AutopartesCaja0119072024","UserCaja0119072024");
        Administrador administrador1 = new Administrador("AutopartesLuis1245/","UserAuto19072024");

        //Conexion a Mongo DB
        //Insertar datos de Cajero y Administrador
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        MongoCollection<Document> usuarios = database.getCollection("AdminYCajer");
        Document documentCajero = cajero1.toDocument();
        Document documentAdmin = administrador1.toDocument();

        usuarios.insertOne(documentCajero);
        usuarios.insertOne(documentAdmin);
    }

    public abstract Document toDocument();
}