/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servelet;

import codigoDB.ConexionApagadaException;
import codigoDB.ProyectoDAO;
import codigoDB.ProyectoDAO;
import modelo.User;
import modelo.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@WebServlet(urlPatterns={"/SvUsuarios"})
public class Servelet extends HttpServlet {
    
    public Servelet(){
        
    }
    
    public static ProyectoDAO controlador = new ProyectoDAO();

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
            throws ServletException, IOException, FileNotFoundException {
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("contrasena");
        try {
            controlador.conectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
        }
        User user = new User(usuario, password, email, "jugador");
        try {
            controlador.alta(user);
        } catch (ConexionApagadaException | SQLException ex) {
            Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            controlador.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Servelet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
