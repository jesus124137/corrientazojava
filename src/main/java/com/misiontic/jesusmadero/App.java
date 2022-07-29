package com.misiontic.jesusmadero;

import com.misiontic.jesusmadero.modelo.Adicional;
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
        var mesa = new Mesa("01");

        var sopa = new Sopa("verduras");
        var principio = new Principio("frijoles");
        var carne = new Carne("Resa a la plancha");
        var ensalada = new Ensalada("Tomate");
        var jugo = new Jugo("Mora");

        var precio = 12_000;
        var opcion1 = new Completo(precio, sopa, principio, carne, ensalada, jugo);
        var pedido = new Pedido("Jesus Madero", opcion1);
        pedido.agregarAdicional(new Adicional("postre", 2_500));        
        mesa.agregarPedido(pedido);
        
        precio = 10_000;
        var opcion2 = new Bandeja(precio, principio, carne, ensalada, jugo);
        pedido = new Pedido("Rocio Mora", opcion2);
        mesa.agregarPedido(pedido);

        System.out.printf("Total de la mesa: $ %,d. %n", mesa.calcularTotal());
    }
}
