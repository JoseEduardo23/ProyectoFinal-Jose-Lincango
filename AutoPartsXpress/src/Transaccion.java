import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Transaccion extends JFrame {
    private ReducriStock stockManager;
    public JPanel Mpanel;
    private JTextField Nvendedor;
    private JTextField Tvendedor;
    private JTextField Evendedor;
    private JTextField Cvendedor;
    private JTextField Ncliente;
    private JTextField Dcliente;
    private JTextField Ecliente;
    private JTextField Ccliente;
    private JTextField Tcliente;
    private JTextField Nproducto;
    private JTextField Total;
    private JTextField TotalF;
    private JTextField Cantproducto;
    private JTextField Prproducto;
    private JButton Gbutton;
    private JLabel icon1;
    private JTextField Dvendedor;
    private JLabel Dv;
    private JLabel Tv;
    private JLabel Cv;
    private JLabel Nc;
    private JLabel Dc;
    private JLabel Tc;
    private JLabel Ec;
    private JLabel Cc;
    private JLabel Etc;
    private JLabel Dtf;
    private JLabel pf;
    private JLabel tf;
    private JLabel tiv;
    private JLabel tcan;
    private JLabel tprec;
    private JButton Rbutton;
    private JLabel icon2;
    private JLabel icon3;
    private JLabel icon4;
    private JLabel Nv;
    private JLabel Ev;
    private JLabel Pic1;
    private JLabel Pic2;
    private JLabel Pic3;
    private JLabel Pic4;
    private JLabel Stock1;
    private JLabel Stock2;
    private JLabel Stock3;
    private JLabel Stock4;
    private Facturas facturasFrame;

    private NumberFormat formatter = new DecimalFormat("#0.00");

    public Transaccion() {
        setTitle("Transaccion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Mpanel);
        setSize(820, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        stockManager = new ReducriStock();

        facturasFrame = new Facturas();

        Mpanel.setLayout(null);

        Pic1.setBounds(550,15,150,100);
        Pic2.setBounds(680,15,150,100);
        Pic3.setBounds(550,180,150,100);
        Pic4.setBounds(680,180,150,100);

        Stock1.setBounds(550, 140,150,100);
        Stock2.setBounds(680, 140,150,100);
        Stock3.setBounds(550, 310,150,100);
        Stock4.setBounds(680, 310,150,100);

        StockLabels();

        // Imagenes
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/IMG/alternador.png"));
        Image image = imageIcon.getImage();
        Image Tamanio = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(Tamanio);
        icon1.setIcon(imageIcon1);
        icon1.setBounds(550, 50, 150, 150);

        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/IMG/amortiguador.png"));
        Image image2 = imageIcon2.getImage();
        Image Tamanio2 = image2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imageIco2 = new ImageIcon(Tamanio2);
        icon2.setIcon(imageIco2);
        icon2.setBounds(680, 50, 150, 150);

        ImageIcon imageIcon3 = new ImageIcon(getClass().getResource("/IMG/bujia.png"));
        Image image3= imageIcon3.getImage();
        Image Tamanio3 = image3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imageIco3 = new ImageIcon(Tamanio3);
        icon3.setIcon(imageIco3);
        icon3.setBounds(550, 220, 150, 150);


        ImageIcon imageIcon4 = new ImageIcon(getClass().getResource("/IMG/filtro-de-aceite.png"));
        Image image4 = imageIcon4.getImage();
        Image Tamanio4 = image4.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imageIco4 = new ImageIcon(Tamanio4);
        icon4.setIcon(imageIco4);
        icon4.setBounds(680, 220, 150, 150);


        // Cajero
        Nvendedor.setBounds(93, 50, 150, 20);
        Evendedor.setBounds(318, 50, 150, 20);
        Dvendedor.setBounds(93, 100, 150, 20);
        Tvendedor.setBounds(93, 150, 150, 20);
        Cvendedor.setBounds(318, 100, 150, 20);
        Nv.setBounds(15,47,150,20);
        Ev.setBounds(260,47,150,20);
        Tv.setBounds(40, 147, 150, 20);
        Cv.setBounds(268, 98, 150, 20);
        Dv.setBounds(10, 98, 150, 20);

        // Cliente
        Etc.setBounds(35, 230, 150, 20);
        Ncliente.setBounds(93, 290, 150, 20);
        Dcliente.setBounds(93, 335, 150, 20);
        Tcliente.setBounds(93, 380, 150, 20);
        Ecliente.setBounds(318, 290, 150, 20);
        Ccliente.setBounds(318, 335, 150, 20);

        Nc.setBounds(20, 287, 150, 20);
        Dc.setBounds(10, 332, 150, 20);
        Tc.setBounds(35, 376, 150, 20);
        Ec.setBounds(268, 287, 150, 20);
        Cc.setBounds(268, 332, 150, 20);

        // Productos
        Dtf.setBounds(35, 445, 150, 20);
        Nproducto.setBounds(93, 505, 150, 20);
        Cantproducto.setBounds(325, 505, 150, 20);
        Prproducto.setBounds(570, 505, 150, 20);
        Total.setBounds(93, 550, 150, 20);
        TotalF.setBounds(93, 595, 150, 20);

        pf.setBounds(20, 503, 150, 20);
        tf.setBounds(27, 547, 150, 20);
        tiv.setBounds(10, 592, 150, 20);
        tcan.setBounds(262, 503, 150, 20);
        tprec.setBounds(506, 503, 150, 20);

        // Botones
        Gbutton.setBounds(380, 630, 100, 25);
        Rbutton.setBounds(260, 630, 100, 25);

        Rbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cajerform cajerform = new Cajerform();
                cajerform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cajerform.setSize(600, 440);
                cajerform.setLocationRelativeTo(null);
                cajerform.setVisible(true);
                dispose();
            }
        });

        Gbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                try {
                    if (TotalF.getText().isEmpty() || Nvendedor.getText().isEmpty() ||
                            Ncliente.getText().isEmpty() || Nproducto.getText().isEmpty() ||
                            Cantproducto.getText().isEmpty()) {
                        throw new IllegalArgumentException("Por favor, complete todos los campos necesarios.");
                    }

                    double total = Double.parseDouble(TotalF.getText());
                    String cajero = Nvendedor.getText();
                    String cliente = Ncliente.getText();
                    String producto = Nproducto.getText();
                    int cantidad = Integer.parseInt(Cantproducto.getText());
                    DetalleFacturas detalle = new DetalleFacturas(total, cajero, cliente, producto, cantidad);

                    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                    MongoDatabase Products = mongoClient.getDatabase("Usuarios");
                    MongoCollection<org.bson.Document> Prod = Products.getCollection("DetalleFacturas");

                    org.bson.Document facturaDocument = detalle.toDocument();
                    Prod.insertOne(facturaDocument);

                    //Reducir stock

                    int stockReduced = stockManager.reducirStock(Nproducto.getText(),Integer.parseInt(Cantproducto.getText()));
                    if (stockReduced != -1){
                        StockLabels();
                    }else{
                        JOptionPane.showMessageDialog(null,"No se puede reducir el stock",null,JOptionPane.WARNING_MESSAGE);
                    }
                    // Generar PDF
                    createPdf();

                    JOptionPane.showMessageDialog(null, "Factura generada y guardada exitosamente", null, JOptionPane.INFORMATION_MESSAGE);

                    Nvendedor.setText("");
                    Tvendedor.setText("");
                    Evendedor.setText("");
                    Cvendedor.setText("");
                    Ncliente.setText("");
                    Dcliente.setText("");
                    Ecliente.setText("");
                    Ccliente.setText("");
                    Tcliente.setText("");
                    Nproducto.setText("");
                    Cantproducto.setText("");
                    Prproducto.setText("");
                    Total.setText("");
                    TotalF.setText("");


                    // Agregar la factura a la tabla
                    Object[] factura = {
                            "Factura-" + System.currentTimeMillis(), // Id de factura único
                            Nvendedor.getText(),
                            Ncliente.getText(),
                            Nproducto.getText(),
                            Cantproducto.getText(),
                            TotalF.getText()};

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), null, JOptionPane.WARNING_MESSAGE);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "No se ha generado la factura", null, JOptionPane.WARNING_MESSAGE);
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error al generar la factura", null, JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar en MongoDB", null, JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

            }
        });

        // Listeners para calcular el total
        Cantproducto.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateTotal();
            }

            public void removeUpdate(DocumentEvent e) {
                updateTotal();
            }

            public void insertUpdate(DocumentEvent e) {
                updateTotal();
            }
        });

        Prproducto.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateTotal();
            }

            public void removeUpdate(DocumentEvent e) {
                updateTotal();
            }

            public void insertUpdate(DocumentEvent e) {
                updateTotal();
            }
        });
    }

    private void updateTotal() {
        try {
            int cantidad = Integer.parseInt(Cantproducto.getText());
            double precio = Double.parseDouble(Prproducto.getText());
            double total = cantidad * precio;
            double totalF = total * 1.15;
            Total.setText(formatter.format(total));
            TotalF.setText(formatter.format(totalF));
        } catch (NumberFormatException e) {
            TotalF.setText("0.00");
        }
    }

    private void createPdf() throws IOException {
        String nombrePDF = "factura.pdf";
        PdfWriter writer = new PdfWriter(nombrePDF);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        Paragraph header = new Paragraph("Factura")
                .setFont(font)
                .setFontSize(20)
                .setTextAlignment(TextAlignment.CENTER);
        document.add(header);

        Table table = new Table(5);
        table.addCell(new Cell().add(new Paragraph("Cajero")));
        table.addCell(new Cell().add(new Paragraph("Cliente")));
        table.addCell(new Cell().add(new Paragraph("Producto")));
        table.addCell(new Cell().add(new Paragraph("Cantidad")));
        table.addCell(new Cell().add(new Paragraph("Total")));

        table.addCell(new Cell().add(new Paragraph(Nvendedor.getText())));
        table.addCell(new Cell().add(new Paragraph(Ncliente.getText())));
        table.addCell(new Cell().add(new Paragraph(Nproducto.getText())));
        table.addCell(new Cell().add(new Paragraph(Cantproducto.getText())));
        table.addCell(new Cell().add(new Paragraph(TotalF.getText())));

        document.add(table);
        document.close();
    }

    private void StockLabels(){
        Stock1.setText("Stock: " + stockManager.obtenerStock("Alternador"));
        Stock2.setText("Stock: " + stockManager.obtenerStock("Amortiguador"));
        Stock3.setText("Stock: " + stockManager.obtenerStock("Bujias"));
        Stock4.setText("Stock: " + stockManager.obtenerStock("Filtro de aceite"));

    }

    public static void main(String[] args) {
        Transaccion transaccion = new Transaccion();
    }
}