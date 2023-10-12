package co.edu.uniquindio.prestamo.model;

import java.util.ArrayList;
import java.util.List;

import static co.edu.uniquindio.prestamo.util.CapturaDatosUtil.imprimir;

public class PrestamoUq {

    /**
     * Atributos clase Préstamos UQ
     */
    private String nombre;

    List<Cliente> listaClientes = new ArrayList<>();
    List<Prestamo> listaPrestamos = new ArrayList<>();
    List<Empleado> listaEmpleados = new ArrayList<>();
    List<Objeto> listaObjetos = new ArrayList<>();

    /**
     * Constructor vacío
     */
    public PrestamoUq() {
    }

    /**
     * Getters y Setters
     * @return
     */
    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public PrestamoUq(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     * Método para Crear un cliente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return boolean
     */
    public boolean crearCliente(String nombre, String apellido, String cedula, int edad) {
        Cliente cliente = new Cliente();

        //boolean validarCedula = validarCedula(cedula, cliente);
        boolean cedulaExistente = false;
        for (Cliente cliente2 : listaClientes) {
            if (cliente2.getCedula().equals(cedula)) {
                cedulaExistente = true;
                break;
            }
        }
        if (cedulaExistente) {
            imprimir("El número de cédula ya existe, ingresa de nuevo los datos");

        } else {
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setCedula(cedula);
            cliente.setEdad(edad);
            getListaClientes().add(cliente);
        }
        return true;
    }

    /**
     * Método para crear un Objeto
     * @param nombre
     * @param numeroReferencia
     * @return
     */
    public boolean crearObjeto(String nombre, int numeroReferencia) {
        Objeto objeto = new Objeto();
        
        boolean validarNumeroReferencia = false;
        for (Objeto objeto2 : listaObjetos) {
            if (objeto2.getNumReferencia() == (numeroReferencia)) {
                validarNumeroReferencia = true;
                break;
            }
        }
        if (validarNumeroReferencia) {
            imprimir("El número de referencia ya existe, ingresa de nuevo los datos");

        } else {
            objeto.setNombre(nombre);
            objeto.setNumReferencia(numeroReferencia);
            getListaObjetos().add(objeto);
        }
        return true;
    }

    /**
     * Método para Actualizar un Objeto
     * @param numeroReferenciaActualizar
     * @param lista
     * @param actualizarNombre
     * @param nuevoNumeroReferencia
     */
    public  void actualizarObjeto(int numeroReferenciaActualizar, List<Objeto> lista, String actualizarNombre,int nuevoNumeroReferencia){


        int indice = obtenerPosicionPorNumeroReferencia(lista,numeroReferenciaActualizar);
        boolean numeroReferenciaExistente = false;
        for (Objeto objeto: lista){
            if(objeto.getNumReferencia() == nuevoNumeroReferencia){
                numeroReferenciaExistente = true;
                break;
            }
        }
        if(numeroReferenciaExistente){
            imprimir("El número de referencia ya existe, ingresa de nuevo los datos");

        }else{
            listaObjetos.get(indice).setNombre(actualizarNombre);
            listaObjetos.get(indice).setNumReferencia(nuevoNumeroReferencia);
        }
    }

    /**
     * Método para Obtener la posición de la lista cuando sabemos el número de referencia del Objeto
     * @param lista
     * @param numeroReferenciaActualizar
     * @return
     */
    public static int obtenerPosicionPorNumeroReferencia(List<Objeto> lista, int numeroReferenciaActualizar) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumReferencia() == numeroReferenciaActualizar) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Método para Eliminar un Objeto
     * @param numeroReferencia
     */
    public void eliminarObjeto(int numeroReferencia) {
        int tamanioLista = getListaObjetos().size();
        for (int i=0; i < tamanioLista; i++){
            Objeto objeto = getListaObjetos().get(i);
            if(objeto.getNumReferencia() == numeroReferencia){
                getListaObjetos().remove(i);
                break;
            }
        }
    }

    /**
     * Método para Crear un Préstamo
     * @param numeroPrestamo
     * @param fechaPrestamo
     * @param fechaEntrega
     * @param descripcion
     * @return
     */
    public boolean crearPrestamo(String numeroPrestamo, String fechaPrestamo, String fechaEntrega,
                                 String descripcion){
        Prestamo prestamo = new Prestamo();
        boolean validarNumPrestamo = false;

        for (Prestamo prestamo2  : listaPrestamos) {
            if (prestamo2.getNumeroPrestamo().equals(numeroPrestamo)) {
                validarNumPrestamo = true;
                break;
            }
        }

        if (validarNumPrestamo){

            imprimir("El número de préstamo ya existe, ingresa de nuevo los datos");
        }else {
            prestamo.setNumeroPrestamo(numeroPrestamo);
            prestamo.setFechaPrestamo(fechaPrestamo);
            prestamo.setFechaEntrega(fechaEntrega);
            prestamo.setDescripcion(descripcion);
            getListaPrestamos().add(prestamo);
        }
        return true;
    }

    /**
     * Método para Crear un Empleado
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return
     */
    public boolean crearEmpleado(String nombre, String apellido, String cedula, int edad){
        Empleado empleado = new Empleado();
        boolean validarCedula = false;
        for (Empleado empleado2  : listaEmpleados) {
            if (empleado2.getCedula().equals(cedula)) {
                validarCedula = true;
                break;
            }
        }
        if(validarCedula) {
            imprimir("El número de cédula ya existe, ingresa de nuevo los datos");
        }else{
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setCedula(cedula);
            empleado.setEdad(edad);
            getListaEmpleados().add(empleado);
        }
        return true;
    }

    /**
     * Metodo para obtener la lista de todos los clientes
     * @return List<Cliente>
     */
    public List<Cliente> obtenerClientes() {
        return getListaClientes();
    }
    public List<Prestamo> obtenerPrestamos() {
        return getListaPrestamos();
    }
    public List<Empleado> obtenerEmpleados() {
        return getListaEmpleados();
    }
    public List<Objeto> obtenerObjetos() {
        return getListaObjetos();
    }

    /**
     * Método para Eliminar un Cliente
     * @param cedula
     */
    public void eliminarCliente(String cedula) {
        int tamanioLista = getListaClientes().size();
        for (int i=0; i < tamanioLista; i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                getListaClientes().remove(i);
                break;
            }
        }
    }

    /**
     * Método para Actualizar un Cliente
     * @param cedulaActualizar
     * @param lista
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     */
    public  void actualizarCliente(String cedulaActualizar , List<Cliente> lista, String nombre, String apellido, String cedula, int edad){

        int indice = obtenerPosicionPorCedula(lista,cedulaActualizar);
       boolean cedulaExistente = false;
       for (Cliente cliente: lista){
           if(cliente.getCedula().equals(cedula)){
               cedulaExistente = true;
               break;
           }
       }
       if(cedulaExistente){
           imprimir("El número de cédula ya existe, ingresa de nuevo los datos");

       }else{
           listaClientes.get(indice).setNombre(nombre);
           listaClientes.get(indice).setApellido(apellido);
           listaClientes.get(indice).setCedula(cedula);
           listaClientes.get(indice).setEdad(edad);
       }
    }

    /**
     * Método para Obtener la posicion por Cédula
     * @param lista
     * @param cedula
     * @return
     */
    public static int obtenerPosicionPorCedula( List<Cliente> lista, String cedula) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equals(cedula)) {
                return i;  // Se encontró el nombre en la posición i
            }
        }
        return -1;  // No se encontró el nombre en la lista
    }

    /**
     * Método para Eliminar un Préstamo
     * @param numeroPrestamo
     */
    public void eliminarPrestamo(String numeroPrestamo) {
        int tamanioLista = getListaPrestamos().size();
        for (int i=0; i < tamanioLista; i++){
            Prestamo prestamo = getListaPrestamos().get(i);
            if(prestamo.getNumeroPrestamo().equalsIgnoreCase(numeroPrestamo)){
                getListaPrestamos().remove(i);
                break;
            }
        }
    }

    /**
     * Método para Actualizar un Préstamo
     * @param numeroPrestamoActualizar
     * @param lista
     * @param numeroPrestamo
     * @param fechaPrestamo
     * @param fechaEntrega
     * @param descripcion
     */
    public  void actualizarPrestamo(String numeroPrestamoActualizar, List<Prestamo> lista, String numeroPrestamo,
                                    String fechaPrestamo, String fechaEntrega, String descripcion){
        int indice = obtenerPosicionPorNumeroPrestamo(numeroPrestamoActualizar,lista);
        boolean numeroPrestamoExistente = false;
        for (Prestamo prestamo:lista){
            if (prestamo.getNumeroPrestamo().equals(numeroPrestamo)){
                numeroPrestamoExistente = true;
                break;
            }
        }
        if(numeroPrestamoExistente) {
            imprimir("El número de préstamo ya existe, ingresa de nuevo los datos");
        }else{
                    listaPrestamos.get(indice).setNumeroPrestamo(numeroPrestamo);
                    listaPrestamos.get(indice).setFechaPrestamo(fechaPrestamo);
                    listaPrestamos.get(indice).setFechaEntrega(fechaEntrega);
                    listaPrestamos.get(indice).setDescripcion(descripcion);
        }
    }

    /**
     * Método para Obtener la posición de la lista cuando sabemos el número de referencia del Préstamo
     * @param numeroPrestamo
     * @param lista
     * @return
     */
    public static int obtenerPosicionPorNumeroPrestamo(String numeroPrestamo, List<Prestamo> lista) {

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumeroPrestamo().equals(numeroPrestamo)) {
                return i;
            }
        }
        return - 1 ;
    }

    /**
     * Método para Eliminar Empleado
     * @param cedula
     */
    public void eliminarEmpleado(String cedula) {
        int tamanioLista = getListaEmpleados().size();
        for (int i=0; i < tamanioLista; i++){
            Empleado empleado = getListaEmpleados().get(i);
            if(empleado.getCedula().equalsIgnoreCase(cedula)){
                getListaEmpleados().remove(i);
                break;
            }
        }
    }

    /**
     * Método para Actualizar un Empleado
     * @param cedulaActualizar
     * @param lista
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     */
    public  void actualizarEmpleado(String cedulaActualizar , List<Empleado> lista, String nombre, String apellido,
                                    String cedula, int edad){
        int indice = obtenerPosicionPorCedulaEmpleado(lista,cedulaActualizar);
        boolean cedulaExistenteEmpleado = false;
        for(Empleado empleado: lista){
            if (empleado.getCedula().equals(cedula)){
                cedulaExistenteEmpleado = true;
                break;
            }
        }
        if( cedulaExistenteEmpleado) {
            imprimir("El número de cédula ya existe, ingresa de nuevo los datos");
        } else {
                    listaEmpleados.get(indice).setNombre(nombre);
                    listaEmpleados.get(indice).setApellido(apellido);
                    listaEmpleados.get(indice).setCedula(cedula);
                    listaEmpleados.get(indice).setEdad(edad);
        }
    }

    /**
     * Método para Obtener la posición de la lista cuando sabemos la cédula de un empleado
     * @param lista
     * @param cedula
     * @return
     */
    private int obtenerPosicionPorCedulaEmpleado(List<Empleado>lista, String cedula) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equals(cedula)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "PrestamoUq{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}