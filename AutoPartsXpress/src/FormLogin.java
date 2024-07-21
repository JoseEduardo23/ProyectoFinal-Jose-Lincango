import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.*;
import com.mongodb.client.result.*;
import org.bson.Document;

public class FormLogin extends JFrame {

    public JPanel mainPanel1;
    public JButton B1Ingreso;
    public JButton B2Ingreso;
    public JLabel iconLabel;

    public FormLogin() {

        setTitle("Login");
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel1);
        pack();
        //Ajuste del icono
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/mecanico.png"));
        Image image = imagen1.getImage();
        Image tamanio = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        ImageIcon tamanio2 = new ImageIcon(tamanio);
        iconLabel.setIcon(tamanio2);

        B1Ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogForm2 logForm2 = new LogForm2();
                logForm2.setVisible(true);
                logForm2.setSize(300,600);
                logForm2.setPreferredSize(new Dimension(550,300));
                logForm2.pack();
                logForm2.setLocationRelativeTo(null);
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormLogin frame = new FormLogin();
                frame.setContentPane(frame.mainPanel1);
                frame.setPreferredSize(new Dimension(300,250));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
