package pl.wsz.users.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static final String READ_ENTRIES_QUERY = "SELECT * FROM book";
    private static final String CREATE_ENTRY_QUERY = "INSERT INTO book (user_id, content, added) VALUES (?,?,NOW())";


    private final String DBurl = "jdbc:mysql://localhost:3306/guest_book";
    private final String DBuser = "root";
    private final String DBpass = "coderslab";


    public Book create(Book book) {
        try (Connection conn = DriverManager.getConnection(DBurl, DBuser, DBpass)) {
            PreparedStatement statement = conn.prepareStatement(CREATE_ENTRY_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, book.getUserId());
            statement.setString(2, book.getContent());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                book.setId(rs.getInt(1));
            }
            statement.close();
            rs.close();
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> readAll() {
        List<Book> bookList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
             PreparedStatement statement = conn.prepareStatement(READ_ENTRIES_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setUserId(rs.getInt("user_id"));
                book.setContent(rs.getString("content"));
                book.setAddedTime(rs.getString("added"));
                bookList.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
