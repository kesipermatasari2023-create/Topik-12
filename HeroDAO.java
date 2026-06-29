import java.sql.*;

public class HeroDAO {

    // ==========================
    // UPDATE
    // ==========================
    public void updateLevel(int id_target, int level_baru) {

        String sql = "UPDATE hero SET level = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // ? pertama = level baru
            ps.setInt(1, level_baru);

            // ? kedua = id hero yang akan diupdate
            ps.setInt(2, id_target);

            int hasil = ps.executeUpdate();

            if (hasil > 0) {
                System.out.println("Level Hero berhasil diupdate!");
            } else {
                System.out.println("Hero tidak ditemukan.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // DELETE
    // ==========================
    public void hapusHero(int id_target) {

        String sql = "DELETE FROM hero WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // ? = ID Hero yang akan dihapus
            ps.setInt(1, id_target);

            int hasil = ps.executeUpdate();

            if (hasil > 0) {
                System.out.println("Hero berhasil dihapus!");
            } else {
                System.out.println("Hero tidak ditemukan.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void tampil() {

    String sql = "SELECT * FROM hero";

    try (Connection conn = DatabaseConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {

            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("nama") + " " +
                rs.getInt("level")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}