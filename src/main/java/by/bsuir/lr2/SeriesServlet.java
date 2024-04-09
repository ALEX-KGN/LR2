package by.bsuir.lr2;

import java.io.*;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.RequiredArgsConstructor;

@WebServlet(value = "/series")
public class SeriesServlet extends HttpServlet {

    @EJB
    private SeriesService seriesService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double rating = 0;

        String ratingParam = request.getParameter("rating");
        if (ratingParam != null && !ratingParam.isEmpty()) {
            rating = Double.parseDouble(ratingParam);
        }

        request.setAttribute("seriesList", seriesService.getByRating(rating));
        request.setAttribute("selectedRating", ratingParam);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/out.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        double rating = Double.parseDouble(request.getParameter("rating"));
        int numbers = Integer.parseInt(request.getParameter("numbers"));

        Series newSeries = Series.builder()
                .name(name)
                .rating(rating)
                .numbers(numbers)
                .build();

        seriesService.save(newSeries);
        response.sendRedirect("/LR2-1.0-SNAPSHOT/series");
    }

    public void destroy() {
    }
}