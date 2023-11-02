/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto_hades;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String[] datos = new String[7];
        datos[0] = nombre;
        datos[1] = apellido1;
        datos[2] = apellido2;
        datos[3] = email;
        datos[4] = phone;
        datos[5] = usuario;
        datos[6] = password;
        System.out.println(Arrays.toString(datos));
        System.out.println(nombre);
        System.out.println(apellido1);
        System.out.println(apellido2);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(usuario);
        System.out.println(password);
        response.sendRedirect(request.getContextPath()+ "/signin.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
