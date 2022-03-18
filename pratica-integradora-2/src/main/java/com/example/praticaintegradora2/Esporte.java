package com.example.praticaintegradora2;

import lombok.Data;

@Data
public class Esporte {
    private String nome;
    private Double nivel;

    public Esporte(String nome, Double nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }
}
