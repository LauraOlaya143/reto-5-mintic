import java.sql.*;
import javax.swing.table.*;

public class modeloUno extends DefaultTableModel {
    ResultSet datos;

    public modeloUno() {
        this.addColumn("ID lider");
        this.addColumn("Nombre");
        this.addColumn("Apellido");
        this.addColumn("Ciudad de Residencia");
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/Users/Laura Sofia/Desktop/prueba mintic/empresa/ProyectosConstruccion.db");
            System.out.println("Conexión abierta con la base de datos");

            Statement stmt = c.createStatement();
            String consulta = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia;";
            datos = stmt.executeQuery(consulta);

            while(datos.next()){
                Object [] file = new Object[4];
                for(int i=0; i<4; i++){
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
