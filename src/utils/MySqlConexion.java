package utils;
import java.sql.Connection;
import java.sql.DriverManager;
public class MySqlConexion {
    public static Connection getConexion(){
        Connection cn=null;
        try {
            //acceder a la clase Driver que se encuentra en el jar
            Class.forName("com.mysql.cj.jdbc.Driver");
            //variables
            String user="root";
            String pass="root";
            String url="jdbc:mysql://localhost:3306/colegio2026?serverTimezone=UTC";
            //crear una instancia de Connection "cn"
            cn=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cn;
    }
}
