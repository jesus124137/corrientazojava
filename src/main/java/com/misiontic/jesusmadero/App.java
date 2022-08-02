package com.misiontic.jesusmadero;

import java.util.Scanner;
import com.misiontic.jesusmadero.controlador.RestauranteController;
import com.misiontic.jesusmadero.excepcion.ObjetoNoExistenteException;
import com.misiontic.jesusmadero.excepcion.PagoInsuficienteExcepcion;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        try(var sc = new Scanner(System.in)){
        var controlador = new RestauranteController(sc);

        controlador.iniciarBaseDatos();
        controlador.iniciarAplicacion();

       //prueba2(controlador);
        
       //Pruebaventa();
        } catch (Exception ex) {
            System.err.println("Ocurrio un error y salgo de la aplicacion: \n"+ ex.getMessage());
            //ex.printStackTrace(); sirve para mostrar los errores de la aplicacion en consola
        }

    }

    private static void prueba2(RestauranteController controlador)
            throws ObjetoNoExistenteException, PagoInsuficienteExcepcion {
        var mesa = controlador.consultarMesa("01");
        System.out.println("La mesa consultada es: " + mesa);

        controlador.agregarPedido(mesa);
        System.out.println("El pedido es: " + mesa.calcularTotal());

        var devuelta = controlador.pagarCuenta(mesa);
        System.out.printf("Los comensales de la mesa %s pagaron la cuenta y se devolvio $ %,d, %n",
        mesa, devuelta);
    }
}
