package pl.wsz.users.Entry;

import pl.wsz.users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntryDAO {
    private static final String READ_ENTRIES_QUERY = "SELECT * FROM book";
    private static final String CREATE_ENTRY_QUERY = "INSERT INTO book (user_id, content, added) VALUES (?,?,NOW())";
    private static final String GET_USER_NAME_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";


    private final String DBurl = "jdbc:mysql://localhost:3306/guest_book";
    private final String DBuser = "root";
    private final String DBpass = "coderslab";


    public Entry create(Entry entry) {
        try (Connection conn = DriverManager.getConnection(DBurl, DBuser, DBpass)) {
            PreparedStatement statement = conn.prepareStatement(CREATE_ENTRY_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entry.getUserId());
            statement.setString(2, entry.getContent());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                entry.setId(rs.getInt(1));
            }
            statement.close();
            rs.close();
            return entry;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Entry> readAll() {
        List<Entry> entryList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
             PreparedStatement statement = conn.prepareStatement(READ_ENTRIES_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Entry entry = new Entry();
                entry.setId(rs.getInt("id"));
                entry.setUserId(rs.getInt("user_id"));
                entry.setContent(rs.getString("content"));
                entry.setAddedTime(rs.getString("added"));
                entryList.add(entry);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entryList;
    }

    public User getUserNameByID(int id) {
        User user = new User();
        try (Connection conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
             PreparedStatement statement = conn.prepareStatement(GET_USER_NAME_BY_ID_QUERY)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                user.setId((rs.getInt("id")));
                user.setUserId(rs.getString("user_id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setNick(rs.getString("nick"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
            }
            statement.close();
            rs.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
