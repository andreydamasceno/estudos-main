package br.com.estudos.controller;

import br.com.estudos.service.ArquivoService;

import java.io.IOException;
import java.util.List;

public class ArquivoController {

    private ArquivoService arquivoService;

    public ArquivoController() {
        this.arquivoService = new ArquivoService();
    }

    public List<String> extrairPalavrasDoArquivo(String arquivoNome, String palavraAlvo) throws IOException {
        return arquivoService.extrairPalavras(arquivoNome, palavraAlvo);
    }
}
