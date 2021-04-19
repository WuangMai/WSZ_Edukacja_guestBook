package pl.wsz.users;

import pl.wsz.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit")
public class Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        if (sess.getAttribute("logged") != null) {
            getServletContext().getRequestDispatcher("/guestBook/edit.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(request.getParameter("userId"), (Integer.parseInt(request.getParameter("id"))),
                request.getParameter("name"), request.getParameter("surname"),
                request.getParameter("email"), request.getParameter("password"), request.getParameter("nick"),
                request.getParameter("phone"));

        HttpSession sess = request.getSession();
        try {
            DbUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UserDAO ud = new UserDAO();
        ud.update(user);
        sess.setAttribute("logged", user);
        response.sendRedirect("/profil");
    }

}
