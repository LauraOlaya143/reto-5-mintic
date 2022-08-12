import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class modeloTabla2 extends JPanel {
    modeloDos modelo2 = new modeloDos();

    public modeloTabla2(){
        setLayout(new BorderLayout());
        
        JTable tablaDatos = new JTable(modelo2);

        JTableHeader header = tablaDatos.getTableHeader();
        header.setBackground(new Color(107, 52, 70));
        header.setForeground(Color.WHITE);

        tablaDatos.setBackground(new java.awt.Color(255, 217, 230));
        tablaDatos.setSelectionForeground(Color.WHITE);
        tablaDatos.setSelectionBackground(new Color(255, 0, 155));
        tablaDatos.setForeground(new Color(124, 42, 68));
        tablaDatos.setGridColor(new Color(124, 42, 68));

        JScrollPane panelTabla = new JScrollPane(tablaDatos);
        add(panelTabla, BorderLayout.CENTER);
    }

}
