package jdbctest;

import java.sql.*;
import java.util.ArrayList;

public class ComicsDAO {
    private ArrayList<ComicVO> comics;
    private boolean updateFlag;

    public ComicsDAO() {
        comics = new ArrayList<>();
        updateFlag = true;
    }

    public ComicsDAO(ArrayList<ComicVO> comics) {
        this.comics = comics;
        updateFlag = true;
    }

    public boolean insert(String title, int price, String category, String publisher) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        boolean result = false;

        try {
            connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

            pstmt = connection.prepareStatement("INSERT INTO comics VALUES(DEFAULT , ?, ?, ?, ?)");

            pstmt.setString(1, title);
            pstmt.setInt(2, price);
            pstmt.setString(3, category);
            pstmt.setString(4, publisher);

            result = pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        updateFlag = true;
        return result;
    }

    public ArrayList<ComicVO> getComics(){
        if ( !updateFlag ) {

            System.out.println("DB 접속 없이 getter 실행");
            return comics;
        }


        System.out.println("DB connection");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int size = comics.size();
        for (int i = 0; i < size; i++) {
            comics.remove(0);
        }

        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

            pstmt = conn.prepareStatement("SELECT * FROM comics");
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                String category = rs.getString("category_code");
                String publisher = rs.getString("publisher_code");

                comics.add(new ComicVO(id, title, price, category, publisher));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        updateFlag = false;
        return comics;
    }

}
