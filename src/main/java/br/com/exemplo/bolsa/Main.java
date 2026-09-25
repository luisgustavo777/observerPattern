package br.com.exemplo.bolsa;

/**
 * Demonstração do padrão Observer: uma ação da bolsa (Subject) notifica,
 * de forma desacoplada, vários observadores interessados em suas variações
 * de preço, sem que a ação precise conhecer os detalhes de cada um.
 */
public class Main {
    public static void main(String[] args) {
        AcaoBovespa petr4 = new AcaoBovespa("PETR4", 38.20);

        ObservadorAcao appJoao = new AppMovelObserver("joao.silva");
        ObservadorAcao emailMaria = new EmailObserver("maria@exemplo.com");
        ObservadorAcao painel = new PainelInvestidorObserver();
        ObservadorAcao alertaTrader = new AlertaTraderObserver(2.0); // só alerta se variar >= 2%

        petr4.inscrever(appJoao);
        petr4.inscrever(emailMaria);
        petr4.inscrever(painel);
        petr4.inscrever(alertaTrader);

        System.out.println("=== Pregão abre, PETR4 sobe suavemente ===");
        petr4.atualizarPreco(38.60); // variação pequena, sem alerta de trader

        System.out.println("\n=== Notícia forte no mercado, PETR4 dispara ===");
        petr4.atualizarPreco(40.10); // variação > 2%, alerta de trader dispara

        System.out.println("\n=== João Silva desativa notificações no app ===");
        petr4.desinscrever(appJoao);
        petr4.atualizarPreco(39.50);
    }
}
