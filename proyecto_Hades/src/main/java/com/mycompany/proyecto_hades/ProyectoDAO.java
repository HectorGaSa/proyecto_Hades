/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_hades;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet(name = "ProyectoDAO", urlPatterns = {"/ProyectoDAO"})

public class ProyectoDAO extends HttpServlet {

    private Connection conexion;

    //Este metodo sirve para poder conectarnos a la base de datos que queremos usar. Tan solo necesitaremos el usuario, la contraseña y la url, los cuales estan dentro del archivo properties.
    public void conectar() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        //Emulador.configuracion.load(new FileInputStream(new File(System.getProperty("user.home") + "/.proyecto/proyecto.conf")));
        //conexion = DriverManager.getConnection(Emulador.configuracion.getProperty("Url"), Emulador.configuracion.getProperty("UserDB"), Emulador.configuracion.getProperty("Passwd"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileNotFoundException {
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
    }
    /*
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileNotFoundException {
        try {
            conectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProyectoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }

        // Parsear y procesar los datos
        //JSONObject requestData = new JSONObject(requestBody.toString());
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
        //try {
            //insertUsuario(datos);
        //} catch (SQLException ex) {
            //Logger.getLogger(ProyectoDAO.class.getName()).log(Level.SEVERE, null, ex);
        //}

        // Realizar operaciones en Java con los datos
        // ...
        // Enviar una respuesta
        //JSONObject jsonResponse = new JSONObject();
        //jsonResponse.put("mensaje", "Datos recibidos y procesados con éxito");

        response.setContentType("application/json");
        //response.getWriter().write(jsonResponse.toString());
    }

    /*
    //Este metodo sirve para hacer una serie de consultas a la base de datos para asi poder añadir un planeta o bien comprobar si ya existe ese planeta.
    public void insertUsuario(String[] datos) throws SQLException, ConexionApagadaException {
        if (conexion == null) {
            //throw new ConexionApagadaException();
        } else {
            String insert = "insert into usario(nom_usuari, contrasenya, correu, tipus) values (?, ?, ?, ?);";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, datos[5]);
            ps.setString(2, datos[6]);
            ps.setString(3, datos[3]);
            ps.setString(4, null);
            ps.executeUpdate();
            ps.close();

        }
    }

    //Este metodo simplemente es para desconectarnos de la base de datos.
    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public void alta(User u) throws ConexionApagadaException, SQLException {
        if (conexion == null) {
            throw new ConexionApagadaException();
        } else {
            if (existeUsuario(u.getNom_usuari()) == true) {
                System.out.println("Este usuario ya esta registrado!");
            } else {
                String insert = "insert into usario(nom_usuari, contrasenya, correu, tipus) values (?, ?, ?, ?);";
                PreparedStatement ps = conexion.prepareStatement(insert);
                ps.setString(1, u.getNom_usuari());
                ps.setString(2, u.getContrasenya());
                ps.setString(3, u.getEmail());
                ps.setString(4, u.getTipus());
                ps.executeUpdate();
                ps.close();
            }
        }
    }

    public void baja(User u) throws ConexionApagadaException, SQLException {
        if (conexion == null) {
            throw new ConexionApagadaException();
        } else {
            if (existeUsuario(u.getNom_usuari()) == false) {
                System.out.println("Este usuario no se puede dar de baja porque no existe!");
            } else {
                String delete = "delete from usario where nom_usuari = " + u.getNom_usuari() + ";";
                PreparedStatement ps = conexion.prepareStatement(delete);
                ps.executeUpdate();
                ps.close();
            }
        }
    }

    public void modificar(User u, int valor, String dato) throws ConexionApagadaException, SQLException {
        if (conexion == null) {
            throw new ConexionApagadaException();
        } else {
            switch (valor) {
                case 0:
                    String update = "update usuari set contrasenya = " + dato + " where nom_usuari = " + u.getNom_usuari() + ";";
                    PreparedStatement ps = conexion.prepareStatement(update);
                    ps.executeUpdate();
                    ps.close();
                    break;
                case 1:
                    update = "update usuari set correu = " + dato + " where nom_usuari = " + u.getNom_usuari() + ";";
                    ps = conexion.prepareStatement(update);
                    ps.executeUpdate();
                    ps.close();
                    break;
                case 2:
                    update = "update usuari set tipus = " + dato + " where nom_usuari = " + u.getNom_usuari() + ";";
                    ps = conexion.prepareStatement(update);
                    ps.executeUpdate();
                    ps.close();
                    break;
            }
        }
    }

    public void listar() throws SQLException, ConexionApagadaException {
        if (conexion == null) {
            throw new ConexionApagadaException();
        } else {
            String select = "select * from usuari;";
            PreparedStatement ps = conexion.prepareStatement(select);
            ps.executeUpdate();
            ps.close();
        }
    }

    //Este metodo sirve para comprobar si el especimen que le pasamos esta añadido en la base de datos.
    private boolean existeUsuario(String usuari) throws SQLException, ConexionApagadaException {
        if (conexion == null) {
            throw new ConexionApagadaException();
        } else {
            String query = "select nom_usuari from usario where nom_usuari = '" + usuari + "';";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            boolean existe;
            existe = rs.next();
            rs.close();
            st.close();
            return existe;
        }
    }
     */
}
