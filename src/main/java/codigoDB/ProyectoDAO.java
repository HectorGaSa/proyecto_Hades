/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigoDB;

import modelo.User;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServlet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProyectoDAO extends HttpServlet {

    private Connection conexion;

    //Este metodo sirve para poder conectarnos a la base de datos que queremos usar. Tan solo necesitaremos el usuario, la contraseña y la url, los cuales estan dentro del archivo properties.
    public void conectar() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto616", "postgres", "1234");
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
                String insert = "insert into usuario(nom_usuari, contrasenya, correu, tipus) values (?, ?, ?, ?);";
                try (PreparedStatement ps = conexion.prepareStatement(insert)) {
                    ps.setString(1, u.getNom_usuari());
                    ps.setString(2, u.getContrasenya());
                    ps.setString(3, u.getEmail());
                    ps.setString(4, u.getTipus());
                    ps.executeUpdate();
                }
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
                try (PreparedStatement ps = conexion.prepareStatement(delete)) {
                    ps.executeUpdate();
                }
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
            try (PreparedStatement ps = conexion.prepareStatement(select)) {
                ps.executeUpdate();
            }
        }
    }

    //Este metodo sirve para comprobar si el especimen que le pasamos esta añadido en la base de datos.
    private boolean existeUsuario(String usuari) throws SQLException, ConexionApagadaException {
        if (conexion == null) {
            throw new ConexionApagadaException();
        } else {
            String query = "select nom_usuari from usuario where nom_usuari = '" + usuari + "';";
            boolean existe;
            try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(query)) {
                existe = rs.next();
            }
            return existe;
        }
    }
}
