package com.misiontic.jesusmadero.modelo;

public class Carne {
    private String nombre;

    public Carne(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }    

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nombre;
    }
}
