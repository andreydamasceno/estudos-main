package br.com.estudos;

import br.com.estudos.controller.ArquivoController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LerArquivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArquivoController fileController = new ArquivoController();
        String arquivoNome = "/C://Users//andre//Downloads//teste01.txt/"; // Substitua pelo nome do seu arquivo
        System.out.println("Quer encontrar alguma palavra? Digite sim ou não: ");
        String querProcurarPalavra = scanner.nextLine(); // A palavra que você deseja extrair

        if (!querProcurarPalavra.equals("sim")) {
            System.out.println("Até a próxima!");;
        } else {

            while (querProcurarPalavra.equals("sim")) {

                System.out.println("Qual palavra deseja encontrar?");
                String palavraAlvo = scanner.nextLine(); // A palavra que você deseja extrair
                try {
                    List<String> palavrasEncontradas = fileController.extrairPalavrasDoArquivo(arquivoNome, palavraAlvo);

                    if (!palavrasEncontradas.isEmpty()) {
                        System.out.println("Palavras encontradas:");
                        for (String palavra : palavrasEncontradas) {
                            System.out.println(palavra);
                        }
                    } else {
                        System.out.println("Nenhuma palavra encontrada.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Deseja encontrar outra palavra? Digite sim ou não:");
                querProcurarPalavra = scanner.nextLine();
                if (!querProcurarPalavra.equals("sim")) {
                    System.out.println("Programa finalizado com sucesso! Até a próxima!");
                    break;
                }
            }
        }
        scanner.close();
    }
}
