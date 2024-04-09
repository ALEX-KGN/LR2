package by.bsuir.lr2;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/edit")
public class GetEditPageServlet extends HttpServlet {

    @EJB
    private SeriesService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = null;

        String ratingParam = req.getParameter("name");
        if (ratingParam != null && !ratingParam.isEmpty()) {
            id = ratingParam;
        }
        Series series = service.getById(id);

        req.setAttribute("param", series);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(req, resp);
    }
}
