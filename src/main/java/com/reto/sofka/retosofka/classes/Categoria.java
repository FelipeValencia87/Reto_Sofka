package com.reto.sofka.retosofka.classes;

import java.util.ArrayList;
import java.util.Random;


public class Categoria {
    
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    
    private Long id;
    private double premio;
    private ArrayList<Pregunta> preguntas = new ArrayList<>();
    
    public ArrayList<Pregunta> getPreguntas() {
         
        return preguntas;
    }
    
    public Pregunta seleccionarPregunta(){
        int posicion = RANDOM.nextInt(preguntas.size());
        return preguntas.get(posicion);
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }    

    public  Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    
    
    
}
