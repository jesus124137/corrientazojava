package com.misiontic.jesusmadero.modelo;

public class Jugo {
    private String nombre;

    public Jugo(String nombre) {
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
