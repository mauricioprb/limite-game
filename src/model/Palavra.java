package model;

public class Palavra {
    private String palavra;
    private String pSemAcentos;

    public Palavra(String palavra, String pSemAcentos) {
        this.palavra = palavra;
        this.pSemAcentos = pSemAcentos;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getPSemAcentos() {
        return pSemAcentos;
    }

    public void setPSemAcentos(String pSemAcentos) {
        this.pSemAcentos = pSemAcentos;
    }
}