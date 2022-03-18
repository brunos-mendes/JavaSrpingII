package com.example.praticaintegradora1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDate;

@RestController
public class Controller {
    @PostMapping(path = "/{d}/{m}/{a}")
    public ResponseEntity<Long> getAge(@PathVariable(value = "d") String d, @PathVariable(value = "m") String m, @PathVariable(value = "a") String a) {
        LocalDate d1 = LocalDate.of(Integer.parseInt(a), Integer.parseInt(m),Integer.parseInt(d));
        LocalDate d2 = LocalDate.now();
        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        Long diffDays = diff.toDays()/365;

        return ResponseEntity.status(200).body(diffDays);
    }
}
