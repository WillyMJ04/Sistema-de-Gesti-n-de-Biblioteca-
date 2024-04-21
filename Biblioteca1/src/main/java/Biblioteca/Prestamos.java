public class Prestamos {

    //maquetado de la tabla prestamos
    private int idPrestamos;
    private int clienteId;
    private String isbn;
    private date fechaPrestamo;
    private date fechaDevolucionEsperada;
    private date fechaDevolucionReal;
    Private float multa;

    //contructores
    public Prestamos(int idPrestamos, int clienteId, String isbn, date fechaPrestamo, date fechaDevolucionEsperada, date fechaDevolucionReal, float multa) {
        this.idPrestamos = idPrestamos;
        this.clienteId = clienteId;
        this.isbn = isbn;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.multa = multa;
    }

    //getter y setter
    public int getIdPrestamos() {
        return idPrestamos;
    }

    public void setIdPrestamos(int idPrestamos) {
        this.idPrestamos = idPrestamos;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public date getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public void setFechaDevolucionEsperada(date fechaDevolucionEsperada) {
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
    }

    public date getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(date fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }
}