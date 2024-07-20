import javax.swing.*;

public class LogForm2 extends JFrame {
    public JPanel mainPanel2;
    public JTextField UserAdmin;
    public JTextField PassAdmin;
    public JButton ingresarButton;

    public LogForm2() {
        setTitle("Inicio de sesion Administradores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel2);
        pack();
    }
}
