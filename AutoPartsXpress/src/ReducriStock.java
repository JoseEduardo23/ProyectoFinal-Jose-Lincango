import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;

public class ReducriStock extends JFrame {
    public MongoClient mongoClient;
    public MongoDatabase database;
    public MongoCollection<Document> productosCollection;

    public ReducriStock() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("Usuarios");
        productosCollection = database.getCollection("Productos");
    }
    public boolean reducirStock(String Nproducto, int cantidad){
        Document productoQuery = new Document("Producto",Nproducto);
        Document productoDoc = productosCollection.find(productoQuery).first();

        if (productoDoc != null){
            int stockActual = productoDoc.getInteger("Stock",0);
            int nuevoStock = stockActual - cantidad;

            if (nuevoStock > 0){
                Document update = new Document("$set",new Document("Stock", nuevoStock));
                productosCollection.updateOne(productoQuery, update);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
