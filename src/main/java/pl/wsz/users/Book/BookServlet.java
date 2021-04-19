package pl.wsz.users.Book;

import pl.wsz.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        BookDAO bd = new BookDAO();

        if (sess.getAttribute("logged") != null) {
            request.setAttribute("entryList", bd.readAll());
            getServletContext().getRequestDispatcher("/guestBook/book.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        String content = request.getParameter("content");
        User user = (User) sess.getAttribute("logged");
        Book book = new Book(user.getId(), content);
        BookDAO bd = new BookDAO();
        bd.create(book);
        response.sendRedirect("/book");

    }
}
