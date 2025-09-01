package com.campushub.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.campushub.util.DBConnection;

@WebServlet("/dbtest")
public class DBTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                response.getWriter().println("<h3>✅ Database connection successful!</h3>");
            } else {
                response.getWriter().println("<h3>❌ Database connection failed!</h3>");
            }
        } catch (Exception e) {
            response.getWriter().println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
    }
}
