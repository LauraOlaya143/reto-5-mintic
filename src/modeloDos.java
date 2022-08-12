import java.sql.*;
import javax.swing.table.*;

public class modeloDos extends DefaultTableModel {
    ResultSet datos;

    public modeloDos() {
        this.addColumn("ID proyecto");
        this.addColumn("Constructora");
        this.addColumn("Numero de Habitaciones");
        this.addColumn("Ciudad");
        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite://C:/Users/Laura Sofia/Desktop/prueba mintic/empresa/ProyectosConstruccion.db");
            System.out.println("Conexión abierta con la base de datos");

            Statement stmt = c.createStatement();
            String consulta = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND (Ciudad = 'Santa Marta' OR Ciudad = 'Cartagena' OR Ciudad = 'Barranquilla');";
            datos = stmt.executeQuery(consulta);

            while(datos.next()){
                Object [] file = new Object[5];
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
