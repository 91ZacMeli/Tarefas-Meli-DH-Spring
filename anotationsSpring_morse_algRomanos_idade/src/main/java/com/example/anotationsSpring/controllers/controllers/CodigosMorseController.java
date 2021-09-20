package com.example.anotationsSpring.controllers.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigosMorseController {

    //chamada-> http://localhost:8080/morse?codigo=-- . .-. -.-. .- -.. --- / .-.. .. ...- .-. .
    @GetMapping("/morse")
    public String codigoMorse(@RequestParam String codigo) {

        String[] cdgsMorses = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--..", " "};

        String textoMorse = codigo.trim();
        String textoDecodificado = "";

        String[] posicao = textoMorse.split(" ");
        String trecho;

        if (codigo.length() == 0) {
            System.out.println("Valor invalido");
        } else {
            for (int i = 0; i < posicao.length; i++) {
                int idx = textoMorse.indexOf(" ") == -1 ? textoMorse.length() : textoMorse.indexOf(" ");
                trecho = textoMorse.substring(0, idx);
                textoMorse = textoMorse.substring(trecho.length()).trim();
                if (trecho.equals("/")) {
                    textoDecodificado += " ";
                } else {
                    for (int j = 0; j < cdgsMorses.length; j++) {
                        if (cdgsMorses[j].equals(trecho)) {
                            textoDecodificado += getLetra(j);
                            break;
                        }
                    }
                }
            }
        }
        return textoDecodificado.toUpperCase();
    }

    public static String getLetra(Integer indice) {
        String[] letraEquivalente = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?", " "};

        return letraEquivalente[indice];

    }
}



