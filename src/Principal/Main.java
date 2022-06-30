/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;

import Logica.Prestamo;

/**
 *
 * @author invitado
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prestamo prestamo = new Prestamo(5000000, 12);
        prestamo.realizarTabla();
        prestamo.imprimirTabla();
    }
    
}
