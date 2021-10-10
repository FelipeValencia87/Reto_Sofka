package com.reto.sofka.retosofka.carga;

import com.reto.sofka.retosofka.classes.Categoria;
import com.reto.sofka.retosofka.classes.Pregunta;
import com.reto.sofka.retosofka.classes.Usuario;
import com.reto.sofka.retosofka.configuracion.PreguntasRespuestas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    
    public static void cargar() throws IOException{
        
         
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
            
            System.out.println("\t\tRonda #"+ categorias.get(it).getId() );
            System.out.println("\t***Premio de $"+ categorias.get(it).getPremio() +" USD***\n" );
            
            Pregunta pregunta = categorias.get(it).seleccionarPregunta();
            System.out.println(pregunta.getTexto());
            
            for (int i = 0; i < pregunta.getRespuestas().size(); i++) {
                
                System.out.println("\t"+(i+1)+") "+ pregunta.getRespuestas().get(i).getTexto());
                if (pregunta.getRespuestas().get(i).isCorrecta()) {
                    opcionCorrecta = i+1;
                }
            }
            
            
            System.out.println("\nSeleccione la opción correcta: ");
            opc = entrada.nextInt();
            
            while (opc < 0 || opc > 4) {
                System.out.println("Indique una opción valida, entre 1 y 4");
                opc= entrada.nextInt();
            }
            
            
            
            if (opc == opcionCorrecta) {
                System.out.println("\nFelicitaciones, Acertaste");
                participante.acumularPremio(categorias.get(it).getPremio());            
                System.out.println("Tienes un Premio Acumulado de: $" + participante.getPremio()+" USD\n");
            }else{
                System.out.println("¡¡Lo lamento!!, te quivocaste y perdiste todo");
                participante.setPremio(0);
                System.out.println("Quedaste con: $" + participante.getPremio()+" USD\n");
                break;
            }
            
            
            it++;
            
            if (it == 5) {
                System.out.println("\t\n¡¡Felicitaciones!! Respondiste todas las preguntas");
                System.out.println("Ganaste un total de: $" + participante.getPremio()+" USD\n");
                break;
            }
            
            
            System.out.println("¿Digite 1 si quiere seguir jugando o 2 para retirarse y quedarse con el premio");
            band = entrada.nextInt();
            
            while (band < 0 || band > 2) {
                System.out.println("Indique una opción valida, 1 o 2");
                band= entrada.nextInt();
            }
            
            if (band==2) {
                System.out.println("Gracias por participar, no respondiste todas las preguntas "
                        + "pero ganaste un total de: $" + participante.getPremio()+" USD\n");
                break;
            }
            System.out.println("------------------------------------");
            
        } while ( it < 5);
    }
    
}
