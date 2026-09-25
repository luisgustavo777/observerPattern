package br.com.exemplo.bolsa;

/** Observador concreto: atualiza um painel/dashboard exibido em tela. */
public class PainelInvestidorObserver implements ObservadorAcao {

    private double ultimoPrecoExibido;

    @Override
    public void atualizar(String simbolo, double precoAtual, double variacaoPercentual) {
        this.ultimoPrecoExibido = precoAtual;
        String seta = variacaoPercentual >= 0 ? "▲" : "▼";
        System.out.printf("[Painel do Investidor] %s %s R$ %.2f%n", simbolo, seta, ultimoPrecoExibido);
    }
}
