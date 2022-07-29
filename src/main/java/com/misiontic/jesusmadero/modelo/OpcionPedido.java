package com.misiontic.jesusmadero.modelo;

public abstract class OpcionPedido {
    private Integer precio;
    private Principio principio;
    private Carne carne;
    private Ensalada ensalada;
    private Jugo jugo;

    public OpcionPedido(Integer precio, Principio principio, Carne carne, Jugo jugo) {
        this.precio = precio;
        this.principio = principio;
        this.carne = carne;
        this.jugo = jugo;
    }

    public OpcionPedido(Integer precio, Principio principio, Carne carne, Ensalada ensalada, Jugo jugo) {
        this.precio = precio;
        this.principio = principio;
        this.carne = carne;
        this.ensalada = ensalada;
        this.jugo = jugo;
    }

    public OpcionPedido(Integer precio){
        this.precio = precio;
    }    

    public Integer getPrecio() {
        return precio;
    }

    public Principio getPrincipio() {
        return principio;
    }

    public void setPrincipio(Principio principio) {
        this.principio = principio;
    }

    public Carne getCarne() {
        return carne;
    }

    public void setCarne(Carne carne) {
        this.carne = carne;
    }

    public Ensalada getEnsalada() {
        return ensalada;
    }

    public void setEnsalada(Ensalada ensalada) {
        this.ensalada = ensalada;
    }

    public Jugo getJugo() {
        return jugo;
    }

    public void setJugo(Jugo jugo) {
        this.jugo = jugo;
    }    
}
