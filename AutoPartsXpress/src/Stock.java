import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stock extends JFrame {
    public JPanel stockPanel;
    private JTextField Bcodprod;
    private JTextField Bnombprod;
    private JTable tabla1;
    private JTextField Mstoockprod;
    private JButton modificarButton;
    private JButton buscarButton;
    private JLabel txt3;
    private JLabel txt2;
    private JLabel txt1;
    private DefaultTableModel modelo1;

    public Stock() {
        setTitle("Agregar stock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(stockPanel);
        setSize(400, 380);
        setLocationRelativeTo(null);
        setVisible(true);

        stockPanel.setLayout(null);
        modificarButton.setBounds(90, 130, 100, 25);
        buscarButton.setBounds(210, 130, 100, 25);

        Bcodprod.setBounds(120, 31, 150, 20);
        Mstoockprod.setBounds(120, 83, 150, 20);
        Bnombprod.setBounds(120, 57, 150, 20);

        txt1.setBounds(65, 29, 150, 20);
        txt2.setBounds(65, 55, 150, 20);
        txt3.setBounds(65, 81, 150, 20);

        modelo1 = new DefaultTableModel(new Object[]{"Producto", "Codigo", "Cantidad", "Stock", "Precio"}, 0);
        tabla1.setModel(modelo1);

        JScrollPane scrollPane = new JScrollPane(tabla1);
        scrollPane.setBounds(30, 170, 330, 150);
        stockPanel.add(scrollPane);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void buscarProducto() {
        String codprod = Bcodprod.getText().trim();
        String nomprod = Bnombprod.getText().trim();

        modelo1.setRowCount(0);

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase stock = mongoClient.getDatabase("Usuarios");
            MongoCollection<Document> collection = stock.getCollection("Productos");

            Document query = new Document();
            if (!codprod.isEmpty()) {
                query.append("IDproducto", codprod);
            }
            if (!nomprod.isEmpty()) {
                query.append("Producto", nomprod);
            }

            System.out.println("Query: " + query.toJson());

            FindIterable<Document> documentos = collection.find(query);

            for (Document document : documentos) {

                PRODUCTOS producto = new PRODUCTOS(
                        document.getString("Producto"),
                        document.getString("IDproducto"),
                        document.getInteger("Cantidad", 0),
                        document.getString("Stock"),
                        document.getDouble("Precio")
                );
                modelo1.addRow(new Object[]{
                        producto.getNomprod(),
                        producto.getIDprod(),
                        producto.getCantidad(),
                        producto.getStock(),
                        producto.getPrecio()
                });
            }

        } catch (Exception ef) {
            ef.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar el producto", null, JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Stock();
    }
}