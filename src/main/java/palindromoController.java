import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class palindromoController {

    @GetMapping("/{nome}")
    public String nomeinvertido(@PathVariable String nome){
        nome = nome.replaceAll("\\s+", "");
        String Invertido = new StringBuilder(nome.toUpperCase()).reverse().toString();
        return Invertido;
    }
    @GetMapping("/palindromo/{palavra}")
    public String palindromo (@PathVariable String palavra){
        palavra = palavra.replaceAll("\\s+", "");
        if (palavra.toUpperCase().equals(nomeinvertido(palavra)))
            return "É um palíndromo";
        else
            return "Não é um palíndromo";
    }
}