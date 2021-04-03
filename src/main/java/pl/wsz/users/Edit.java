package pl.wsz.users;

import pl.wsz.utils.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit")
public class Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DbUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserDAO ud = new UserDAO();
        request.setAttribute("user",ud.read(request.getParameter("user")));

        getServletContext().getRequestDispatcher("/guestBook/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
