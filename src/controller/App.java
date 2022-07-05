package controller;

import java.util.List;

import model.Palavra;
import model.TratarPalavras;
import persistence.Storage;
import view.AppView;

class App {
    public static void main(String[] args) {
        int numTentativas = 6;

        TratarPalavras tratarPalavras = new TratarPalavras();
        List<Palavra> listaPalavras = new Storage().lerArquivo();
        Palavra listaP = tratarPalavras.sortearPalavra(listaPalavras);
        AppView appView = new AppView();

        boolean erro = false;
        String palavraUser;
        
        while(numTentativas != 0) {
            System.out.println("RESTAM " + numTentativas + " TENTATIVAS\n");
            
            palavraUser = appView.palavraUsuario();

            if(palavraUser.length() < 5) {
                System.out.println("\nPALAVRA COM MENOS DE 5 LETRAS!\n");
                erro = true;
            } else if(palavraUser.length() > 5) {
                System.out.println("\nPALAVRA COM MAIS DE 5 LETRAS!\n");
                erro = true;
            } else if(!tratarPalavras.verificarPalavra(palavraUser, listaPalavras)) {
                System.out.println("Insira uma palavra existente no dicionário!\n");
                erro = true;
            } else {
                erro = false;
            }

            if(!erro) {
                int resultado = tratarPalavras.checarResultado(palavraUser, listaP);
                
                if(resultado == 5) {
                    appView.ganhou();
                    return;
                }
                numTentativas--;
            }
        }
        appView.perdeu(listaP); 
    }
}