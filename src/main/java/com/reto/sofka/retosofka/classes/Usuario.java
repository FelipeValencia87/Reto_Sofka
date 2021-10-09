package com.reto.sofka.retosofka.classes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Usuario {
    private final ObjectMapper mapper = new ObjectMapper();
    private String nombre;
    private double premio = 0;

    public Usuario(){

    }
    public Usuario(String nombre){
        this.nombre = nombre;
    }
    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void acumularPremio(double premio) {
        this.premio += premio;
    }
    
    public void guardarInfo() throws IOException{
        File archivo = new File("src/main/resources/"+nombre+".json");
        ArrayList<Usuario> historico = new ArrayList<>();
        if (archivo.exists()) {
           historico= mapper.readValue(
                getClass().getClassLoader().getResourceAsStream(archivo.getName()),
                new TypeReference<ArrayList<Usuario>>(){}
            );
        }
        historico.add(this);
        mapper.writeValue(archivo, historico);
    }

            
}
