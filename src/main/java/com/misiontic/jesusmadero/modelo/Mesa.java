package com.misiontic.jesusmadero.modelo;

import java.util.ArrayList;
import java.util.List;

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

    public Integer pago(Integer efectivo){
        var total = calcularTotal();
        if(efectivo <= total){
            //TODO: Lanzar excepcion por fondos insuficientes
        }
        //TODO: eliminar pedido
        this.pedidos.clear();
        //TODO: pagar pedido
        return efectivo - total;
    }    

    
}
