package com.example.anotationsSpring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class RomanosController {

    public int[] decimal = {1000000000, 1000000, 900000, 500000, 400000, 100000, 50000, 40000, 10000, 9000, 8000, 7000, 6000, 5000, 4000, 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String[] romano = {"1_000_001_000", "1_000_000", "9_000_000", "500_000", "400_000", "100_000", "50_000", "40_000", "10_000", "9_000", "8_000", "7_000", "6_000", "5_000", "4_000", "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    //chamada -> http://localhost:8080/convParaRomano/675496
    @GetMapping("convParaRomano/{number}")
    public String roman(@PathVariable int number) {
        StringBuilder romans = new StringBuilder();
        int descimal = number;
        for (int i = 0; i < decimal.length; i++) {
            while (number >= decimal[i]) {
                number -= decimal[i];
                romans.append(romano[i]);
            }
        }

        romans = new StringBuilder(romans.toString().replace("4_000", "<span style=\"text-decoration:overline;\">IV</span>"));
        romans = new StringBuilder(romans.toString().replace("5_000", "<span style=\"text-decoration:overline;\">V</span>"));
        romans = new StringBuilder(romans.toString().replace("6_000", "<span style=\"text-decoration:overline;\">VI</span>"));
        romans = new StringBuilder(romans.toString().replace("7_000", "<span style=\"text-decoration:overline;\">VII</span>"));
        romans = new StringBuilder(romans.toString().replace("8_000", "<span style=\"text-decoration:overline;\">VIII</span>"));
        romans = new StringBuilder(romans.toString().replace("9_000", "<span style=\"text-decoration:overline;\">IX</span>"));
        romans = new StringBuilder(romans.toString().replace("10_000", "<span style=\"text-decoration:overline;\">X</span>"));
        romans = new StringBuilder(romans.toString().replace("40_000", "<span style=\"text-decoration:overline;\">XL</span>"));
        romans = new StringBuilder(romans.toString().replace("50_000", "<span style=\"text-decoration:overline;\">L</span>"));
        romans = new StringBuilder(romans.toString().replace("90_000", "<span style=\"text-decoration:overline;\">XC</span>"));
        romans = new StringBuilder(romans.toString().replace("100_000", "<span style=\"text-decoration:overline;\">C</span>"));
        romans = new StringBuilder(romans.toString().replace("400_000", "<span style=\"text-decoration:overline;\">CD</span>"));
        romans = new StringBuilder(romans.toString().replace("500_000", "<span style=\"text-decoration:overline;\">D</span>"));
        romans = new StringBuilder(romans.toString().replace("900_000", "<span style=\"text-decoration:overline;\">CM</span>"));
        romans = new StringBuilder(romans.toString().replace("1_000_000", "<span style=\"text-decoration:overline;\">M</span>"));
        romans = new StringBuilder(romans.toString().replace("1_000_001_000", "<span style=\"text-decoration:overline double;\">M</span>"));

        return "Número inteiro: " + descimal + "<br><br>Numeral romano: " + romans;
    }


}
