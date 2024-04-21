public class Usuarios {

    //maquetado de la tabla usuarios
    private int idUsuarios;
    private String email;
    private String constraseña;
    private String rol:

    //constructores
    public Usuarios(int idUsuarios, String email, String constraseña, String rol) {
        this.idUsuarios = idUsuarios;
        this.email = email;
        this.constraseña = constraseña;
        this.rol = rol;
    }

    //getter y setter


    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConstraseña() {
        return constraseña;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

