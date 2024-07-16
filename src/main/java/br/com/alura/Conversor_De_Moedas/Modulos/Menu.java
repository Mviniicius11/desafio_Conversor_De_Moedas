package br.com.alura.Conversor_De_Moedas.Modulos;

import br.com.alura.Conversor_De_Moedas.Principal.Principal;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Menu {
    ConsumoApi consumo = new ConsumoApi();
    Scanner scanner = new Scanner(System.in);
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();


    int opcao = 0;
    private Double converteTaxa;
    private double valor;

    public void exibeSaudacao () {
        System.out.println("""
                            ***************************************
                            
                            Seja bem vindo ao conversor de moedas!
                            
                            Seleciona o tipo de conversâo desejada:
                            
                            1. Dólar para Real:
                            2. Real para Dolar:
                            3. Peso Argentino para Real:
                            4. Real para Peso Argentino:
                            5. Peso Argentino para Dólar:
                            6. Dólar para Peso Argentino:
                            7. Sair:
                            
                            ***************************************
                            """);
    }

    public void menuInicial() {

        Principal principal = new Principal();

        while (opcao == 0 || opcao > 7) {
            exibeSaudacao();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    principal.setMoeda1("USD");
                    principal.setMoeda2("BRL");
                    converteMoeda(principal);
                    break;
                case 2:
                    principal.setMoeda1("BRL");
                    principal.setMoeda2("USD");
                    converteMoeda(principal);
                    break;
                case 3:
                    principal.setMoeda1("ARS");
                    principal.setMoeda2("BRL");
                    converteMoeda(principal);
                    break;
                case 4:
                    principal.setMoeda1("BRL");
                    principal.setMoeda2("ARS");
                    converteMoeda(principal);
                    break;
                case 5:
                    principal.setMoeda1("ARS");
                    principal.setMoeda2("USD");
                    converteMoeda(principal);
                    break;
                case 6:
                    principal.setMoeda1("USD");
                    principal.setMoeda2("ARS");
                    converteMoeda(principal);
                    break;
                case 7:
                    System.out.println("Finalizando aplicação! ");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    opcao = 0;
            }
        }

        }


    public void converteMoeda(Principal principal) {
        String cotacao = consumo.obterCotacao(principal.getENDERECO() + principal.getAPI_KEY() + "/" + principal.getMoeda1() + "/" + principal.getMoeda2());

        ConversorApi conversorApi = gson.fromJson(cotacao, ConversorApi.class);

        System.out.println("\nQual o valor que deseja converter? \n");
        valor = scanner.nextDouble();

        converteTaxa = valor * Double.valueOf(conversorApi.conversion_rate());

        System.out.println("O total de %s convertido para %s é de %.2f.".formatted(principal.getMoeda1(), principal.getMoeda2(), converteTaxa));
    }
}
