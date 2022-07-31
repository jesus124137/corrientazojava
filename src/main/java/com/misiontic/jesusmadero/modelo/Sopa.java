package com.misiontic.jesusmadero.modelo;

public class Sopa {
    private String nombre;

    public Sopa(String nombre) {
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
