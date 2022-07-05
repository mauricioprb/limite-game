package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Palavra;
import model.TratarPalavras;

public class Storage {
    public List<Palavra> lerArquivo() {
        List<Palavra> palavrasTratadas = new ArrayList<>();
        try {
            File arquivo = new File("src/resources/palavras.txt");
            Scanner lerArq = new Scanner(arquivo);
            while(lerArq.hasNextLine()) {
              String palavras = lerArq.nextLine().toUpperCase();
              
              if(palavras.length() == 5) {
                Palavra listaPalavras = new Palavra(palavras, new TratarPalavras().removerAcentos(palavras));
                palavrasTratadas.add(listaPalavras);
              }
            }
            lerArq.close();
          } catch(FileNotFoundException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
          }

          return palavrasTratadas;
    }
}