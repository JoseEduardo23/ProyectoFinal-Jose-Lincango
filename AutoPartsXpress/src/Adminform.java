import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Adminform extends JFrame {

    public JPanel AdminPanel;
    public JButton Button1;
    public JButton Button3;
    public JButton Button2;
    public JPanel Panel1;
    public JLabel Image1;
    public JButton regresarButton;
    private JLabel icon2;
    private JLabel icon3;
    private JLabel icon4;

    public Adminform (){
        setTitle("Administracion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(AdminPanel);
        pack();

        //Ajuste de elementos del form
        Border borde1 = BorderFactory.createLineBorder(null,1,true);
        Button1.setBorder(borde1);
        Button1.setPreferredSize(new Dimension(150,20));

        Border borde2 = BorderFactory.createLineBorder(null,1,true);
        Button2.setBorder(borde2);
        Button2.setPreferredSize(new Dimension(150,20));

        Border borde3 = BorderFactory.createLineBorder(null,1,true);
        Button3.setBorder(borde3);
        Button3.setPreferredSize(new Dimension(150,20));


        //Imagen
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/en-stock.png"));
        Image image = imageIcon.getImage();
        Image Tamanio = image.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(Tamanio);
        icon2.setIcon(imageIcon1);

        ImageIcon imagen = new ImageIcon(getClass().getResource("/ventas.png"));
        Image image1 = imagen.getImage();
        Image Tamanio1 = image1.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon imageIcon2 = new ImageIcon(Tamanio1);
        icon3.setIcon(imageIcon2);

        ImageIcon imagen3 = new ImageIcon(getClass().getResource("/nueva-cuenta.png"));
        Image image3 = imagen3.getImage();
        Image Tamanio3 = image3.getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon imageIcon3 = new ImageIcon(Tamanio3);
        icon4.setIcon(imageIcon3);

        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agregarusuarios frame = new Agregarusuarios();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(550,350));
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
            }
        });
        regresarButton.addActionListener(new ActionListener() {
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
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProductos Aproducts = new AgregarProductos();
                Aproducts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Aproducts.setSize(new Dimension(650,700));
                Aproducts.setLocationRelativeTo(null);
                Aproducts.setVisible(true);
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        new Adminform();
    }

}
