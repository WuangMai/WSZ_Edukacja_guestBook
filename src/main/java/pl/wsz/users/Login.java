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
        getServletContext().getRequestDispatcher("/guestBook/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String[] action = request.getParameterValues("action");
        UserDAO ud = new UserDAO();

        try {
            DbUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (action[0].equals("back")) {
            response.sendRedirect("/main");
        } else if (action[0].equals("login")) {
            String login = request.getParameter("email");
            String pass = request.getParameter("password");

            User user;
            user = ud.read(login);
//TODO cookies encryption
            if (login.equals(user.getEmail()) && BCrypt.checkpw(pass, user.getPassword())) {
                request.setAttribute("success", true);
                Cookie cookie = new Cookie("auth", "success");
                cookie.setMaxAge(3600 * 24 * 3);
                response.addCookie(cookie);
                System.out.println("success");
                //TODO should this be in cookie?
                response.sendRedirect("/profil?user="+user.getEmail());

            }else {
                getServletContext().getRequestDispatcher("/guestBook/login.jsp").forward(request, response);
            }

        }

    }
}
