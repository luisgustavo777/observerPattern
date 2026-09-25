package br.com.exemplo.bolsa;

/**
 * Observador concreto com lógica própria: só dispara um alerta sonoro/crítico
 * quando a variação ultrapassa um limite configurado pelo trader.
 */
public class AlertaTraderObserver implements ObservadorAcao {

    private final double limiteVariacaoPercentual;

    public AlertaTraderObserver(double limiteVariacaoPercentual) {
        this.limiteVariacaoPercentual = limiteVariacaoPercentual;
    }

    @Override
    public void atualizar(String simbolo, double precoAtual, double variacaoPercentual) {
        if (Math.abs(variacaoPercentual) >= limiteVariacaoPercentual) {
            System.out.printf("[ALERTA TRADER] %s variou %.2f%% — limite de %.2f%% atingido! Preço: R$ %.2f%n",
                    simbolo, variacaoPercentual, limiteVariacaoPercentual, precoAtual);
        }
    }
}
