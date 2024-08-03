import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//Elaboracion de la clase para Agregar ususarios cajeros
public class Agregarusuarios extends JFrame {
    public JTextField CIIN;
    public JTextField nomIN;
    public JTextField apelIN;
    public JTextField edadIN;
    public JTextField correoIN;
    public JTextField rolIN;
    public JButton BIngreso;
    public JButton Beliminar;
    public JButton Bregreso1;
    public JTextField FechIN;
    public JPanel AgregarPanel;

    private List<Cajero> cajeroList = new ArrayList<>();

    public Agregarusuarios() {

        setTitle("Agregar usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(AgregarPanel);
        setSize(new Dimension(600, 350));
        setLocationRelativeTo(null);
        setVisible(true);

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        MongoCollection<Document> usuarios = database.getCollection("Cajeros");

        BIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = nomIN.getText() + apelIN.getText() + "Xpress";
                String contrasenia = CIIN.getText()+ "AutoParts";
                String contraseniaH = ClaveSegura.hashPasword(contrasenia);

                String cedula = CIIN.getText();
                String nombre = nomIN.getText();
                String apellido = apelIN.getText();
                String edad = edadIN.getText();
                String correo = correoIN.getText();
                String rol = rolIN.getText();
                String ingreso = FechIN.getText();

                System.out.println("Usuario: " + usuario);
                System.out.println("Contrasenia (hash): " + contraseniaH);
                System.out.println("Cedula: " + cedula);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Edad: " + edad);
                System.out.println("Correo: " + correo);
                System.out.println("Rol: " + rol);
                System.out.println("Ingreso: " + ingreso);

                Cajero cajero = new Cajero(usuario,contrasenia,cedula,nombre,apellido,edad,correo,rol,ingreso);

                if(!isCajeroEmpty(cajero)){
                    cajeroList.add(cajero);

                    Document cajeroDoc = cajero.toDocument();

                    usuarios.insertOne(cajeroDoc);

                    JOptionPane.showMessageDialog(null,"Usuario Ingresado",null,JOptionPane.INFORMATION_MESSAGE);
                    CIIN.setText("");
                    nomIN.setText("");
                    apelIN.setText("");
                    edadIN.setText("");
                    correoIN.setText("");
                    rolIN.setText("");
                    FechIN.setText("");

                }else{
                    JOptionPane.showMessageDialog(null,"El formulario esta vacio",null,JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        Bregreso1.addActionListener(new ActionListener() {
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
        Beliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DELETE
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("Usuarios");
                    MongoCollection<Document> collection = database.getCollection("Cajeros");

                    Document filtro = new Document("Cedula", CIIN.getText());
                    DeleteResult resultado = collection.deleteOne(filtro);
                    if(resultado.getDeletedCount()>0) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado", null, JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Documentos borrados: " + resultado.getDeletedCount());
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario no encontrado",null, JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        });
    }
    public boolean isCajeroEmpty(Cajero cajero) {
        return (cajero.getUsuarioCaj() == null || cajero.getUsuarioCaj().isEmpty()) ||
                (cajero.getContraseniaCaj() == null || cajero.getContraseniaCaj().isEmpty()) ||
                (cajero.getCedulaCaj() == null || cajero.getCedulaCaj().isEmpty()) ||
                (cajero.getNombreCaj() == null || cajero.getNombreCaj().isEmpty()) ||
                (cajero.getApellidoCaj() == null || cajero.getApellidoCaj().isEmpty()) ||
                (cajero.getEdadCaj() == null || cajero.getEdadCaj().isEmpty()) ||
                (cajero.getCorreoCaj() == null || cajero.getCorreoCaj().isEmpty()) ||
                (cajero.getRolCaj() == null || cajero.getRolCaj().isEmpty()) ||
                (cajero.getIngresoCaj() == null || cajero.getIngresoCaj().isEmpty());
    }

}
