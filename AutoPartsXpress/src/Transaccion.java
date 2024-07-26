import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaccion extends JFrame {
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


    public Transaccion(){
        setTitle("Transaccion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Mpanel);
        setSize(820,700);
        setLocationRelativeTo(null);
        setVisible(true);

        Mpanel.setLayout(null);
        //Imagen
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/IMG/punto-de-venta.png"));
        Image image = imageIcon.getImage();
        Image Tamanio = image.getScaledInstance(300,300,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(Tamanio);
        icon1.setIcon(imageIcon1);
        icon1.setBounds(500,100,300,300);

        //Cajero
        Nvendedor.setBounds(93,50,150,20);
        Evendedor.setBounds(318,50,150,20);
        Dvendedor.setBounds(93,100,150,20);
        Tvendedor.setBounds(93,150,150,20);
        Cvendedor.setBounds(318,100,150,20);
        Tv.setBounds(40,147,150,20);
        Cv.setBounds(268,98,150,20);
        Dv.setBounds(10,98,150,20);

        //Cliente
        Etc.setBounds(35,230,150,20);
        Ncliente.setBounds(93,290,150,20);
        Dcliente.setBounds(93,335,150,20);
        Tcliente.setBounds(93,380,150,20);
        Ecliente.setBounds(318,290,150,20);
        Ccliente.setBounds(318,335,150,20);

        Nc.setBounds(20,287,150,20);
        Dc.setBounds(10,332,150,20);
        Tc.setBounds(35,376,150,20);
        Ec.setBounds(268,287,150,20);
        Cc.setBounds(268,332,150,20);

        //Productos
        Dtf.setBounds(35,445,150,20);

        Nproducto.setBounds(93,505,150,20);
        Cantproducto.setBounds(325,505,150,20);
        Prproducto.setBounds(570,505,150,20);
        Total.setBounds(93,550,150,20);
        TotalF.setBounds(93,595,150,20);

        pf.setBounds(20,503,150,20);
        tf.setBounds(27,547,150,20);
        tiv.setBounds(10,592,150,20);
        tcan.setBounds(262,503,150,20);
        tprec.setBounds(506,503,150,20);

        //Botones
        Gbutton.setBounds(350,630,100,25);
        Rbutton.setBounds(93,630,100,25);


        Rbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cajerform cajerform = new Cajerform();
                cajerform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cajerform.setSize(600,440);
                cajerform.setLocationRelativeTo(null);
                cajerform.setVisible(true);
                dispose();

            }
        });
        Gbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args) {
        new Transaccion();
    }
}

