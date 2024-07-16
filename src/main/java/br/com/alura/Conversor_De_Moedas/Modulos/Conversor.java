package br.com.alura.Conversor_De_Moedas.Modulos;

public class Conversor {
    private String moedaOrigem;
    private String moedaDestino;
    private String conversao;

    public Conversor(ConversorApi conversorApi){
        this.moedaOrigem = conversorApi.base_code();
        this.moedaDestino = conversorApi.target_code();
        this.conversao = conversorApi.conversion_rate();
    }

    @Override
    public String toString() {
        return """
                Moeda base: %s
                Moeda destino: %s
                Conversão: %s
                """ .formatted(this.moedaOrigem,
                this.moedaDestino,
                this.conversao);
    }
}
