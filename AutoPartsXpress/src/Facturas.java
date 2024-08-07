import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Facturas extends JFrame {
    private JPanel FacturasPanel;
    private JTable tablaFacturas;
    private JButton regresarButton;
    private DefaultTableModel modeloFacturas;

    public Facturas() {
        setTitle("Facturas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setContentPane(FacturasPanel);

        modeloFacturas = (DefaultTableModel) tablaFacturas.getModel();
        modeloFacturas.setColumnIdentifiers(new Object[]{"Factura", "Cajero", "Cliente", "Producto", "Cantidad", "Total"});

        // Agregar ActionListener al botón regresar
        regresarButton.addActionListener(e -> {
            Adminform adminform = new Adminform();
            adminform.setVisible(true);
            adminform.setSize(300, 600);
            adminform.setPreferredSize(new Dimension(700, 440));
            adminform.pack();
            adminform.setLocationRelativeTo(null);
            dispose();
        });

        // Conectar a MongoDB y cargar las facturas
        agregarFacturas();
    }

    private void agregarFacturas() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
        MongoCollection<Document> collection = database.getCollection("DetalleFacturas");

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Object[] factura = {
                        doc.getObjectId("_id").toString(),
                        doc.getString("Cajero"),
                        doc.getString("Cliente"),
                        doc.getString("Producto"),
                        doc.getInteger("Cantidad"),
                        doc.getDouble("Total")
                };
                modeloFacturas.addRow(factura);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar las facturas de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            mongoClient.close();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Facturas facturasFrame = new Facturas();
            facturasFrame.setVisible(true);
        });
    }
}