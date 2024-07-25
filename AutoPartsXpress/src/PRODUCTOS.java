import org.bson.Document;

import javax.swing.*;

public class PRODUCTOS{
    String Nomprod;
    String IDprod;
    String stock;
    int precio;
    int cantidad;

    public PRODUCTOS() {
    }

    public PRODUCTOS(String nomprod, String IDprod, String stock, int precio, int cantidad) {
        Nomprod = nomprod;
        this.IDprod = IDprod;
        this.stock = stock;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNomprod() {
        return Nomprod;
    }

    public void setNomprod(String nomprod) {
        Nomprod = nomprod;
    }

    public String getIDprod() {
        return IDprod;
    }

    public void setIDprod(String IDprod) {
        this.IDprod = IDprod;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Convertir en BSON
    public Document toDocument() {
        return new Document("Producto",Nomprod)
                .append("Codigo", IDprod)
                .append("Stock",stock)
                .append("Precio", precio)
                .append("Cantidad", cantidad);
    }
}

