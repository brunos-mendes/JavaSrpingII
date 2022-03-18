package com.example.praticaintegradora2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    Service service = new Service();

    @GetMapping(path = "/findSports")
    public ResponseEntity<List<Esporte>> findSports() {
        try {
            return ResponseEntity.ok(service.getEsportes());
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping(path = "/findSport/{name}")
    public ResponseEntity<Double> findOneSport(@PathVariable(value = "name") String name){
        try {
            return ResponseEntity.ok(service.getSport(name).get().getNivel());
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping(path = "/findSportsPersons")
    public ResponseEntity<List<AtletaDTO>> findAthletes() {
        try {
            return ResponseEntity.ok(service.getAtletas());
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping(path = "/addSport")
    public void addSport(@RequestBody Esporte sport) {
        service.addSport(sport.getNome(), sport.getNivel());
    }

    @PostMapping(path = "/addAthlete")
    public void addSport(@RequestBody AtletaInputDTO person) {
        service.addAtleta(person.getNome(), person.getSobrenome(), person.getIdade(), person.getSportname());
    }
}
