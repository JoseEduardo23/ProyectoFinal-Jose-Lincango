import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cajerform extends JFrame {
    public JPanel Cajerform;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JLabel icon1;
    private JLabel icon2;
    private JLabel icon3;

    public Cajerform(){
        setTitle("Cajeros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Cajerform);
        setSize(600,440);
        setLocationRelativeTo(null);
        setVisible(true);

        //Botones

        Border borde2 = BorderFactory.createLineBorder(null,1,true);
        Button2.setBorder(borde2);
        Button2.setPreferredSize(new Dimension(150,20));

        Border borde3 = BorderFactory.createLineBorder(null,1,true);
        Button3.setBorder(borde3);
        Button3.setPreferredSize(new Dimension(150,20));

        //Imagenes

        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/IMG/factura.png"));
        Image image2 = imageIcon2.getImage();
        Image Tamanio2 = image2.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon imageIcona = new ImageIcon(Tamanio2);
        icon2.setIcon(imageIcona);

        ImageIcon imageIcon3 = new ImageIcon(getClass().getResource("/IMG/cajero.png"));
        Image image3 = imageIcon3.getImage();
        Image Tamanio3 = image3.getScaledInstance(170,170,Image.SCALE_SMOOTH);
        ImageIcon imageIconb = new ImageIcon(Tamanio3);
        icon3.setIcon(imageIconb);

        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transaccion transaccion = new Transaccion();
                transaccion.setVisible(true);
                transaccion.setPreferredSize(new Dimension(500,300));
                transaccion.setLocationRelativeTo(null);
                transaccion.setResizable(false);
                dispose();
            }
        });
        Button3.addActionListener(new ActionListener() {
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
    }
    public static void main(String[] args) {
        new Cajerform();
    }
}
