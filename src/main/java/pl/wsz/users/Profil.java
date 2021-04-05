package pl.wsz.users;

import pl.wsz.utils.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profil")
public class Profil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DbUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserDAO ud = new UserDAO();
        String[] arr = new String[1];
        arr[0] = request.getParameter("u");
        request.setAttribute("user",ud.read(arr));

        getServletContext().getRequestDispatcher("/guestBook/profil.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
