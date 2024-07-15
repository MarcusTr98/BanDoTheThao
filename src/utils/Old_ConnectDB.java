package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Old_ConnectDB {

    public static Connection con = null;

    public static Connection getConnect() {
        String strDbUrl = "jdbc:sqlserver://localhost:1433; databaseName=BanDoTheThao;user=sa;password=123;"
                + "encrypt=true;trustServerCertificate=true";
        try {
            con = DriverManager.getConnection(strDbUrl);
            System.out.println("Ket noi thanh cong!");
        } catch (SQLException e) {
            System.out.println("Disconnect " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        Old_ConnectDB.getConnect();
    }
}
