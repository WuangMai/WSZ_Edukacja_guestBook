package pl.wsz.users.Entry;

import pl.wsz.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        EntryDAO bd = new EntryDAO();

        List<Entry> entryList = bd.readAll();
        Map<Entry, User> entryMap = new HashMap<>();


        for (Entry entry : entryList) {
            entryMap.put(entry, bd.getUserNameByID(entry.getUserId()));
        }


        if (sess.getAttribute("logged") != null) {
//            request.setAttribute("entryList", bd.readAll());
            request.setAttribute("entryMap", entryMap);
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
        Entry entry = new Entry(user.getId(), content);
        EntryDAO bd = new EntryDAO();
        bd.create(entry);
        response.sendRedirect("/book");

    }
}
