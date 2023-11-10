/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.regex.Pattern;

/**
 *
 * @author usuario
 */
public class User {



    private static final String Password_Regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$)$";
    private static final Pattern Password_Pattern = Pattern.compile(Password_Regex);
    private String nom_usuari;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String contrasenya;
    private String email;
    private String tipus;

    public User(String nom_usuari, String nombre, String apellido1, String apellido2, String telefono, String contrasenya, String email, String tipus) {
        this.nom_usuari = nom_usuari;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.contrasenya = contrasenya;
        this.email = email;
        this.tipus = tipus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    public String getNom_usuari() {
        return nom_usuari;
    }

    public void setNom_usuari(String nom_usuari) {
        this.nom_usuari = nom_usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        Boolean comprobador = comprobarContrasenya(contrasenya);
        if (comprobador == true) {
            this.contrasenya = contrasenya;
        } else {
            System.out.println("La contraseña no es valida, porfavor tiene que contener al menos una mayuscula, una minuscula, un caracter especial y un numero!");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    private boolean comprobarContrasenya(String contrasenya) {
        boolean Verecidad;
        if (Password_Pattern.matcher(contrasenya).matches()) {
            Verecidad = true;
        } else {
            System.out.println("La contraseña introducida no es valida");
            Verecidad = false;
        }
        return Verecidad;
    }

}
