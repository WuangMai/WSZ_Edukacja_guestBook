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

//            System.out.println("pobrany login: " + login);
//            System.out.println("pobrany pass: " + pass);

            User user;
            user = ud.read(login);


//            System.out.println("odczytany email: " + user.getEmail());
//            System.out.println("odczytany name: " + user.getName());
//            System.out.println("odczytany surname: " + user.getSurname());
//            System.out.println("odczytany nick: " + user.getNick());
//            System.out.println("odczytany phone: " + user.getPhone());
//            System.out.println("odczytany id: " + user.getId());
//
//
//            String readPw = user.getPassword().trim().strip();
//            System.out.println("odczytany pass: " + readPw);
//            System.out.println("sprawdzenie hasła: " + BCrypt.checkpw(pass, readPw));


            if (login.equals(user.getEmail()) && BCrypt.checkpw(pass, user.getPassword())) {
                request.setAttribute("success", true);
                System.out.println("success");

            }

            getServletContext().getRequestDispatcher("/guestBook/login.jsp").forward(request, response);
        }

    }
}
