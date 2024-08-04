import org.bson.Document;

public class PRODUCTOS {
    private String nomprod;
    private String idprod;
    private int stock;
    private double precio;

    public PRODUCTOS(String nomprod, String idprod, int stock, double precio) {
        this.nomprod = nomprod;
        this.idprod = idprod;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNomprod() {
        return nomprod;
    }

    public String getIDprod() {
        return idprod;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public Document toDocument() {
        Document doc = new Document("Producto", nomprod)
                .append("IDproducto", idprod)
                .append("Stock", stock)
                .append("Precio", precio);
        return doc;
    }
}