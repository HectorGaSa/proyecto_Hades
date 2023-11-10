/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servelet;

import codigoDB.ConexionApagadaException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import modelo.User;
import static servelet.Servelet.controlador;

/**
 *
 * @author Admin
 */
public class ProcessData {
    
    public static void proccesSignin(HttpServletRequest request) throws IOException{
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
        User user = new User(usuario, nombre,apellido1,apellido2,phone,password, email, "jugador");
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
    
    
}
