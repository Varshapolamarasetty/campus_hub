package com.campushub.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.campushub.util.DBConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT name, role FROM users WHERE email=? AND password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");

                HttpSession session = request.getSession();
                session.setAttribute("userEmail", email);
                session.setAttribute("userName", name);
                session.setAttribute("role", role);

                // ✅ redirect only once based on role
                if ("admin".equalsIgnoreCase(role)) {
                    response.sendRedirect("dashboard_admin.html");
                } else {
                    response.sendRedirect("dashboard_student.html");
                }

            } else {
                response.sendRedirect("login.html?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.html?error=2");
        }
    }
}
