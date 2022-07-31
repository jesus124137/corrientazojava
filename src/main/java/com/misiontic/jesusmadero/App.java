package com.misiontic.jesusmadero;

import java.util.Scanner;
import com.misiontic.jesusmadero.controlador.RestauranteController;
import com.misiontic.jesusmadero.excepcion.PagoInsuficienteExcepcion;
import com.misiontic.jesusmadero.modelo.Bandeja;
import com.misiontic.jesusmadero.modelo.Carne;
import com.misiontic.jesusmadero.modelo.Completo;
import com.misiontic.jesusmadero.modelo.Ensalada;
import com.misiontic.jesusmadero.modelo.Jugo;
import com.misiontic.jesusmadero.modelo.Mesa;
import com.misiontic.jesusmadero.modelo.Pedido;
import com.misiontic.jesusmadero.modelo.Principio;
import com.misiontic.jesusmadero.modelo.Sopa;

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

        var mesa = controlador.consultarMesa("01");
        System.out.println("La mesa consultada es: " + mesa);

        controlador.agregarPedido(mesa);
        System.out.println("El pedido es: " + mesa.calcularTotal());
        
       //Pruebaventa();
        } catch (Exception ex) {
            System.err.println("Ocurrio un error y salgo de la aplicacion: \n"+ ex.getMessage());
            //ex.printStackTrace(); sirve para mostrar los errores de la aplicacion en consola
        }

    }

       private static void Pruebaventa() {
        var mesa = new Mesa("01");

        var sopa = new Sopa("verduras");
        var principio = new Principio("frijoles");
        var carne = new Carne("Resa a la plancha");
        var ensalada = new Ensalada("Tomate");
        var jugo = new Jugo("Mora");

        var precio = 12_000;
        var opcion1 = new Completo(precio, sopa, principio, carne, ensalada, jugo);
        var pedido = new Pedido("Jesus Madero", opcion1);
        //pedido.agregarAdicional(new Adicional("postre", 3_000));        
        mesa.agregarPedido(pedido);
        
        precio = 10_000;
        var opcion2 = new Bandeja(precio, principio, carne, ensalada, jugo);
        pedido = new Pedido("Rocio Mora", opcion2);
        mesa.agregarPedido(pedido);

        System.out.printf("Total de la mesa: $ %,d. %n", mesa.calcularTotal());
       
        var efectivo = 23_000;
        try{        
        var devuelta = mesa.pago(efectivo);
        System.out.printf("Paga la cuenta con $ %,d y recibe una devuelta de $ %,d %n",
        efectivo, devuelta);
        }catch(PagoInsuficienteExcepcion ex){
            System.err.printf("Creo que va a tener que lavar algunos platos!! %n Pago solso %,d. %n", efectivo);
        }

        System.out.printf("Ahora el total de la mesa: $ %,d. %n", mesa.calcularTotal());
    }
}
