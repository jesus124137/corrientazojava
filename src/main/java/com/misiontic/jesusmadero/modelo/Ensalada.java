package com.misiontic.jesusmadero.modelo;

public class Ensalada {
    private String nombre;

    public Ensalada(String nombre) {
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
