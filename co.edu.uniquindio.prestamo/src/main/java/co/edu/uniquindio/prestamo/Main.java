package co.edu.uniquindio.prestamo;

import co.edu.uniquindio.prestamo.model.Cliente;
import co.edu.uniquindio.prestamo.model.Prestamo;
import co.edu.uniquindio.prestamo.model.PrestamoUq;
import java.util.List;

import static co.edu.uniquindio.prestamo.MainMenu.*;

public class Main {
    public static void main(String[] args) {

        PrestamoUq prestamoUq = inializarDatosPrueba();

        //CRUD

        //Create
        crearCliente("juan", "arias", "1094", 24, prestamoUq);
        crearCliente("ana", "alzate", "1095", 35, prestamoUq);
        crearCliente("maria", "perez", "1096", 22, prestamoUq);
        crearCliente("pedro", "arias", "1097", 24, prestamoUq);

        crearPrestamo("001", "08 Julio 2023", "02 Septiembre 20203",
                "Se realiza documentación del préstamo 001", prestamoUq);
        crearPrestamo("002", "22 Mayo 2023", "30 Julio 20203",
                "Se realiza documentación del préstamo 002", prestamoUq);
        crearPrestamo("003", "18 Enero 2023", "19 Abril 20203",
                "Se realiza documentación del préstamo 003", prestamoUq);
        crearPrestamo("004", "20 Junio 2023", "27 Agosto 20203",
                "Se realiza documentación del préstamo 004", prestamoUq);

        crearEmpleado("juan felipe", "arrubla", "1122", 34, prestamoUq);
        crearEmpleado("ana maría", "ruiz", "1123", 25, prestamoUq);
        crearEmpleado("maria Rosa", "pereira", "1124", 28, prestamoUq);
        crearEmpleado("pedro Nel", "diaz", "1125", 44, prestamoUq);

        crearObjeto("computador", 144, prestamoUq);
        crearObjeto("escritorio", 165, prestamoUq);
        crearObjeto("videobeam", 184, prestamoUq);
        crearObjeto("silla", 122, prestamoUq);

        opcionesMenuPrincipal(prestamoUq);
    }

    /**
     * Método para Inicializar Datos Prueba
     * @return
     */
    private static PrestamoUq inializarDatosPrueba() {
        PrestamoUq prestamoUq = new PrestamoUq();
        prestamoUq.setNombre("Prestamo Rapido");

        return prestamoUq;
    }

    /**
     * Método para Crear un Préstamo
     * @param numeroPrestamo
     * @param fechaPrestamo
     * @param fechaEntrega
     * @param descripcion
     * @param prestamoUq
     */
    private static void crearPrestamo(String numeroPrestamo,
                                     String fechaPrestamo,
                                     String fechaEntrega,
                                     String descripcion,
                                     PrestamoUq prestamoUq) {
        prestamoUq.crearPrestamo(numeroPrestamo, fechaPrestamo, fechaEntrega, descripcion);
    }

    /**
     * Método para Crear un Cliente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @param prestamoUq
     */
    private static void crearCliente(String nombre,
                                     String apellido,
                                     String cedula,
                                     int edad,
                                     PrestamoUq prestamoUq) {
            prestamoUq.crearCliente(nombre, apellido, cedula, edad);

    }

    /**
     * Método para Crear un Empleado
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @param prestamoUq
     */
    private static void crearEmpleado(String nombre,
                                     String apellido,
                                     String cedula,
                                     int edad,
                                     PrestamoUq prestamoUq) {
        prestamoUq.crearEmpleado(nombre, apellido, cedula, edad);

    }

    /**
     * Método para Crear un Objeto
     * @param nombre
     * @param numeroReferencia
     * @param prestamoUq
     */
    private static void crearObjeto(String nombre,
                                      int numeroReferencia,
                                      PrestamoUq prestamoUq) {
        prestamoUq.crearObjeto(nombre, numeroReferencia);

    }

    /**
     * Método para Eliminar un Cliente
     * @param prestamoUq
     * @param cedula
     */
    private static void elilimarCliente(PrestamoUq prestamoUq, String cedula) {

        prestamoUq.eliminarCliente(cedula);
    }

    /**
     * Método para Mostrar Información de un Cliente
     * @param prestamoUq
     */
    private static void mostrarInformacionCliente(PrestamoUq prestamoUq) {
        List<Cliente> listaClientes = prestamoUq.obtenerClientes();
        int tamanioLista = listaClientes.size();
       for(int i=0; i < tamanioLista; i++){
            Cliente cliente = listaClientes.get(i);
            System.out.println(cliente.toString());
           String  uuu = cliente.toString();
        }
    }

    /**
     * Método para Mostrar Información de un Préstamo
     * @param prestamoUq
     */
    private static void mostrarInformacionPrestamo(PrestamoUq prestamoUq) {
        List<Prestamo> listaPrestamos = prestamoUq.obtenerPrestamos();
        int tamanioLista = listaPrestamos.size();
        for(int i=0; i < tamanioLista; i++){
            Prestamo prestamo = listaPrestamos.get(i);
            System.out.println(prestamo.toString());
            String  uuu = prestamo.toString();
        }
    }
}