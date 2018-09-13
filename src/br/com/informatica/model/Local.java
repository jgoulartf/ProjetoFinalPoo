package br.com.informatica.model;

public class Local {
    // Attributes
    private int codigoDaPrateleira;
    private int numeroDaSessao;

    public Local(int codigoDaPrateleira, int numeroDaSessao) {
        this.codigoDaPrateleira = codigoDaPrateleira;
        this.numeroDaSessao = numeroDaSessao;
    }

    public int getCodigoDaPrateleira() { return codigoDaPrateleira; }

    public void setCodigoDaPrateleira(int codigoDaPrateleira) {
        this.codigoDaPrateleira = codigoDaPrateleira;
    }

    public int getNumeroDaSessao() {
        return numeroDaSessao;
    }

    public void setNumeroDaSessao(int numeroDaSessao) {
        this.numeroDaSessao = numeroDaSessao;
    }
}
