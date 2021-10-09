package com.reto.sofka.retosofka.classes;

import java.util.ArrayList;

public class Pregunta {
    private long id;
    private int categoria;
    private String texto;
    private ArrayList<Respuesta> respuestas;


    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getTexto() {
        return texto;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTexto(String titulo) {
        this.texto = titulo;
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    

   
    
    
}
