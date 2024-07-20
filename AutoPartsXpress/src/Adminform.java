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

        //Panel
        Border borde4 = BorderFactory.createLineBorder(null,1,true);
        Panel1.setBorder(borde4);
        //Imagen
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/administrador.png"));
        Image image = imageIcon.getImage();
        Image Tamanio = image.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(Tamanio);
        Image1.setIcon(imageIcon1);


        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agregarusuarios frame = new Agregarusuarios();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300,600);
                frame.setSize(new Dimension(500,320));
                frame.pack();
                frame.setLocationRelativeTo(null);
                dispose();
            }
        });
    }

}
