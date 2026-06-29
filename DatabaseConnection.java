import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/hero_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Koneksi Berhasil!");

            return conn;

        } catch (ClassNotFoundException e) {

            System.out.println("Driver MySQL tidak ditemukan!");

        } catch (SQLException e) {

            System.out.println("Gagal terhubung ke Database!");

        }

        return null;
    }

}