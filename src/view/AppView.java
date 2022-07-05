package view;

import java.util.Scanner;

import model.Palavra;
import model.TratarPalavras;


public class AppView {
    public String palavraUsuario() {
        TratarPalavras tratarPalavras = new TratarPalavras();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra com 5 letras: ");
        return tratarPalavras.removerAcentos(scanner.nextLine().toUpperCase());
    }

    public void instrucao(String palavraUser, Palavra listaPalavras, String parcial) {
        String verde = "\033[1;32m";
        String amarelo = "\033[1;33m";
        String cinza = "\033[1;30m";
        String resetCor = "\033[0m";

        System.out.println("\nPalavra informada: " + palavraUser);
        System.out.println("Resposta certa: " + listaPalavras.getPalavra());
        System.out.println("\nINSTRUÇÕES:\n" + verde + "VERDE" + resetCor + ": letra existe na posição certa, " + amarelo + "AMARELO" + resetCor + ": letra existe na poisção errada, " + cinza + "CINZA/PRETO" + resetCor + ": letra não existe\n\nParcial: " + parcial + "\n");
    }
        
    public void ganhou() {
        System.out.println("PARABÉNS, VOCÊ VENCEU!");
    }

    public void perdeu(Palavra palavra) {
        System.out.println("Você errou a palavra! A palavra era: " + palavra.getPalavra());
    }
}