package org.example.base;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HtmlServlet", value = "/html-servlet")
public class HtmlServlet extends HttpServlet {

    private String texte;

    public void init() {
        texte = "Never gonna let you down";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>"+texte+"</h1>");
    }

    public void destroy() {
    }

}
