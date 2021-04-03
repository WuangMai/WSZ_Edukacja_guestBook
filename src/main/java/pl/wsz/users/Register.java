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

        Cookie[] cookies = request.getCookies();
        boolean logged = false;
        for (Cookie c : cookies){
            if("auth".equals(c.getName())){
                logged = true;
            }
        }

        try {
            DbUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (action[0].equals("back")) {
            response.sendRedirect("/main");
        } else if (action[0].equals("add")) {
            if(logged) {
                User user = new User(request.getParameter("name"), request.getParameter("surname"), request.getParameter("email"), request.getParameter("password"), request.getParameter("phone"));
                ud.create(user);
                getServletContext().getRequestDispatcher("/main").forward(request, response);
            }else {
//                TODO this does nothing right now. add actions in view
                request.setAttribute("error","true");
            }
        }

    }
}
