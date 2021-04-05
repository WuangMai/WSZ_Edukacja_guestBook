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
        String [] arr = {request.getParameter("u")};
        request.setAttribute("user", ud.read(arr));

        getServletContext().getRequestDispatcher("/guestBook/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        User user = new User(request.getParameter("name"), request.getParameter("surname"),
//                request.getParameter("email"), request.getParameter("password"), request.getParameter("nick"),
//                request.getParameter("phone"), request.getParameter("userId"));
        User user = new User(request.getParameter("name"), request.getParameter("surname"),request.getParameter("email"),request.getParameter("password"),request.getParameter("nick"),request.getParameter("phone"),request.getParameter("userId"));

        System.out.println(user.getUserId());

        try {
            DbUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UserDAO ud = new UserDAO();
        ud.update(user);
        response.sendRedirect("/profil?u=" + user.getUserId());
    }

}
