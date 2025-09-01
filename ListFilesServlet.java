package com.campushub.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listFiles")
public class ListFilesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String uploadPath = getServletContext().getRealPath("/uploads");

        File folder = new File(uploadPath);
        System.out.println("Listing path: " + uploadPath);

        List<String> files = new ArrayList<>();

        if (folder.exists()) {
            for (File file : folder.listFiles()) {
                files.add(file.getName());
            }
        }

        // Build JSON manually
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < files.size(); i++) {
            json.append("\"").append(files.get(i)).append("\"");
            if (i < files.size() - 1) json.append(",");
        }
        json.append("]");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toString());
    }
}
