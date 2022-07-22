package main.java.com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/form-handler" })
public class FormHandlerServlet extends HttpServlet
{
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final String textValue = request.getParameter("text-input");
        System.out.println("You submitted: " + textValue);
        response.getWriter().println("You submitted: " + textValue);
    }
}
