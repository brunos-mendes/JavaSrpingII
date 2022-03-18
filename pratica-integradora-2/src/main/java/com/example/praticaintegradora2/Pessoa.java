package com.example.praticaintegradora2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private String nome;
    private String sobrenome;
    private Integer idade;
    private Esporte esporte;
}
