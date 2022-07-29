package com.misiontic.jesusmadero.modelo;

public class Bandeja extends OpcionPedido {

    public Bandeja(Integer precio) {
        super(precio);
        
    }

    public Bandeja(Integer precio, Principio principio, Carne carne, Jugo jugo) {
        super(precio, principio, carne, jugo);
    }

    public Bandeja(Integer precio, Principio principio, Carne carne, Ensalada ensalada, Jugo jugo) {
        super(precio, principio, carne, ensalada, jugo);
    }

    
}
