import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogForm3 extends JFrame {

    private JPanel mainPanel3;
    private JPanel Panel3A;
    private JPanel Panel3B;
    private JLabel icon4;
    private JTextField CajerUser;
    private JPasswordField CajerPass;
    private JButton BotonCaj;
    private JButton Regresar;

    public LogForm3() {
        setTitle("Iniciar sesion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel3);
        pack();

        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/iniciar-sesion.png"));
        Image image = imagen1.getImage();
        Image tamanio = image.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
        ImageIcon tamanio2 = new ImageIcon(tamanio);
        icon4.setIcon(tamanio2);
        Regresar.setBorder(BorderFactory.createLineBorder(null,1,true));
        Regresar.setPreferredSize(new Dimension(100,10));
        CajerPass.setPreferredSize(new Dimension(150,30));
        CajerUser.setPreferredSize(new Dimension(150,30));

        Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormLogin formLogin = new FormLogin();
                formLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
                formLogin.setSize(new Dimension(300,250));
                formLogin.setLocationRelativeTo(null);
                formLogin.setVisible(true);
                dispose();
            }
        });
        BotonCaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = CajerUser.getText();
                String pass = CajerPass.getText();
                try{
                    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                    MongoDatabase database = mongoClient.getDatabase("Usuarios");
                    MongoCollection<Document> usuario = database.getCollection("Cajeros");

                    Document query1 = new Document("Usuario", user)
                            .append("Contrasenia", pass);
                    Document result1 = usuario.find(query1).first();

                    if(result1 !=null){
                        JOptionPane.showMessageDialog(mainPanel3,"Credenciales correctas",null,JOptionPane.INFORMATION_MESSAGE);
                        CajerUser.setText("");
                        CajerPass.setText("");

                        Cajerform cajerform = new Cajerform();
                        cajerform.setVisible(true);
                        cajerform.setSize(600,600);
                        cajerform.setPreferredSize(new Dimension(600,400));
                        cajerform.pack();
                        cajerform.setLocationRelativeTo(null);
                        dispose();


                    } else{
                        JOptionPane.showMessageDialog(mainPanel3,"Credenciales incorrectas", null,JOptionPane.WARNING_MESSAGE);

                    }
                }catch(Exception ej) {
                    ej.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos",null,JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
