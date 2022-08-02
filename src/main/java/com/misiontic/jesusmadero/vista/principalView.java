package com.misiontic.jesusmadero.vista;

import java.util.Scanner;

import com.misiontic.jesusmadero.controlador.RestauranteController;

public class principalView {

    private Scanner entrada;
    private RestauranteController controller;

    public principalView(Scanner entrada, RestauranteController controller) {
        this.entrada = entrada;
        this.controller = controller;
    }

    public void iniciarAplicacion() {
        var mostrarMenu = true;
        while (mostrarMenu) {
            System.out.println(".: Restaurante el corrientazo :.");
            System.out.println("1 -> Gestion de pedido");
            System.out.println("2 -> Gestion de datos maestros");
            System.out.println("0 -> Salir de la aplicacion");
            var opcion = leerEntero("Ingrese su opcion:");
            switch (opcion) {
                case 0:
                    mostrarMenu = false;
                    System.out.println("Hasta la proxima");
                    break;
                case 1:
                    gestionPedidos();
                    break;
                case 2:
                    gestionDatosMaestros();
                    break;

                default:
                    System.out.println("Opcion invalida. Por favor intente nuevamente");
                    break;
            }
        }
    }

    private void gestionDatosMaestros() {
        System.out.println(".: Gestion de datos maestros :.");
    }

    private void gestionPedidos() {
        var mesa = controller.seleccionarMesa();
        System.out.println(".: Gestion de pedido :.");
        System.out.println("1 -> Agregar pedido a la mesa");
        System.out.println("2 -> Agregar adicional a la mesa");
        System.out.println("3 -> Pagar deuda de la mesa");
        System.out.println("4 -> Consultar estado de la mesa");
        System.out.println("0 -> Volver al menu principal");
        var opcion = leerEntero("Ingrese su opcion:");
        switch (opcion) {
            case 0:
                esperarEnter();
                break;
            case 1:
                gestionPedidos();
                break;
            case 2:
                gestionDatosMaestros();
                break;

            default:
                System.out.println("Opcion invalida. Por favor intente nuevamente");
                break;
        }
        

    }

    private void esperarEnter() {
        System.out.println("Presione ENTER para continuar.");
        entrada.nextLine();
    }

    private Integer leerEntero(String mensaje) {
        return leerEntero(mensaje, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Integer leerEntero(String mensaje, Integer minValue, Integer maxValue) {
        Integer opcion = null;
        do {
            try {
                System.out.print(mensaje);
                opcion = entrada.nextInt();
                if (opcion > maxValue) {
                    System.err.println("Opcion invalida\n intente de nuevo");
                    opcion = null;
                }
            } catch (Exception e) {
                System.err.println("Opcion invalida\n intente de nuevo");
            } finally {
                entrada.nextLine();
            }
        } while (opcion == null);
        return opcion;
    }

}
