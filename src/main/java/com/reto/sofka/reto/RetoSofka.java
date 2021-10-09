package com.reto.sofka.reto;

import com.reto.sofka.retosofka.classes.Categoria;
import com.reto.sofka.retosofka.classes.Pregunta;
import com.reto.sofka.retosofka.classes.Usuario;
import com.reto.sofka.retosofka.configuracion.PreguntasRespuestas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RetoSofka {
    
    public static void main(String[] args) throws IOException {
        final String ANSI_RED = "\u001B[31m";
        Scanner entrada = new Scanner(System.in);
        PreguntasRespuestas ronda = new PreguntasRespuestas(); 
        ArrayList<Usuario> participantes = new ArrayList<>();
        ArrayList<Categoria> categorias;
        String nombreParticipante;
        int it=0,band, opc, opcionCorrecta = 0;
                 
        ronda.cargarCategorias();
        ronda.cargarPreguntas();
        categorias = ronda.asignarPreguntas();
       
        System.out.println("Nombre del Participante");
        nombreParticipante = entrada.next();
        Usuario participante = new Usuario(nombreParticipante);
        
        do {         
            
            System.out.println(ANSI_RED +"\t\tRonda #"+ categorias.get(it).getId() );
            System.out.println("\t***Premio de $"+ categorias.get(it).getPremio() +" USD***\n" );
            
            Pregunta pregunta = categorias.get(it).seleccionarPregunta();
            System.out.println(pregunta.getTexto());
            
            for (int i = 0; i < pregunta.getRespuestas().size(); i++) {
                
                System.out.println((i+1)+") "+ pregunta.getRespuestas().get(i).getTexto());
                if (pregunta.getRespuestas().get(i).isCorrecta()) {
                    opcionCorrecta = i+1;
                }
            }
            System.out.println("Seleccioné la opción correcta: ");
            opc = entrada.nextInt();
            
            if (opc == opcionCorrecta) {
                System.out.println("Felicitaciones, ");
                participante.acumularPremio(categorias.get(it).getPremio());            
                System.out.println("Premio Acumulado: $" + participante.getPremio()+" USD\n");
            }else{
                System.out.println("Perdiste todo");
                break;
            }
            
            
            
            
            System.out.println("¿Digite 1 para continuar, 2 para retirarse");
            band = entrada.nextInt();
            it++;
            
            
        } while (band ==1 && it < 6);
        
//        participante.guardarInfo();
    }
    
}
