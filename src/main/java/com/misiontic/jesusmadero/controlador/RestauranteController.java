package com.misiontic.jesusmadero.controlador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.misiontic.jesusmadero.excepcion.ObjetoNoExistenteException;
import com.misiontic.jesusmadero.excepcion.PagoInsuficienteExcepcion;
import com.misiontic.jesusmadero.modelo.Carne;
import com.misiontic.jesusmadero.modelo.Ensalada;
import com.misiontic.jesusmadero.modelo.Jugo;
import com.misiontic.jesusmadero.modelo.Mesa;
import com.misiontic.jesusmadero.modelo.Pedido;
import com.misiontic.jesusmadero.modelo.Principio;
import com.misiontic.jesusmadero.modelo.Sopa;
import com.misiontic.jesusmadero.vista.MesaView;
import com.misiontic.jesusmadero.vista.PedidoView;
import com.misiontic.jesusmadero.vista.principalView;

public class RestauranteController {  
    private MesaView mesaView;
    private PedidoView pedidoView;
    private principalView principalView;

    private List<Mesa> mesas;
    private List<Sopa> sopas;
    private List<Principio> principios;
    private List<Carne> carnes;
    private List<Ensalada> ensaladas;
    private List<Jugo> jugos;

    public RestauranteController(Scanner entrada){
        mesaView = new MesaView(entrada);
        pedidoView = new PedidoView(entrada, this);
        principalView = new principalView(entrada, this);

         mesas = new ArrayList<>();
         sopas = new ArrayList<>();
         principios = new ArrayList<>();
         carnes = new ArrayList<>();
         ensaladas = new ArrayList<>();
         jugos = new ArrayList<>();
    }

    //TODO: es unmetodo temporal
    public void iniciarBaseDatos(){
        mesas.add(new Mesa("01"));
        mesas.add(new Mesa("02"));
        mesas.add(new Mesa("03"));
        mesas.add(new Mesa("04"));
        mesas.add(new Mesa("05"));
        mesas.add(new Mesa("06"));
        mesas.add(new Mesa("07"));

        sopas.add(new Sopa("Pastas"));
        sopas.add(new Sopa("Peto dulce"));
        sopas.add(new Sopa("Verduras"));
        sopas.add(new Sopa("Pescado"));

        principios.add(new Principio("Frijol"));
        principios.add(new Principio("Lentejas"));
        principios.add(new Principio("Garbanzo"));
        principios.add(new Principio("Verduras"));

        carnes.add(new Carne("Res"));
        carnes.add(new Carne("Cerdo"));
        carnes.add(new Carne("Pollo"));
        carnes.add(new Carne("Pescado"));

        ensaladas.add(new Ensalada("Tropical"));
        ensaladas.add(new Ensalada("Tomate y cebolla"));
        ensaladas.add(new Ensalada("Remolacha"));
        ensaladas.add(new Ensalada("Guacamole"));

        jugos.add(new Jugo("Mango"));
        jugos.add(new Jugo("Mora"));
        jugos.add(new Jugo("Piña"));
        jugos.add(new Jugo("Limonada"));
    }

    public void iniciarAplicacion(){
        principalView.iniciarAplicacion();
    }
        
    public void crearMesa() { 
        // TODO Crear mesa
        // Pedir al usuario el número de la mesa a crear
        var numeroMesa = mesaView.leerNumeroMesa();

        // Crear una nueva mesa en el sistema
        var mesa = new Mesa(numeroMesa);

        //Agregar a la lista de mesas en  el sistema
        mesas.add(mesa);

        mesaView.mostrarMesas(mesas);
    }

    public Mesa consultarMesa(String numero) throws ObjetoNoExistenteException {
        return mesas.stream()
        .filter(mesa -> mesa.getNumero().equals(numero))
        .findFirst()
        .orElseThrow(() -> new ObjetoNoExistenteException("No existe una mesa con el numero "+ numero));
    }

    
    public Pedido agregarPedido(Mesa mesa) {
        var pedido = pedidoView.cargarPedido();
        System.out.println("Pedido: "+pedido);
        mesa.agregarPedido(pedido);
        return null;
    }

    public List<Sopa> listarsopas() {
        return sopas;
    }

    public List<Principio> listarprincipio() {
        return principios;
    }

    public List<Carne> listarcarne() {
        return carnes;
    }

    public List<Ensalada> listarensalada() {
        return ensaladas;
    }

    public List<Jugo> listarjugo() {
        return jugos;
    }

    public Integer pagarCuenta(Mesa mesa) throws PagoInsuficienteExcepcion {
        //solicitar el valor del efectivo
        var efectivo = mesaView.leerValorEfectivo();
        var total = mesa.calcularTotal();
        if(efectivo < total){
            throw new PagoInsuficienteExcepcion("El efectivo no es suficiente para págar el total de la cuenta");
        }
        //Elimina los pedidos cancelados
        mesa.limpiarPedidos();
        return efectivo - total;
    }

    public Object seleccionarMesa() {
        System.out.println("Listado de mesas existentes");
        for (int i = 0; i < mesas.size(); i++) {
            System.out.printf("%d -> %n", (i + 1), mesas.get(1));
            
        }
        return null;
    }

}
