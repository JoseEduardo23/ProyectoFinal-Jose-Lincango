import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AgregarProductos extends JFrame {
    public JPanel APpanel;
    private JButton agregarButton;
    private JTable table1;
    private JTextField Nomprod;
    private JTextField Codprod;
    private JTextField Cantprod;
    private JTextField Stockprod;
    private JTextField Precioprod;
    private JLabel img1;
    private JLabel img2;
    private JLabel tlt;
    private JLabel p;
    private JLabel c;
    private JLabel ca;
    private JLabel s;
    private JLabel pre;
    private JButton regresarButton;
    private JButton agregarStockButton;
    private DefaultTableModel modelo;

    private List<PRODUCTOS> productosList = new ArrayList<>();

    public AgregarProductos() {
        setTitle("Agregar productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(APpanel);
        setSize(650,700);
        setLocationRelativeTo(null);
        setVisible(true);

        APpanel.setLayout(null);

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase Products = mongoClient.getDatabase("Usuarios");
        MongoCollection<Document> usuarios = Products.getCollection("Productos");

        //Diseños
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/mecanico.png"));
        Image image = imagen1.getImage();
        Image tamanio = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon tamanio2 = new ImageIcon(tamanio);
        img1.setIcon(tamanio2);
        img1.setBounds(70,100,150,150);

        ImageIcon imagen2 = new ImageIcon(getClass().getResource("/IMG/agregar-producto.png"));
        Image image2 = imagen2.getImage();
        Image tamanioq = image2.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon tamanio3 = new ImageIcon(tamanioq);
        img2.setIcon(tamanio3);
        img2.setBounds(430,100,150,150);

        //Areas de texto
        tlt.setBounds(280,150,150,20);

        Nomprod.setBounds(120,350,150,20);
        Codprod.setBounds(120,385,150,20);
        Cantprod.setBounds(120,420,150,20);
        Stockprod.setBounds(390,350,150,20);
        Precioprod.setBounds(390,385,150,20);

        p.setBounds(55,348,150,20);
        c.setBounds(65,383,150,20);
        ca.setBounds(55,418,150,20);
        s.setBounds(330,348,150,20);
        pre.setBounds(330,383,150,20);

        agregarButton.setBounds(200,470,120,25);
        agregarStockButton.setBounds(330,470,120,25);
        table1.setBounds(70,530,500,100);

        regresarButton.setBounds(40,637,100,20);

        //Crear el modelo de la tabla.
        modelo = new DefaultTableModel(new Object[]{"Producto","Codigo","Cantidad","Stock","Precio"},0);
        table1.setModel(modelo);

        JScrollPane scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(70,530,500,100);
        APpanel.add(scrollPane);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Producto = Nomprod.getText();
                String Codigo = Codprod.getText();
                String Stock = Stockprod.getText();
                double precio;
                int Cantidad;

                try{
                    precio = Double.parseDouble(Precioprod.getText());
                    Cantidad = Integer.parseInt(Cantprod.getText());
                }catch (Exception ej){
                    JOptionPane.showMessageDialog(null,"Debe ingresarse un numero valido",null,JOptionPane.WARNING_MESSAGE);
                    return;
                }

                System.out.println("Producto: " + Producto);
                System.out.println("Codigo" + Codigo);
                System.out.println("Cantidad" + Cantidad);
                System.out.println("Stock:" + Cantidad);
                System.out.println("Precio:" +precio);

                PRODUCTOS productos = new PRODUCTOS(Producto,Codigo,Cantidad,Stock,precio);
                if (!isPRODUCTOSEmpty(productos)){
                    productosList.add(productos);
                    Document prodDoc = productos.toDocument();
                    usuarios.insertOne(prodDoc);
                        JOptionPane.showMessageDialog(null,"Producto Ingresado",null,JOptionPane.INFORMATION_MESSAGE);
                         modelo.addRow(new Object[]{productos.getNomprod(), productos.getIDprod(),productos.getCantidad(),productos.getStock(),productos.getPrecio()});

                        Nomprod.setText("");
                        Codprod.setText("");
                        Cantprod.setText("");
                        Stockprod.setText("");
                        Precioprod.setText("");
                }else{
                    JOptionPane.showMessageDialog(null,"El formulario esta vacio",null,JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Adminform adminform = new Adminform();
                adminform.setVisible(true);
                adminform.setSize(300,600);
                adminform.setPreferredSize(new Dimension(700,440));
                adminform.pack();
                adminform.setLocationRelativeTo(null);
                dispose();
            }
        });
        agregarStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stock stock = new Stock();
                stock.setDefaultCloseOperation(EXIT_ON_CLOSE);
                stock.setSize(new Dimension(400,380));
                stock.setLocationRelativeTo(null);
                stock.setVisible(true);
                dispose();
            }
        });
    }

    private boolean isPRODUCTOSEmpty(PRODUCTOS productos) {
        return productos.getNomprod() == null || productos.getNomprod().isEmpty() ||
                productos.getIDprod() == null || productos.getIDprod().isEmpty() ||
                productos.getStock() == null || productos.getStock().isEmpty() ||
                productos.getPrecio() == 0.0 ||
                productos.getCantidad() == 0;
    }
    public static void main(String[] args) {
        new AgregarProductos();
    }

}
