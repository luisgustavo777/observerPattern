package br.com.exemplo.bolsa;

/** Observador concreto: envia push notification para o app móvel do investidor. */
public class AppMovelObserver implements ObservadorAcao {

    private final String usuario;

    public AppMovelObserver(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void atualizar(String simbolo, double precoAtual, double variacaoPercentual) {
        System.out.printf("[App Móvel -> %s] %s agora vale R$ %.2f (%.2f%%)%n",
                usuario, simbolo, precoAtual, variacaoPercentual);
    }
}
