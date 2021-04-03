package pl.wsz.users;

import pl.wsz.utils.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/guestBook/register.jsp").forward(request, response);
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
        } else if (action[0].equals("add")) {
            User user = new User(request.getParameter("name"), request.getParameter("surname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("phone"));
            ud.create(user);
            System.out.println("Creating user with:");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password: " + user.getPassword());
            getServletContext().getRequestDispatcher("/main").forward(request, response);
        }

    }
}
