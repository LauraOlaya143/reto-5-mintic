import java.sql.*;
import javax.swing.table.*;

public class modeloTres extends DefaultTableModel {
    ResultSet datos;

    public modeloTres() {
        this.addColumn("ID Compra");
        this.addColumn("Constructora");
        this.addColumn("Banco Vinculado");
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/Users/Laura Sofia/Desktop/prueba mintic/empresa/ProyectosConstruccion.db");
            System.out.println("Conexión abierta con la base de datos");

            Statement stmt = c.createStatement();
            String consulta = "SELECT ID_Compra, Constructora ,Banco_Vinculado FROM Compra NATURAL JOIN Proyecto WHERE Ciudad='Salento' AND Proveedor='Homecenter';";
            datos = stmt.executeQuery(consulta);

            while(datos.next()){
                Object [] file = new Object[3];
                for(int i=0; i<3; i++){
                    file[i] = datos.getObject(i+1);
                }
                this.addRow(file);
            }

            stmt.close();
            c.close();
            System.out.println("La consulta se realizo con exito!");

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
