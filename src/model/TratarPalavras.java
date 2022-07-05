package model;

import java.text.Normalizer;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import view.AppView;

public class TratarPalavras {
    public String removerAcentos(String palavras) {
        String normalizer = Normalizer.normalize(palavras, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("[^\\p{ASCII}]");
    
        return pattern.matcher(normalizer).replaceAll("");
    }

    public Palavra sortearPalavra(List<Palavra> listaPalavras) {
        Collections.shuffle(listaPalavras);
        return listaPalavras.get(0);
    }

    public boolean verificarPalavra(String palavras, List<Palavra> listaPalavras) {
        for(Palavra plvr : listaPalavras) {
            if(palavras.contains(plvr.getPSemAcentos())) {
                return true;
            } 
        }

        return false;
    }

    public int checarResultado(String palavraUser, Palavra listaPalavras) {
        char[] palavraUserChar = palavraUser.toCharArray();
        char[] listaPalavrasChar = listaPalavras.getPSemAcentos().toCharArray();

        int contador = 0;
        boolean letraExiste = false;
        String parcial = "";
        String existePosCerta = "\033[1;32m";
        String existePosErrada = "\033[1;33m";
        String naoExiste = "\033[1;30m";
        String resetCor = "\033[0m";

        for(int i = 0; i < 5; i++) {
            if(palavraUserChar[i] == listaPalavrasChar[i]) {
                parcial += existePosCerta + palavraUserChar[i] + resetCor;
                contador++;
                
            } else {
                for(int j = 0; j < 5; j++) {
                    if(palavraUserChar[i] == listaPalavrasChar[j]) {
                        letraExiste = true;
                        break;
                    }
                }
                if(letraExiste == true) {
                    parcial += existePosErrada + palavraUserChar[i] + resetCor;
                  } else {
                    parcial += naoExiste + palavraUserChar[i] + resetCor;
                  }

                  letraExiste = false;
            }
        }
        AppView appView = new AppView();
        appView.instrucao(palavraUser, listaPalavras, parcial);

        return contador;
    }
}