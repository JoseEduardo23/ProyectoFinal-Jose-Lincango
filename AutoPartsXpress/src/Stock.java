import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
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
    private JButton regresarButton;
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
        regresarButton.setBounds(30, 321, 90, 20);

        Bcodprod.setBounds(120, 31, 150, 20);
        Mstoockprod.setBounds(120, 83, 150, 20);
        Bnombprod.setBounds(120, 57, 150, 20);

        txt1.setBounds(65, 29, 150, 20);
        txt2.setBounds(65, 55, 150, 20);
        txt3.setBounds(65, 81, 150, 20);

        modelo1 = new DefaultTableModel(new Object[]{"Producto", "Codigo", "Stock", "Precio"}, 0);
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
                actualizarStock();
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProductos agregarProductos = new AgregarProductos();
                agregarProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                agregarProductos.setSize(650, 700);
                agregarProductos.setLocationRelativeTo(null);
                agregarProductos.setVisible(true);
                dispose();
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
                        document.getInteger("Stock", 0),
                        document.getDouble("Precio")
                );
                modelo1.addRow(new Object[]{
                        producto.getNomprod(),
                        producto.getIDprod(),
                        producto.getStock(),
                        producto.getPrecio()
                });
            }
            //s
        } catch (Exception ef) {
            ef.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al buscar el producto", null, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizarStock() {
        String codprod = Bcodprod.getText().trim();
        String nomprod = Bnombprod.getText().trim();
        String Nstock = Mstoockprod.getText().trim();

        if (Nstock.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nuevo stock", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase stock = mongoClient.getDatabase("Usuarios");
            MongoCollection<Document> collection = stock.getCollection("Productos");

            Document query1 = new Document();
            if (!codprod.isEmpty()) {
                query1.append("IDproducto", codprod);
            }
            if (!nomprod.isEmpty()) {
                query1.append("Producto", nomprod);
            }

            Document foundDocument = collection.find(query1).first();

            if (foundDocument != null) {
                int stockactual = foundDocument.getInteger("Stock", 0);
                int añadirStock = Integer.parseInt(Nstock);
                int nuevoStock = stockactual + añadirStock;

                Document update = new Document("$set", new Document("Stock", nuevoStock));
                UpdateResult result = collection.updateMany(query1, update);

                if (result.getMatchedCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Stock actualizado", null, JOptionPane.INFORMATION_MESSAGE);
                    buscarProducto();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el producto", null, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el producto", null, JOptionPane.WARNING_MESSAGE);
                }
            }catch(Exception ef){
                ef.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al actualizar", null, JOptionPane.WARNING_MESSAGE);
            }
        }
        public static void main (String[]args){
            new Stock();
        }
    }
