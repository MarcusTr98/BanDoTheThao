package utils;

import java.sql.*;

public class TestConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] agrs) {
        Connection connec;
        String url;
        try {
            url = "jdbc:sqlserver://localhost:1433;databaseName=BanDoTheThao;user=sa;password=123;"
            + "encrypt=true;trustServerCertificate=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connec = DriverManager.getConnection(url);
            System.out.println("Ket noi thanh cong!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
