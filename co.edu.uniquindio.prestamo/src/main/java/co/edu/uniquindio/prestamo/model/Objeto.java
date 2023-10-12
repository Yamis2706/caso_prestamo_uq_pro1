package co.edu.uniquindio.prestamo.model;

public class Objeto {

    /**
     * Atributos de la clase Objeto
     */
    private String nombre;
    private int numReferencia;
    PrestamoUq ownedByPrestamoUq;

    /**
     * Constructor vacío
     */
    public Objeto() {
    }

    /**
     * Constructor con parámetros
     * @param nombre
     * @param numReferencia
     */
    public Objeto(String nombre, int numReferencia) {
        this.nombre = nombre;
        this.numReferencia = numReferencia;
    }

    /**
     * Getters y setters
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(int numReferencia) {
        this.numReferencia = numReferencia;
    }

    public PrestamoUq getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoUq ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }
    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", numReferencia=" + numReferencia +
                '}';
    }
}