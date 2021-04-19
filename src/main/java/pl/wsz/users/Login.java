package pl.wsz.users;

import org.mindrot.jbcrypt.BCrypt;
import pl.wsz.utils.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        if (sess.getAttribute("logged") == null) {
            getServletContext().getRequestDispatcher("/guestBook/login.jsp").forward(request, response);
        } else {
            response.sendRedirect("/profil");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO ud = new UserDAO();
        HttpSession sess = request.getSession();

        try {
            DbUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String login = request.getParameter("email");
        String pass = request.getParameter("password");

        User user = ud.read(login);

        if (login.equals(user.getEmail()) && BCrypt.checkpw(pass, user.getPassword())) {
            sess.setAttribute("logged", user);
            response.sendRedirect("/profil");
        } else {
            getServletContext().getRequestDispatcher("/guestBook/login.jsp").forward(request, response);
        }
    }
}
