package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.io.InputStream;


public class Conection {

    private Connection con;
    
    
    public Conection(){
        Properties props = new Properties();
        
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")){
            
            if (input == null){
                throw new IllegalStateException("Archivo config.properties no encontrado ( Perdí el filtro si llega a pasar D:)");
            }
            
            props.load(input);
            
            String url = props.getProperty("URL");
            String user = props.getProperty("USER");
            String password = props.getProperty("PASSWORD");
            
            if(url == null || user == null || password == null) {
                throw new IllegalStateException("Una o más propiedades de conexion no estan definidas");
              
            }
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa a la base de datos");
            
        }catch (IOException | ClassNotFoundException | SQLException | IllegalStateException e){
            System.err.println("Error en la conexión :((( ( Perdi el filtro si llega a pasar )");
            JOptionPane.showMessageDialog(null, "Error en la conexion: " + e.toString());
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
    public void closeConnection(){
        if(con != null) {
            try {
                con.close();
                System.out.println("Conexion cerrada exitosamente");
            }catch(SQLException e){
                System.err.println("Error al cerrar la conexion: " + e);
            }
        }
    }
    
}