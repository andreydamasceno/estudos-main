package br.com.estudos.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArquivoService {
    public List<String> extrairPalavras(String arquivoNome, String palavraAlvo) throws IOException {
        List<String> palavrasEncontradas = new ArrayList<>();

        // Usar uma expressão regular para encontrar a palavra alvo no meio de outras palavras e caracteres
        String padrao = "\\b" + Pattern.quote(palavraAlvo) + "\\b"; // \b indica uma fronteira de palavra
        Pattern pattern = Pattern.compile(padrao, Pattern.CASE_INSENSITIVE);

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoNome))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(linha);
                while (matcher.find()) {
                    palavrasEncontradas.add(matcher.group());
                }
            }
        }

        return palavrasEncontradas;
    }
}
