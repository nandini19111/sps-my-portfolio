package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submission")
public class PortfolioServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    final String Answer = request.getParameter("text-input");

    // Print the value so you can see it in the server logs.
    System.out.println("Your email and purpose is: " + Answer);

    // Write the value to the response so the user can see it.
    response.getWriter().println("Your email and purpose is: " + Answer);

    //Redirect the user back to the main page
    response.sendRedirect("https://nsharma-sps-summer22.appspot.com");
  }
}
