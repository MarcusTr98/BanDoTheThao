package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {

    String strDbUrl = "jdbc:sqlserver://localhost;" + "databaseName=BanDoTheThao;user=sa;password=123;";
    Connection conn;

    public ConnectDB() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(strDbUrl);

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Thực thi câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL) {
        try {
            Statement sta = conn.createStatement();
            ResultSet result = sta.executeQuery(cauTruyVanSQL);
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    //Thực thi INSERT, DELETE, UPDATE
    public void ExcuteQueryUpdateDB(String cauTruyVanSQL) {

        try {
            Statement sta = conn.createStatement();
            sta.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
