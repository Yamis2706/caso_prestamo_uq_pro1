package co.edu.uniquindio.prestamo.model;

public class Prestamo {

    /**
     * Atributos clase Préstamos
     */
    private String numeroPrestamo;
    private String fechaPrestamo;
    private String fechaEntrega;
    private String descripcion;
    PrestamoUq ownedByPrestamoUq;

    /**
     * Constructor vacío
     */
    public Prestamo() {
    }

    /**
     * Constructor con parámetros
     * @param numeroPrestamo
     * @param fechaPrestamo
     * @param fechaEntrega
     * @param descripcion
     */
    public Prestamo(String numeroPrestamo, String fechaPrestamo, String fechaEntrega, String descripcion) {
        this.numeroPrestamo = numeroPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
    }

    /**
     * Getters y Setters
     * @return
     */
    public String getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(String numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PrestamoUq getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoUq ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "numeroPrestamo=" + numeroPrestamo +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}