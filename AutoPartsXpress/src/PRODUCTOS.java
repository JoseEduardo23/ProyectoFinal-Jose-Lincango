import org.bson.Document;

public class PRODUCTOS {
    private String nomprod;
    private String idprod;
    private int cantidad;
    private String stock;
    private double precio;

    public PRODUCTOS(String nomprod, String idprod, int cantidad, String stock, double precio) {
        this.nomprod = nomprod;
        this.idprod = idprod;
        this.cantidad = cantidad;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNomprod() {
        return nomprod;
    }

    public String getIDprod() {
        return idprod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public Document toDocument() {
        Document doc = new Document("Producto", nomprod)
                .append("IDproducto", idprod)
                .append("Cantidad", cantidad)
                .append("Stock", stock)
                .append("Precio", precio);
        return doc;
    }
}