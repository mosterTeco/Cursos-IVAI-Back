package mx.ivai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static String url="jdbc:mysql://localhost:3306/dbo";
    public static String Drivername="com.mysql.cj.jdbc.Driver";
    public static String username="IVAI_db";
    public static String password="trans_ivai";

    private static Connection conexion=null;

    public static Connection getConnection(){   
        try {
            Class.forName(Drivername);
            conexion = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(" SQL:" + e);
        } catch (ClassNotFoundException e){
            System.out.println("Driver:" + e);
        }
        return conexion;
    }
}
