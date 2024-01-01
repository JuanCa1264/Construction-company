
package com.modelo;

/**
 *
 * @author JC
 */
public class Usuarios {
    private int iduser;
    private String fullname;
    private String username;
    private String password;
    private int idrol;
    private int estado;

    public Usuarios(int iduser, String fullname, String username, String password, int idrol, int estado) {
        this.iduser = iduser;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.idrol = idrol;
        this.estado = estado;
    }

    public Usuarios() {
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
