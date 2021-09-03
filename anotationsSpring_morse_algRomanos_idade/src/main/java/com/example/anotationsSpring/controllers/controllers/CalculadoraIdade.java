package com.example.anotationsSpring.controllers.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class CalculadoraIdade {
    Calendar calendario = Calendar.getInstance();

    //chamada -> http://localhost:8080/01/05/1991
    @GetMapping("/{dia}/{mes}/{ano}")
    public String data(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano) {
        int diaAtual = calendario.get(Calendar.DAY_OF_MONTH);
        int mesAtual = (calendario.get(Calendar.MONTH) + 1);
        int anoAtual = calendario.get(Calendar.YEAR);
        int idade;

        if (mes < mesAtual) {
                idade = anoAtual - ano;
            }
        else if (mes == mesAtual) {
            if (dia <= diaAtual) {
                idade = anoAtual - ano ;
            }else {
                idade = anoAtual-ano-1;
            }
        } else {
            idade = anoAtual - ano - 1;
        }
        return "Data de Nascimento: "+dia+"/"+mes+"/"+ano+", Idade Atual : "+ idade+" anos";
    }
}
