package co.edu.uniquindio.prestamo.util;

import javax.swing.*;

public class CapturaDatosUtil {

    //señor nimbus
    
    /**
     * Este método sirve para imprimir un mensaje con la libreria JOptionPane
     * @param mensaje
     */
    public static void imprimir (String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }

    /**
     * Este método sirve para leer un dato de tipo entero con la libreria JOptionPane
     * @param mensaje
     * @return
     */
    public static int leerEnteroVentana (String mensaje)
    {
        int dato= Integer.parseInt(JOptionPane.showInputDialog(mensaje));

        return dato;
    }

    /**
     * Este método sirve para leer un dato de tipo String con la libreria JOptionPane
     * @param mensaje
     * @return
     */
    public static String  leerStringVentana(String mensaje) {
        String respuesta = "";
        respuesta  = JOptionPane.showInputDialog(mensaje);
        return respuesta;
    }
}