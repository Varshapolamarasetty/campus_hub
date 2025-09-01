package com.campushub.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.campushub.util.DBConnection;

@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("userEmail") == null){
            response.sendRedirect("login.html");
            return;
        }

        String email = session.getAttribute("userEmail").toString();
        String newPassword = request.getParameter("newPassword");

        try(Connection conn = DBConnection.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET password=? WHERE email=?");
            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            stmt.executeUpdate();
        } catch(Exception e){ e.printStackTrace(); }

        response.setStatus(HttpServletResponse.SC_OK);
    }
}
