package com.reto.sofka.retosofka.main;
import com.reto.sofka.retosofka.carga.Juego;
import java.io.IOException;

public class RetoSofka {
    
    public static void main(String[] args) throws IOException {
        
        final String ANSI_RED = "\u001B[31m";
        System.out.println(ANSI_RED +"\t*** Quién Quiere Ser Millonario ***\n");
        Juego.cargar();
        
    }
    
}
