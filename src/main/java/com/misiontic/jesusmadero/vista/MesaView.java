package com.misiontic.jesusmadero.vista;
import java.util.List;
import java.util.Scanner;

import com.misiontic.jesusmadero.modelo.Mesa;

public class MesaView {

    private Scanner entrada;
    
    public MesaView(Scanner entrada){
        this.entrada = entrada;
    }
    public String leerNumeroMesa(){
        System.out.println("AGREGANDO UNA NUEVA MESA :.");
        do{
        try {
            System.out.print("Ingrese el numero de la mesa: ");
            var numero = entrada.nextLine();

            return numero;
        }catch (Exception ex){
            System.err.println("Por favor ingrese un mumero valido");
            ex.printStackTrace();
            return "";
        }
    }while(true);
    }

    public void mostrarMesas(List<Mesa> mesas) {
        System.out.println("MESAS EXISTENTES :.");
        mesas.forEach(System.out::println);
    }
}