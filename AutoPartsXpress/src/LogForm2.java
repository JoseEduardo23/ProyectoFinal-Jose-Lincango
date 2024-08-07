import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogForm2 extends JFrame {
    public JPanel mainPanel2;
    public JTextField UserAdmin;
    public JPasswordField PassAdmin;
    public JButton ingresarButton;
    private JLabel icon;
    private JPanel PanelA;
    private JButton salirButton;

    public LogForm2() {
        setTitle("Inicio de sesion Administradores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel2);
        pack();
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/nueva-cuenta.png"));
        Image image = imagen1.getImage();
        Image tamanio = image.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        ImageIcon tamanio2 = new ImageIcon(tamanio);
        icon.setIcon(tamanio2);
        UserAdmin.setPreferredSize(new Dimension(50,30));
        PassAdmin.setPreferredSize(new Dimension(50,30));

        icon.setPreferredSize(new Dimension(150,150));
        PanelA.setPreferredSize(new Dimension(300,300));
        mainPanel2.setPreferredSize(new Dimension(300,300));

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = UserAdmin.getText();
                String pass = PassAdmin.getText();
                try {
                    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                    MongoDatabase database = mongoClient.getDatabase("AutoPartsXpress");
                    MongoCollection<Document> usuarios = database.getCollection("Admin");

                    Document query = new Document("Usuario", user)
                            .append("Contrasenia", pass);

                    Document result = usuarios.find(query).first();

                    if (result != null) {
                        JOptionPane.showMessageDialog(mainPanel2, "Credenciales correctas",null,JOptionPane.INFORMATION_MESSAGE);
                        Adminform adminform = new Adminform();
                        adminform.setVisible(true);
                        adminform.setSize(300,600);
                        adminform.setPreferredSize(new Dimension(700,440));
                        adminform.pack();
                        adminform.setLocationRelativeTo(null);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(mainPanel2, "Credenciales incorrectos",null,JOptionPane.ERROR_MESSAGE);
                    }

                }catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos",null,JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
