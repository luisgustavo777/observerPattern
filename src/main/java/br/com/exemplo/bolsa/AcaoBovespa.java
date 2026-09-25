package br.com.exemplo.bolsa;

import java.util.ArrayList;
import java.util.List;

/**
 * Sujeito concreto: representa uma ação negociada na bolsa.
 * Sempre que o preço muda, notifica automaticamente todos os observadores
 * inscritos (app móvel, e-mail, painel do investidor, alertas de trader...).
 */
public class AcaoBovespa implements SujeitoObservavel {

    private final String simbolo;
    private double precoAtual;
    private double precoAnterior;
    private final List<ObservadorAcao> observadores = new ArrayList<>();

    public AcaoBovespa(String simbolo, double precoInicial) {
        this.simbolo = simbolo;
        this.precoAtual = precoInicial;
        this.precoAnterior = precoInicial;
    }

    @Override
    public void inscrever(ObservadorAcao observador) {
        observadores.add(observador);
    }

    @Override
    public void desinscrever(ObservadorAcao observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        double variacao = ((precoAtual - precoAnterior) / precoAnterior) * 100;
        for (ObservadorAcao observador : observadores) {
            observador.atualizar(simbolo, precoAtual, variacao);
        }
    }

    /** Atualiza a cotação e dispara a notificação para todos os observadores. */
    public void atualizarPreco(double novoPreco) {
        this.precoAnterior = this.precoAtual;
        this.precoAtual = novoPreco;
        notificarObservadores();
    }

    public String getSimbolo() {
        return simbolo;
    }
}
