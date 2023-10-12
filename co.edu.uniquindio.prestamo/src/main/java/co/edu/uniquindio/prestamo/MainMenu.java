package co.edu.uniquindio.prestamo;

import co.edu.uniquindio.prestamo.model.PrestamoUq;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static co.edu.uniquindio.prestamo.util.CapturaDatosUtil.*;
import static co.edu.uniquindio.prestamo.util.CapturaDatosUtil.leerStringVentana;

public class MainMenu {

    /**
     * Método utilizado para mostrar las opciones del menú principal
     * @return
     */
    public static String mostrarMenuPrincipal() {
        return  "Bienvenido al centro de prestamosUQ, elije alguna de las opciones que tenermos para ti" + "\n" +
                "1 - Clientes" +"\n" +
                "2 - Prestamos" +"\n" +
                "3 - Empleados" +"\n" +
                "4 - Objetos" +"\n" +
                "5 - Salir";
    }

    /**
     * Método utilizado para mostrar las opciones del CRUD menú clientes
     * @return
     */
    public static String mostrarMenuClientes() {
        return "haz elegido la opción 1. Clientes, indica que quieres realizar" + "\n" +
                "1 - Crear Cliente" +"\n" +
                "2 - Obtener Clientes" +"\n" +
                "3 - Actualizar información de Cliente" +"\n" +
                "4 - Eliminar Cliente" +"\n" +
                "5 - Salir";
    }

    /**
     * Método utilizado para mostrar las opciones del CRUD menú préstamos
     * @return
     */
    public static String mostrarMenuPrestamo() {
        return "has elegido la opción 2. Prestamos, indica que quieres realizar" + "\n" +
                "1 - Crear Préstamo" +"\n" +
                "2 - Obtener Préstamos" +"\n" +
                "3 - Actualizar información del Préstamo" +"\n" +
                "4 - Eliminar Préstamo" +"\n" +
                "5 - Volver ";
    }

    /**
     * Método utilizado para mostrar las opciones del CRUD menú empleados
     * @return
     */
    public static String mostrarMenuEmpleados() {
        return "has elegido la opción 3. Empleados, indica lo que quieres realizar" + "\n" +
                "1 - Crear Empleado" +"\n" +
                "2 - Obtener Empleados" +"\n" +
                "3 - Actualizar información de Empleado" +"\n" +
                "4 - Eliminar Empleado" +"\n" +
                "5 - Salir";
    }

    /**
     * Método utilizado para mostrar las opciones del CRUD menú objetos
     * @return
     */
    public static String mostrarMenuObjetos() {
        return "haz elegido la opción 4. Objetos, indica que quieres realizar" + "\n" +
                "1 - Crear Objeto" +"\n" +
                "2 - Obtener Objetos" +"\n" +
                "3 - Actualizar información del Objeto" +"\n" +
                "4 - Eliminar Objeto" +"\n" +
                "5 - Salir";
    }

    /**
     * Método utilizado para elegir las diferentes opciones que tiene el usuario dentro del sistema
     * @param prestamoUq
     */
    public static void opcionesMenuPrincipal(PrestamoUq prestamoUq) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {
            //mostrarMenu();

            opcion = leerEnteroVentana(mostrarMenuPrincipal());

            try {

                System.out.println("Escribe una de las opciones");
                //opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1 - clientes");
                        menuClientes(prestamoUq);
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2- prestamos");

                        menuPrestamos(prestamoUq);
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3 - Empleados");
                        menuEmpleados(prestamoUq);
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4 - Objetos");
                        menuObjetos(prestamoUq);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    /**
     * Método utilizado para elegir las diferentes opciones del CRUD de clientes
     * @param prestamoUq
     */
    public static void menuClientes(PrestamoUq prestamoUq) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        while (!salir) {
            //mostrarMenu();

            opcion = leerEnteroVentana(mostrarMenuClientes());
            try {

                System.out.println("Escribe una de las opciones");
                //opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        imprimir("Has seleccionado la opcion 1 - Crear cliente"+ "\n" +
                                "Por favor diligencia los siguientes datos"
                        );
                        System.out.println("Has seleccionado la opcion 1 - Crear cliente");

                        String respuestaNombre = leerStringVentana("Ingresa tu nombre");
                        String respuestaApellido = leerStringVentana("Ingresa tu apellido");
                        int respuestaEdad =  leerEnteroVentana ("ingresa tu edad");
                        String respuestaCedula = leerStringVentana("Ingresa tu cedula");

                        prestamoUq.crearCliente(respuestaNombre, respuestaApellido, respuestaCedula,respuestaEdad);
                        break;
                    case 2:
                        String mensaje = "";
                        for (int i = 0; i < prestamoUq.obtenerClientes().size(); i++) {
                            String idCliente = Integer.toString(i+1);
                            mensaje += idCliente +". "+ prestamoUq.obtenerClientes().get(i) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, mensaje);
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        String mensaje2 = "";
                        for (int i = 0; i < prestamoUq.obtenerClientes().size(); i++) {
                            String idCliente = Integer.toString(i+1);
                            mensaje2 += idCliente +". "+ prestamoUq.obtenerClientes().get(i) + "\n";
                        }
                        System.out.println("Has seleccionado la opcion 3");

                        //Actualizar

                        String cedulaActualizar = leerStringVentana("Elige el numero de cédula del cliente que desea actualizar" + "\n"
                                +"\n"+ mensaje2

                        );

                        String actualizarNombre = leerStringVentana("escriba el nuevo nombre");
                        String actualizarApellido = leerStringVentana("escriba el nuevo apellido");

                        int actualizarEdad = leerEnteroVentana("Elige la nueva edad");
                        String actualizarCedula = leerStringVentana("escriba la nueva cedula");


                        prestamoUq.actualizarCliente
                                (cedulaActualizar, prestamoUq.obtenerClientes(),actualizarNombre,actualizarApellido,actualizarCedula,actualizarEdad);
                        break;
                    case 4:
                        String mensaje3 = "";
                        for (int i = 0; i < prestamoUq.obtenerClientes().size(); i++) {
                            String idCliente = Integer.toString(i+1);
                            mensaje3 += idCliente +". "+ prestamoUq.obtenerClientes().get(i) + "\n";
                        }
                        System.out.println("Has seleccionado la opcion 4");
                        String numeroCedulaClienteEliminar = leerStringVentana("Para eliminar el cliente, por favor indica el numero de cedula" + "\n" + mensaje3);
                        prestamoUq.eliminarCliente(numeroCedulaClienteEliminar);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    /**
     * Método utilizado para elegir las diferentes opciones del CRUD de préstamos
     * @param prestamoUq
     */
    public static void menuPrestamos(PrestamoUq prestamoUq){


        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion2; //Guardaremos la opcion del usuario

        while (!salir) {

            opcion2 = leerEnteroVentana(mostrarMenuPrestamo());

            try {

                System.out.println("Escribe una de las opciones");
                // opcion2 = sn.nextInt();

                switch (opcion2) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1, crear préstamo");
                        String respuestaFechaPrestamo = leerStringVentana("Ingresa la fecha del préstamo");
                        String respuestaFechaEntrega = leerStringVentana("Ingresa la fecha de entrega del préstamo");
                        String respuestaDescripcion = leerStringVentana ("Ingresa la descripción del préstamo");
                        String respuestaNumeroPrestamo = leerStringVentana("Ingresa el número del préstamo");
                        prestamoUq.crearPrestamo(respuestaNumeroPrestamo, respuestaFechaPrestamo, respuestaFechaEntrega,
                                respuestaDescripcion);
                        break;
                    case 2:
                        String mensaje = "";
                        for (int i = 0; i < prestamoUq.obtenerPrestamos().size(); i++) {
                            String numeroPrestamo = Integer.toString(i+1);
                            mensaje += numeroPrestamo +". "+ prestamoUq.obtenerPrestamos().get(i) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, mensaje);

                        System.out.println("Has seleccionado la opcion 2, obtener préstamo");
                        prestamoUq.obtenerPrestamos();
                        break;
                    case 3:
                        String mensaje2 = "";
                        for (int i = 0; i < prestamoUq.obtenerPrestamos().size(); i++) {
                            String idCliente = Integer.toString(i+1);
                            mensaje2 += idCliente +". "+ prestamoUq.obtenerPrestamos().get(i) + "\n";
                        }
                        System.out.println("Has seleccionado la opcion 3 - Empleados");



                        //Actualizar

                        String numeroPrestamoActualizar = leerStringVentana("Elige el numero del préstamo que desea actualizar" + "\n"
                                +"\n"+ mensaje2

                        );

                        //indice = indice-1;
                        String actualizarFechaPrestamo = leerStringVentana("escriba la nueva fecha de préstamo");
                        String actualizarFechaEntrega = leerStringVentana("escriba la nueva fecha de entrega");
                        String actualizarDescripcion = leerStringVentana("Elige la nueva descripción");
                        String actualizarNumeroPrestamo = leerStringVentana("escriba el nuevo número de préstamo");


                        prestamoUq.actualizarPrestamo(numeroPrestamoActualizar, prestamoUq.obtenerPrestamos(),actualizarNumeroPrestamo,
                                actualizarFechaPrestamo,actualizarFechaEntrega,actualizarDescripcion);
                        break;
                    case 4:
                        String mensaje3 = "";
                        for (int i = 0; i < prestamoUq.obtenerPrestamos().size(); i++) {
                            String idPrestamo = Integer.toString(i+1);
                            mensaje3 += idPrestamo +". "+ prestamoUq.obtenerPrestamos().get(i) + "\n";
                        }
                        System.out.println("Has seleccionado la opcion 4 - Objeto");
                        String numeroPrestamoEliminar = leerStringVentana("Para eliminar, por favor indica el número del préstamo" + "\n" + mensaje3);
                        prestamoUq.eliminarPrestamo(numeroPrestamoEliminar);
                        break;

                    case 5:
                        salir = true;
                        break;

                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    /**
     * Método utilizado para elegir las diferentes opciones del CRUD de empleados
     * @param prestamoUq
     */
    public static void menuEmpleados(PrestamoUq prestamoUq) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        while (!salir) {

            opcion = leerEnteroVentana(mostrarMenuEmpleados());
            try {

                System.out.println("Escribe una de las opciones");

                switch (opcion) {
                    case 1:
                        imprimir("Has seleccionado la opcion 1 - Crear empleado"+ "\n" +
                                "Por favor diligencia los siguientes datos"
                        );
                        System.out.println("Has seleccionado la opcion 1 - Crear empleado");

                        String respuestaNombre = leerStringVentana("Ingresa tu nombre");
                        String respuestaApellido = leerStringVentana("Ingresa tu apellido");
                        int respuestaEdad = leerEnteroVentana ("ingresa tu edad");
                        String respuestaCedula = leerStringVentana("Ingresa tu cedula");

                        prestamoUq.crearEmpleado(respuestaNombre, respuestaApellido, respuestaCedula,respuestaEdad);
                        break;
                    case 2:
                        String mensaje = "";
                        for (int i = 0; i < prestamoUq.obtenerEmpleados().size(); i++) {
                            String idEmpleado = Integer.toString(i+1);
                            mensaje += idEmpleado +". "+ prestamoUq.obtenerEmpleados().get(i) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, mensaje);
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        String mensaje2 = "";
                        for (int i = 0; i < prestamoUq.obtenerEmpleados().size(); i++) {
                            String idEmpleado = Integer.toString(i+1);
                            mensaje2 += idEmpleado +". "+ prestamoUq.obtenerEmpleados().get(i) + "\n";
                        }
                        System.out.println("Has seleccionado la opcion 3 ");

                        //Actualizar

                        String cedulaActualizar = leerStringVentana("Elige el numero de cédula del empleado" +
                                " que desea actualizar" + "\n"
                                +"\n"+ mensaje2

                        );

                        String actualizarNombre = leerStringVentana("escriba el nuevo nombre");
                        String actualizarApellido = leerStringVentana("escriba el nuevo apellido");

                        int actualizarEdad = leerEnteroVentana("Elige la nueva edad");
                        String actualizarCedula = leerStringVentana("escriba la nueva cedula");

                        prestamoUq.actualizarEmpleado(cedulaActualizar, prestamoUq.obtenerEmpleados(),actualizarNombre,
                                actualizarApellido,actualizarCedula,actualizarEdad);
                        break;
                    case 4:
                        String mensaje3 = "";
                        for (int i = 0; i < prestamoUq.obtenerEmpleados().size(); i++) {
                            String idEmpleado = Integer.toString(i+1);
                            mensaje3 += idEmpleado +". "+ prestamoUq.obtenerEmpleados().get(i) + "\n";
                        }
                        System.out.println("Has seleccionado la opcion 4");
                        String numeroCedulaEmpleadoEliminar = leerStringVentana("Para eliminar el cliente," +
                                "por favor indica el numero de cedula" + "\n" + mensaje3);
                        prestamoUq.eliminarEmpleado(numeroCedulaEmpleadoEliminar);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    /**
     * Método utilizado para elegir las diferentes opciones del CRUD de objetos
     * @param prestamoUq
     */
    public static void menuObjetos(PrestamoUq prestamoUq) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        while (!salir) {
            //mostrarMenu();

            opcion = leerEnteroVentana(mostrarMenuObjetos());
            try {

                System.out.println("Escribe una de las opciones");
                //opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        imprimir("Has seleccionado la opcion 1 - Crear Objeto"+ "\n" +
                                "Por favor diligencia los siguientes datos"
                        );

                        String respuestaNombre = leerStringVentana("Ingresa el nombre del objeto");
                        int respuestaNumeroReferencia = leerEnteroVentana("Ingresa el numero de refrencia  ");

                        prestamoUq.crearObjeto(respuestaNombre, respuestaNumeroReferencia);
                        break;
                    case 2:
                        String mensaje = "";
                        for (int i = 0; i < prestamoUq.obtenerObjetos().size(); i++) {
                            String idObjeto = Integer.toString(i+1);
                            mensaje += idObjeto +". "+ prestamoUq.obtenerObjetos().get(i) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, mensaje);
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        String mensaje2 = "";
                        for (int i = 0; i < prestamoUq.obtenerObjetos().size(); i++) {
                            String idObjeto = Integer.toString(i+1);
                            mensaje2 += idObjeto +". "+ prestamoUq.obtenerObjetos().get(i) + "\n";
                        }

                        //Actualizar

                        int numeroReferenciaActualizar = leerEnteroVentana("Elige el numero de referencia del objeto que desea actualizar" + "\n"
                                +"\n"+ mensaje2

                        );

                        String actualizarNombre = leerStringVentana("escriba el nuevo nombre");
                        int nuevoNumeroReferencia = leerEnteroVentana("escriba el nuevo numero de referencia");

                        prestamoUq.actualizarObjeto
                                (numeroReferenciaActualizar, prestamoUq.obtenerObjetos(),actualizarNombre,nuevoNumeroReferencia);
                        break;
                    case 4:
                        String mensaje3 = "";
                        for (int i = 0; i < prestamoUq.obtenerObjetos().size(); i++) {
                            String idObjeto = Integer.toString(i+1);
                            mensaje3 += idObjeto +". "+ prestamoUq.obtenerObjetos().get(i) + "\n";
                        }
                        int numeroReferenciaEliminar = leerEnteroVentana("Para eliminar el objeto, por favor indica el numero de referencia" + "\n" + mensaje3);
                        prestamoUq.eliminarObjeto(numeroReferenciaEliminar);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}