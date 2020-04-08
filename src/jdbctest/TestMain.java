package jdbctest;

public class TestMain {
    public static void main(String[] args) {

        ComicsDAO dao = new ComicsDAO();
        System.out.println(dao.getComics());

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(dao.getComics());
        System.out.println(dao.getComics());
        System.out.println(dao.getComics());

        System.out.println();
        System.out.println();
        System.out.println();

        dao.insert("계초리는 귀여운척 하는게 아니로 귀여운건뎅", 30000, "FANT", "GODN");


        for (ComicVO vo : dao.getComics()) {
            System.out.println(vo);
        }

    }
}
