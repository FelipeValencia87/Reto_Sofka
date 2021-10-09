package com.reto.sofka.retosofka.configuracion;

import com.reto.sofka.retosofka.classes.Categoria;
import com.reto.sofka.retosofka.classes.Pregunta;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;


public class PreguntasRespuestas {
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Categoria> categorias;
    private ArrayList<Pregunta> preguntas;
    

    public void cargarCategorias() throws JsonProcessingException, IOException {
        categorias = mapper.readValue(
                getClass().getClassLoader().getResourceAsStream("categorias.json"),
                new TypeReference<ArrayList<Categoria>>(){}
        );
    }
    
    public void cargarPreguntas() throws JsonProcessingException, IOException {
        preguntas = mapper.readValue(
                getClass().getClassLoader().getResourceAsStream("preguntas.json"),
                new TypeReference<ArrayList<Pregunta>>(){}
        );
        
    }
    
    
    public ArrayList<Categoria> asignarPreguntas(){
        
        for (int i = 0; i < categorias.size(); i++) {
             ArrayList<Pregunta> preguntasFiltradas = new ArrayList<>();
            
            for (int j = 0; j < preguntas.size(); j++) {
                if (preguntas.get(j).getCategoria() == categorias.get(i).getId()) {
                    
                    preguntasFiltradas.add(preguntas.get(j));                    
                    
                }                
            }
            categorias.get(i).setPreguntas(preguntasFiltradas);
        }
        
        return categorias;
    }

    
    
}
