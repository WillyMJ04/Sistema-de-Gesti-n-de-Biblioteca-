public class Empleados {

    //maquetado de la tabla empleados
    private int idEmpleados;
    private String nombre;


    //constructores
    public Empleados(int idEmpleados, String nombre) {
        this.idEmpleados = idEmpleados;
        this.nombre = nombre;
    }

    //getter y setter
    public int getIdEmpleados() {
        return idEmpleados;
    }

    public void setIdEmpleados(int idEmpleados) {
        this.idEmpleados = idEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}