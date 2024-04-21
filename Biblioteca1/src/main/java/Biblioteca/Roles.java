public class Roles {

    //maquetado de la tabla roles
    private int idRoles;
    private String nombre;

    //constructores


    public Roles(int idRoles, String nombre) {
        this.idRoles = idRoles;
        this.nombre = nombre;
    }

    //getter y setter
    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}