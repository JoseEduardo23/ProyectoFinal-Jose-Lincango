import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Agregarusuarios extends JFrame {
    public JTextField CIIN;
    public JTextField nomIN;
    public JTextField apelIN;
    public JTextField edadIN;
    public JTextField correoIN;
    public JTextField rolIN;
    public JButton BIngreso;
    public JButton Bmostrar;
    public JButton Bregreso1;
    public JTextField FechIN;
    public JPanel AgregarPanel;

    private List<Cajero> cajeroList = new ArrayList<>();

    public Agregarusuarios() {

        setTitle("Agregar usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(AgregarPanel);
        pack();

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("Usuarios");
        MongoCollection<Document> usuarios = database.getCollection("Cajeros");

        BIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = nomIN.getText() + apelIN.getText() + "Xpress";
                String contrasenia = FechIN.getText() + "AutoPartsXpress";
                String cedula = CIIN.getText();
                String nombre = nomIN.getText();
                String apellido = apelIN.getText();
                String edad = edadIN.getText();
                String correo = correoIN.getText();
                String rol = rolIN.getText();
                String ingreso = FechIN.getText();

                System.out.println("Usuario: " + usuario);
                System.out.println("Contrasenia: " + contrasenia);
                System.out.println("Cedula: " + cedula);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Edad: " + edad);
                System.out.println("Correo: " + correo);
                System.out.println("Rol: " + rol);
                System.out.println("Ingreso: " + ingreso);

                Cajero cajero = new Cajero(usuario,contrasenia,cedula,nombre,apellido,edad,correo,rol,ingreso);
                cajeroList.add(cajero);

                for (Cajero caj : cajeroList) {
                    Document cajeroDoc = caj.toDocument();
                    usuarios.insertOne(cajeroDoc);
                }
            }
        });

    }
}
