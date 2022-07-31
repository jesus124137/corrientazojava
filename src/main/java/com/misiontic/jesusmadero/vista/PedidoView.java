package com.misiontic.jesusmadero.vista;

import java.util.Scanner;

import com.misiontic.jesusmadero.controlador.RestauranteController;
import com.misiontic.jesusmadero.modelo.Bandeja;
import com.misiontic.jesusmadero.modelo.Carne;
import com.misiontic.jesusmadero.modelo.Completo;
import com.misiontic.jesusmadero.modelo.Ensalada;
import com.misiontic.jesusmadero.modelo.Jugo;
import com.misiontic.jesusmadero.modelo.OpcionPedido;
import com.misiontic.jesusmadero.modelo.Pedido;
import com.misiontic.jesusmadero.modelo.Principio;
import com.misiontic.jesusmadero.modelo.Sopa;

public class PedidoView {
    private Scanner entrada;
    private RestauranteController controller;

    public PedidoView(Scanner entrada, RestauranteController controller) {
        this.entrada = entrada;
        this.controller = controller;
    }

    public Pedido cargarPedido() {
        // pedir el nombre del cliente
        System.out.println("Ingrese el nombre del cliente: ");
        var cliente = entrada.nextLine();

        // elegir entre diferentes opciones
        OpcionPedido opcion = null;
        do {
            System.out.println("Cual es su eleccion de almuerzo? C -> Completo, B -> Bandeja\n(B/C): ");
            var valorOpcion = entrada.nextLine();
            switch (valorOpcion.toUpperCase()) {
                case "C":
                    opcion = new Completo(12_000);
                    ((Completo)opcion).setSopa(elejirOpcionSopa());
                    opcion.setPrincipio(elejirOpcionPrincipio());
                    opcion.setCarne(elejirOpcionCarne());
                    opcion.setEnsalada(elejirOpcionEnsalada());
                    opcion.setJugo(elejirOpcionjJugo());
                    break;
                case "B":
                    opcion = new Bandeja(10_000);
                    opcion.setPrincipio(elejirOpcionPrincipio());
                    opcion.setCarne(elejirOpcionCarne());
                    opcion.setEnsalada(elejirOpcionEnsalada());
                    opcion.setJugo(elejirOpcionjJugo());
                    break;

                default:
                    System.err.println("Ha ingresado un opcion invalida");
                    System.err.println("Vuelva a intentar");
                    break;
            }
        } while (opcion == null);
        return new Pedido(cliente, opcion);
    }

    private Sopa elejirOpcionSopa() {
        Sopa respuesta = null;
        var sopas = controller.listarsopas();
        do {
            System.out.println(".: Opciones de sopas :.");

            for (int i = 0; i < sopas.size(); i++) {
                System.out.printf("%d -> %s %n",
                        i, sopas.get(i));
            }
            System.out.println("Elija su opcion de sopa: ");
            var opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion < sopas.size()) {
                respuesta = sopas.get(opcion);
            } else {
                System.err.println("Ha ingresado un opcion invalida");
                System.err.println("Vuelva a intentar");
            }

        } while (respuesta == null);
        return respuesta;
    }

    private Principio elejirOpcionPrincipio() {
        Principio respuesta = null;
        var principio = controller.listarprincipio();
        do {
            System.out.println(".: Opciones de principio :.");

            for (int i = 0; i < principio.size(); i++) {
                System.out.printf("%d -> %s %n",
                        i, principio.get(i));
            }
            System.out.println("Elija su opcion de principio: ");
            var opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion < principio.size()) {
                respuesta = principio.get(opcion);
            } else {
                System.err.println("Ha ingresado un opcion invalida");
                System.err.println("Vuelva a intentar");
            }

        } while (respuesta == null);
        return respuesta;
    }

    private Carne elejirOpcionCarne() {
        Carne respuesta = null;
        var carne = controller.listarcarne();
        do {
            System.out.println(".: Opciones de carne :.");

            for (int i = 0; i < carne.size(); i++) {
                System.out.printf("%d -> %s %n",
                        i, carne.get(i));
            }
            System.out.println("Elija su opcion de carne: ");
            var opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion < carne.size()) {
                respuesta = carne.get(opcion);
            } else {
                System.err.println("Ha ingresado un opcion invalida");
                System.err.println("Vuelva a intentar");
            }

        } while (respuesta == null);
        return respuesta;
    }

    private Ensalada elejirOpcionEnsalada() {
        Ensalada respuesta = null;
        var ensalada = controller.listarensalada();
        do {
            System.out.println(".: Opciones de ensalada :.");
            System.out.printf("%d -> %s %n", -1,"Sin ensalada");

            for (int i = 0; i < ensalada.size(); i++) {
                System.out.printf("%d -> %s %n",
                        i, ensalada.get(i));
            }
            System.out.println("Elija su opcion de ensalada: ");
            var opcion = entrada.nextInt();
            entrada.nextLine();
            if(opcion == -1){
                break;
            }else if (opcion < ensalada.size()) {
                respuesta = ensalada.get(opcion);
            } else {
                System.err.println("Ha ingresado un opcion invalida");
                System.err.println("Vuelva a intentar");
            }

        } while (respuesta == null);
        return respuesta;
    }

    private Jugo elejirOpcionjJugo() {
        Jugo respuesta = null;
        var jugo = controller.listarjugo();
        do {
            System.out.println(".: Opciones de jugo :.");

            for (int i = 0; i < jugo.size(); i++) {
                System.out.printf("%d -> %s %n",
                        i, jugo.get(i));
            }
            System.out.println("Elija su opcion de jugo: ");
            var opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion < jugo.size()) {
                respuesta = jugo.get(opcion);
            } else {
                System.err.println("Ha ingresado un opcion invalida");
                System.err.println("Vuelva a intentar");
            }

        } while (respuesta == null);
        return respuesta;
    }

}
