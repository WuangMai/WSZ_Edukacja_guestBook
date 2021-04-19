package pl.wsz.users;

import org.apache.commons.lang3.ArrayUtils;
import org.mindrot.jbcrypt.BCrypt;
import pl.wsz.utils.DbUtil;

import java.sql.*;
import java.util.Arrays;

public class UserDAO {
    private static final String CREATE_USER_QUERY = "INSERT INTO users(name, surname, email, phone, password, user_id) VALUES (?,?,?,?,?,?)";
    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET name = ?, surname = ?, nick = ?, email = ?, phone = ?, password = ? WHERE user_id = ?";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";

    private final String DBurl = "jdbc:mysql://localhost:3306/guest_book";
    private final String DBuser = "root";
    private final String DBpass = "coderslab";

    public User create(User user) {
        HashClass hs = new HashClass();

        try (Connection conn = DriverManager.getConnection(DBurl, DBuser, DBpass)) {
            PreparedStatement preStmt = conn.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preStmt.setString(1, user.getName());
            preStmt.setString(2, user.getSurname());
            preStmt.setString(3, user.getEmail());
            preStmt.setString(4, user.getPhone());
            preStmt.setString(5, hashPw(user.getPassword()));
            preStmt.setString(6, hs.getHash());
            preStmt.executeUpdate();

            ResultSet rs = preStmt.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            preStmt.close();
            rs.close();
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

//    public User read(int UserId) {
//        ResultSet rs = null;
//        PreparedStatement preStmt = null;
//        Connection conn = null;
//        User user = new User();
//
//        try {
//            conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
//            preStmt = conn.prepareStatement(READ_USER_QUERY);
//            preStmt.setInt(1, UserId);
//
//            rs = preStmt.executeQuery();
//            if (rs.next()) {
//                int columnCount = rs.getMetaData().getColumnCount();
//                setUser(rs, user, columnCount);
//            }
//            return user;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            closeConnections(preStmt, conn, rs);
//        }
//        return null;
//    }

    public User read(String email) {
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        Connection conn = null;
        User user = new User();
        try {
            conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
            preStmt = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
            preStmt.setString(1, email);

            rs = preStmt.executeQuery();
            if (rs.next()) {
                int columnCount = rs.getMetaData().getColumnCount();
                setUser(rs, user, columnCount);
            }
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnections(preStmt, conn, rs);
        }
        return null;
    }

    public User read(String[] userId) {
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        Connection conn = null;
        User user = new User();
        try {
            conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
            preStmt = conn.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            preStmt.setString(1, userId[0]);

            rs = preStmt.executeQuery();
            if (rs.next()) {
                int columnCount = rs.getMetaData().getColumnCount();
                setUser(rs, user, columnCount);
            }
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnections(preStmt, conn, rs);
        }
        return null;
    }

    public User[] findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        User[] returnUser = new User[0];
        User user = new User();
        try {
            conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");

            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                setUser(rs, user, columnCount);
                returnUser = ArrayUtils.add(returnUser, user);
                user = new User();
            }

            return returnUser;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            closeConnections(null, conn, rs);
        }
        return null;
    }

    private void setUser(ResultSet rs, User user, int columnCount) throws SQLException {
        for (int i = 1; i <= columnCount; i++) {
            switch (i) {
                case 1 -> user.setId(rs.getInt(i));
                case 2 -> user.setName(rs.getString(i));
                case 3 -> user.setSurname(rs.getString(i));
                case 4 -> user.setNick(rs.getString(i));
                case 5 -> user.setEmail(rs.getString(i));
                case 6 -> user.setPassword(rs.getString(i));
                case 7 -> user.setPhone(rs.getString(i));
                case 8 -> user.setUserId(rs.getString(i));
            }
        }
    }

    public void update(User user) {
        PreparedStatement preStmt = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
            preStmt = conn.prepareStatement(UPDATE_USER_QUERY);
//            "UPDATE users SET name = ?, surname = ?, nick = ?, email = ?, phone = ?, password = ? WHERE id = ?";
            preStmt.setString(1, user.getName());
            preStmt.setString(2, user.getSurname());
            preStmt.setString(3, user.getNick());
            preStmt.setString(4, user.getEmail());
            preStmt.setString(5, user.getPhone());
            preStmt.setString(6, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            preStmt.setString(7, user.getUserId());
            int result = preStmt.executeUpdate();
            System.out.println(result > 0 ? "Successfully updated database!" : "Query not executed. Probably not existing User ID?");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections(preStmt, conn, null);

        }
    }

    public void delete(int userId) {
        PreparedStatement preStmt = null;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DBurl, DBuser, DBpass);
            preStmt = conn.prepareStatement(DELETE_USER_QUERY);
            preStmt.setInt(1, userId);
            int result = preStmt.executeUpdate();
            System.out.println(result > 0 ? "Successfully updated database!" : "Query not executed. Probably not existing User ID?");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections(preStmt, conn, null);
        }
    }

    private void closeConnections(PreparedStatement preStmt, Connection conn, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preStmt != null) {
            try {
                preStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String hashPw(String pass) {
        return BCrypt.hashpw(pass, BCrypt.gensalt(11));
//        return pass;
    }
}
