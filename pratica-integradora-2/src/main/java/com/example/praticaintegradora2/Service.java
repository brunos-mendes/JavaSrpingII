package com.example.praticaintegradora2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {
    List<Esporte> esportes = new ArrayList<>();
    List<Pessoa> atletas = new ArrayList<>();

    public void addSport(String nome, Double nivel) {
        Esporte newSport = new Esporte(nome, nivel);
        esportes.add(newSport);
    }

    public void addAtleta(String nome, String sobrenome, Integer idade, String sportname) {
        Esporte sport = esportes.stream().filter(e -> e.getNome().equals(sportname)).findFirst().get();
        Pessoa newPerson = new Pessoa(nome, sobrenome, idade, sport);
        atletas.add(newPerson);
    }

    public List<Esporte> getEsportes() {
        return esportes;
    }

    public Optional<Esporte> getSport(String name) {
        return esportes.stream().filter(e -> e.getNome().equals(name)).findFirst();
    }

    public List<AtletaDTO> getAtletas() {
        return atletas.stream().map(a -> {
            return new AtletaDTO(a.getNome(), a.getSobrenome(), a.getEsporte().getNome());
        }).collect(Collectors.toList());
    }
}
