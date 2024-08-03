import org.bson.Document;

public class DetalleFacturas {
    String Cajero;
    String Cliente;
    String Producto;
    int Cantidad;
    double Total;

    public DetalleFacturas() {
    }

    public DetalleFacturas(double total, String cajero, String cliente, String producto, int cantidad) {
        Total = total;
        Cajero = cajero;
        Cliente = cliente;
        Producto = producto;
        Cantidad = cantidad;
    }

    public String getCajero() {
        return Cajero;
    }

    public void setCajero(String cajero) {
        Cajero = cajero;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
    public Document toDocument(){
        return new Document("Cajero", Cajero)
                .append("Cliente", Cliente)
                .append("Producto", Producto)
                .append("Cantidad",Cantidad)
                .append("Total", Total);
    }
}
