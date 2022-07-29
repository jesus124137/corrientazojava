package com.misiontic.jesusmadero.modelo;

import java.util.ArrayList;
import java.util.List;
import com.misiontic.jesusmadero.excepcion.PagoInsuficienteExcepcion;

public class Mesa {
    private String numero;
    private List<Pedido> pedidos;

    public Mesa(String numero) {
        this.numero = numero;
        this.pedidos = new ArrayList<>();
    }
    
    public String getNumero() {
        return numero;
    }

    public void entregarpedido(Pedido pedido){
        pedido.entregar();
    }
    
    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }


    public Integer calcularTotal(){
        return this.pedidos.stream()
        .map(pedido -> pedido.calcularValor())
        .reduce((a, b) -> a + b)
        .orElse(0);
        
    }    

    public Integer pago(Integer efectivo) throws PagoInsuficienteExcepcion{
        var total = calcularTotal();
        if(efectivo <= total){
            throw new PagoInsuficienteExcepcion("El efectivo no es suficiente para págar el total de la cuenta");
        }
        //Elinina los pedidos cancelados
        this.pedidos.clear();
        return efectivo - total;
    }    

    
}
