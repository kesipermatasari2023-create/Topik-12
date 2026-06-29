public class MainApp {

    public static void main(String[] args) {

        System.out.println("PROGRAM JALAN");

        HeroDAO dao = new HeroDAO();

        // Update level hero dengan ID = 1 menjadi 100
        dao.updateLevel(1, 100);

        // Hapus hero dengan ID = 2
        dao.hapusHero(2);

        // Tampilkan data
        dao.tampil();
    }
}