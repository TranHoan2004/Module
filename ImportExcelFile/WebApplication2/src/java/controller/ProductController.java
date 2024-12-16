/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import utils.ImportExcelFile;

/**
 * @author ADMIN
 */
@WebServlet(name = "ProductController", urlPatterns = {"/product"})
@MultipartConfig
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Part filePart = request.getPart("file");
            request.setAttribute("data", ImportExcelFile.getData(filePart));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.getWriter().print("File upload failed");
        } finally {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
