package br.com.exemplo.bolsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AcaoBovespaTest {

    @Test
    void observadorInscritoRecebeAtualizacao() {
        AcaoBovespa acao = new AcaoBovespa("PETR4", 30.00);
        double[] precoRecebido = new double[1];

        acao.inscrever((simbolo, precoAtual, variacaoPercentual) -> precoRecebido[0] = precoAtual);
        acao.atualizarPreco(33.00);

        assertEquals(33.00, precoRecebido[0], 0.001);
    }

    @Test
    void observadorDesinscritoNaoRecebeMaisAtualizacao() {
        AcaoBovespa acao = new AcaoBovespa("VALE3", 60.00);
        boolean[] foiNotificado = {false};
        ObservadorAcao observador = (simbolo, precoAtual, variacaoPercentual) -> foiNotificado[0] = true;

        acao.inscrever(observador);
        acao.desinscrever(observador);
        acao.atualizarPreco(65.00);

        assertTrue(!foiNotificado[0]);
    }
}
