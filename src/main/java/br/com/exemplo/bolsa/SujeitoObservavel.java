package br.com.exemplo.bolsa;

/** Interface do Subject (Sujeito/Publicador) observado pelos ObservadorAcao. */
public interface SujeitoObservavel {
    void inscrever(ObservadorAcao observador);
    void desinscrever(ObservadorAcao observador);
    void notificarObservadores();
}
