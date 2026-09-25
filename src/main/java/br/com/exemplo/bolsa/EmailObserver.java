package br.com.exemplo.bolsa;

/** Observador concreto: dispara um e-mail resumindo a mudança de preço. */
public class EmailObserver implements ObservadorAcao {

    private final String email;

    public EmailObserver(String email) {
        this.email = email;
    }

    @Override
    public void atualizar(String simbolo, double precoAtual, double variacaoPercentual) {
        System.out.printf("[E-mail -> %s] Assunto: Atualização de %s | Preço: R$ %.2f (%.2f%%)%n",
                email, simbolo, precoAtual, variacaoPercentual);
    }
}
