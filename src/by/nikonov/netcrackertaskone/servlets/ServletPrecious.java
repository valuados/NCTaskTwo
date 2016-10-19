package by.nikonov.netcrackertaskone.servlets;

import by.nikonov.netcrackertaskone.classes.helper.ServletHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by valua on 10/18/2016.
 */
public class ServletPrecious extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        ServletHelper servletHelper = new ServletHelper();
        servletHelper.addStone("precious", request, response);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);


    }


}
