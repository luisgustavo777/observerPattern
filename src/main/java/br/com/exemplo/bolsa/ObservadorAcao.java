package br.com.exemplo.bolsa;

/** Interface do Observer: quem quer ser avisado de mudanças em uma ação. */
public interface ObservadorAcao {
    void atualizar(String simbolo, double precoAtual, double variacaoPercentual);
}
