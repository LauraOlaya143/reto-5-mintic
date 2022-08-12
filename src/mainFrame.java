import java.awt.*;
import javax.swing.*;

class mainFrame extends JFrame {
    public void inicializar(){
        JTabbedPane pestanas = new JTabbedPane();

        pestanas.setBackground(new Color(255, 177, 224));
        pestanas.setForeground(new Color(107, 52, 70));

        modeloTabla1 tabla_1 = new modeloTabla1();

        modeloTabla2 tabla_2 = new modeloTabla2();

        modeloTabla3 tabla_3 = new modeloTabla3();

        pestanas.addTab("Informe 1", tabla_1);
        pestanas.addTab("informe 2", tabla_2);
        pestanas.addTab("informe 3", tabla_3);

        add(pestanas, BorderLayout.CENTER);
        //add(panelPrincipal);

        setTitle("Bienvenido a la App!");
        setSize(600, 600);
        setMaximumSize(new Dimension(800, 800));
        setMinimumSize(new Dimension(400, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        mainFrame ventana = new mainFrame();
        ventana.inicializar();
    }
}

